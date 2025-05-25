package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModConfiguredFeatureProvider implements DataProvider {

    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;
    private final List<ModGemOreGenSettings> gemSettings;

    public ModConfiguredFeatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, List<ModGemOreGenSettings> gemSettings) {
        this.output = output;
        this.registries = registries;
        this.gemSettings = gemSettings;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return registries.thenCompose(provider -> {
            for (ModGemOreGenSettings gem : gemSettings) {
                ResourceLocation id = new ResourceLocation(Reconium.MOD_ID, "ore_" + gem.name());
                ConfiguredFeature<?, ?> feature = new ConfiguredFeature<>(Feature.ORE,
                        new OreConfiguration(List.of(
                                OreConfiguration.target(gem.ruleTest(), gem.oreBlock().defaultBlockState())
                        ), gem.veinSize()));

                // You would call your JSON output utility here. Placeholder:
                DataProviderUtils.writeConfiguredFeatureJson(output, provider, id, feature, cache);
            }
            return CompletableFuture.completedFuture(null);
        });
    }

    @Override
    public @NotNull String getName() {
        return "Reconium Configured Features";
    }
}
