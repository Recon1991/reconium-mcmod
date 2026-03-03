/*╭──────────────────────────────────────────────────────
│ [:: Halcyon Module ::] 
│ > Mod ID: Reconium >> 
│ > Purpose: Descriptor
│ 🤖 Handler: Tachikoma System Core */
package net.reconhalcyon.reconium.worldgen;
/*╰──────────────────────────────────────────────────────  */

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemOreGenSettings;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemSettings;

public class ModBiomeModifiers {

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        for (GemSettings gem : ModConfiguredFeatures.GEM_SETTINGS) {
            for (GemOreGenSettings variant : gem.variants()) {
                String keyName = "add_" + gem.gemName() + "_" + variant.variant() + "_ore";
                ResourceKey<BiomeModifier> biomeModKey = registerKey(keyName);
                String placedKeyName = gem.gemName() + "_" + variant.variant() + "_ore_placed";
                ResourceKey<net.minecraft.world.level.levelgen.placement.PlacedFeature> placedKey = ModPlacedFeatures.registerKey(placedKeyName);
                context.register(biomeModKey, new BiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(variant.biomeTag()),
                    net.minecraft.core.HolderSet.direct(placedFeatures.getOrThrow(placedKey)),
                    net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES
                ));
            }
        }
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Reconium.MOD_ID, name));
    }
}





