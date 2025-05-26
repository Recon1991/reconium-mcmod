/*╭──────────────────────────────────────────────────────
│ [:: Halcyon Module ::] 
│ > Mod ID: Reconium >> 
│ > Purpose: Descriptor
│ 🤖 Handler: Tachikoma System Core */
package net.reconhalcyon.reconium.worldgen;
/*╰──────────────────────────────────────────────────────  */

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemOreGenSettings;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemSettings;
import net.reconhalcyon.reconium.worldgen.ModConfiguredFeatures;

import java.util.List;

public class ModPlacedFeatures {
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        for (GemSettings gem : ModConfiguredFeatures.GEM_SETTINGS) {
            for (GemOreGenSettings variant : gem.variants()) {
                String keyName = gem.gemName() + "_" + variant.variant() + "_ore_placed";
                ResourceKey<PlacedFeature> placedKey = registerKey(keyName);
                String configuredKeyName = gem.gemName() + "_" + variant.variant() + "_ore";
                ResourceKey<ConfiguredFeature<?, ?>> configuredKey = ModConfiguredFeatures.registerKey(configuredKeyName);
                Holder<ConfiguredFeature<?, ?>> configuredHolder = configuredFeatures.getOrThrow(configuredKey);
                // Placement settings can be customized per variant if needed
                List<PlacementModifier> modifiers = ModOrePlacement.commonOrePlacement(
                    variant.veinsPerChunk(),
                    HeightRangePlacement.uniform(variant.minY(), variant.maxY())
                );
                register(context, placedKey, configuredHolder, modifiers);
            }
        }
    }

    // Changed from private to public for cross-class access
    public static ResourceKey<PlacedFeature> registerKey(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Reconium.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
