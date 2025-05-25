package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.util.ModOrePlacement;
import net.reconhalcyon.reconium.worldgen.ModConfiguredFeatures;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBiomeModifiersProvider implements DataProvider {

    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public ModBiomeModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        this.output = output;
        this.registries = registries;
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cache) {
        return registries.thenCompose(provider -> {
// Get the biome registry lookup
            HolderLookup<Biome> biomeLookup = provider.lookupOrThrow(net.minecraft.core.registries.Registries.BIOME);

            for (ModGemOreGenSettings gem : ModConfiguredFeatures.GEM_ORE_SETTINGS) {
                ResourceLocation placedId = new ResourceLocation(Reconium.MOD_ID, "ore_" + gem.name() + "_placed");
                ResourceKey<PlacedFeature> placedKey = ResourceKey.create(
                        net.minecraft.core.registries.Registries.PLACED_FEATURE, placedId);

                Holder<PlacedFeature> placedHolder = provider.lookupOrThrow(
                        net.minecraft.core.registries.Registries.PLACED_FEATURE).getOrThrow(placedKey);

                // Convert TagKey<Biome> to HolderSet<Biome>
                HolderSet<Biome> biomeSet = biomeLookup.getOrThrow(gem.biomeTag());

                ForgeBiomeModifiers.AddFeaturesBiomeModifier modifier = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomeSet,
                        HolderSet.direct(placedHolder),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                );

                ResourceLocation modifierId = new ResourceLocation(Reconium.MOD_ID, "add_ore_" + gem.name());
                DataProviderUtils.writeBiomeModifierJson(output, provider, modifierId, modifier, cache);
            }
            return CompletableFuture.completedFuture(null);
        });
    }

    @Override
    public @NotNull String getName() {
        return "Reconium Biome Modifiers";
    }
}
