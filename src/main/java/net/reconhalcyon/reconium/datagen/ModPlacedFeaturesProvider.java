package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.util.ModOrePlacement;

import java.util.concurrent.CompletableFuture;

public class ModPlacedFeaturesProvider implements DataProvider {

    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public ModPlacedFeaturesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        this.output = output;
        this.registries = registries;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return registries.thenCompose(provider -> {
            for (ModGemOreGenSettings gem : ModConfiguredFeatures.GEM_ORE_SETTINGS) {
                ResourceLocation placedId = new ResourceLocation(Reconium.MOD_ID, "ore_" + gem.name() + "_placed");
                ResourceLocation configuredId = new ResourceLocation(Reconium.MOD_ID, "ore_" + gem.name());
                ResourceKey<ConfiguredFeature<?, ?>> configuredKey = ResourceKey.create(
                        net.minecraft.core.registries.Registries.CONFIGURED_FEATURE, configuredId);

                Holder<ConfiguredFeature<?, ?>> configuredHolder = provider.lookupOrThrow(
                        net.minecraft.core.registries.Registries.CONFIGURED_FEATURE).getOrThrow(configuredKey);

                PlacedFeature placedFeature = new PlacedFeature(
                        Holder.hackyErase(configuredHolder),
                        ModOrePlacement.commonOrePlacement(
                                gem.veinsPerChunk(),
                                HeightRangePlacement.triangle(gem.minY(), gem.maxY())
                        )
                );

                DataProviderUtils.writePlacedFeatureJson(output, provider, placedId, placedFeature, cache);
            }
            return CompletableFuture.completedFuture(null);
        });
    }

    @Override
    public String getName() {
        return "Reconium Placed Features";
    }
}
