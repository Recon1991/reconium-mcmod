/*╭──────────────────────────────────────────────────────
│ [:: Halcyon Module ::] 
│ > Mod ID: Reconium >> 
│ > Purpose: Configured Features for World Generation
│ 🤖 Handler: Tachikoma System Core
╰──────────────────────────────────────────────────────  */
package net.reconhalcyon.reconium.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemOreGenSettings;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemSettings;

import java.util.List;
import java.util.ArrayList;

public class ModConfiguredFeatures {
    // List of all gem settings (add more gems here as needed)
    public static final List<GemSettings> GEM_SETTINGS = List.of(
        new GemSettings(
            "moonstone",
            List.of(
                new GemOreGenSettings(
                    "overworld",
                    ModBlocks.MOONSTONE_ORE.get(),
                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                    6, 7,
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(-32),
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(128),
                    net.minecraft.tags.BiomeTags.IS_OVERWORLD
                ),
                new GemOreGenSettings(
                    "deepslate",
                    ModBlocks.DEEPSLATE_MOONSTONE_ORE.get(),
                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                    6, 7,
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(-32),
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(128),
                    net.minecraft.tags.BiomeTags.IS_OVERWORLD
                ),
                new GemOreGenSettings(
                    "nether",
                    ModBlocks.NETHER_MOONSTONE_ORE.get(),
                    new BlockMatchTest(Blocks.NETHERRACK),
                    5, 5,
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(0),
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(128),
                    net.minecraft.tags.BiomeTags.IS_NETHER
                ),
                new GemOreGenSettings(
                    "end",
                    ModBlocks.END_MOONSTONE_ORE.get(),
                    new BlockMatchTest(Blocks.END_STONE),
                    4, 3,
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(32),
                    net.minecraft.world.level.levelgen.VerticalAnchor.aboveBottom(128),
                    net.minecraft.tags.BiomeTags.IS_END
                )
            )
        )
        // Add more GemSettings for other gems here
    );

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        for (GemSettings gem : GEM_SETTINGS) {
            for (GemOreGenSettings variant : gem.variants()) {
                String keyName = gem.gemName() + "_" + variant.variant() + "_ore";
                ResourceKey<ConfiguredFeature<?, ?>> key = registerKey(keyName);
                OreConfiguration.TargetBlockState target = OreConfiguration.target(
                    variant.ruleTest(),
                    variant.oreBlock().defaultBlockState()
                );
                OreConfiguration config = new OreConfiguration(
                    List.of(target),
                    variant.veinSize()
                );
                register(context, key, Feature.ORE, config);
            }
        }
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Reconium.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

