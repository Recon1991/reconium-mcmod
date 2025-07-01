/*╭──────────────────────────────────────────────────────
│ [:: Halcyon Module ::] 
│ > Mod ID: Reconium >> 
│ > Purpose: Configured Features for World Generation
│ 🤖 Handler: Tachikoma System Core
╰──────────────────────────────────────────────────────  */
package net.reconhalcyon.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.biome.Biome;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemOreGenSettings;
import net.reconhalcyon.reconium.worldgen.ModGemOreGenSettings.GemSettings;

import java.util.List;

public class ModConfiguredFeatures {
    // Helper to create a GemOreGenSettings with common defaults
    private static GemOreGenSettings oreVariant(String variant, Block block, RuleTest ruleTest, int veinSize, int veinsPerChunk, VerticalAnchor minY, VerticalAnchor maxY, TagKey<Biome> biomeTag) {
        return new GemOreGenSettings(
            variant,
            block,
            ruleTest,
            veinSize,
            veinsPerChunk,
            minY,
            maxY,
            biomeTag
        );
    }

    // List of all gem settings and values
    public static final List<GemSettings> GEM_SETTINGS = List.of(
        new GemSettings("moonstone", List.of(
            oreVariant("overworld", ModBlocks.MOONSTONE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(64), VerticalAnchor.absolute(256), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_MOONSTONE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(64), VerticalAnchor.absolute(256), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("grey_quartz", List.of(
            oreVariant("overworld", ModBlocks.GREY_QUARTZ_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(40), VerticalAnchor.absolute(160), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_GREY_QUARTZ_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(40), VerticalAnchor.absolute(160), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("hematite", List.of(
            oreVariant("overworld", ModBlocks.HEMATITE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_HEMATITE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("onyx", List.of(
            oreVariant("nether", ModBlocks.NETHER_ONYX_ORE.get(), new BlockMatchTest(Blocks.NETHERRACK), 5, 5, VerticalAnchor.absolute(10), VerticalAnchor.absolute(128), BiomeTags.IS_NETHER)
        )),
        new GemSettings("zircon", List.of(
            oreVariant("overworld", ModBlocks.ZIRCON_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(20), VerticalAnchor.absolute(128), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_ZIRCON_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(20), VerticalAnchor.absolute(128), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("ruby", List.of(
            oreVariant("overworld", ModBlocks.RUBY_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(16), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_RUBY_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(16), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("topaz", List.of(
            oreVariant("overworld", ModBlocks.TOPAZ_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(30), VerticalAnchor.absolute(100), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(30), VerticalAnchor.absolute(100), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("citrine", List.of(
            oreVariant("overworld", ModBlocks.CITRINE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(32), VerticalAnchor.absolute(128), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_CITRINE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(32), VerticalAnchor.absolute(128), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("peridot", List.of(
            oreVariant("overworld", ModBlocks.PERIDOT_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(20), VerticalAnchor.absolute(100), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_PERIDOT_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(20), VerticalAnchor.absolute(100), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("jade", List.of(
            oreVariant("overworld", ModBlocks.JADE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(-32), VerticalAnchor.absolute(64), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_JADE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(-32), VerticalAnchor.absolute(64), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("turquoise", List.of(
            oreVariant("overworld", ModBlocks.TURQUOISE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(16), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_TURQUOISE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(16), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("larimar", List.of(
            oreVariant("overworld", ModBlocks.LARIMAR_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(5), VerticalAnchor.absolute(64), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_LARIMAR_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(5), VerticalAnchor.absolute(64), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("sapphire", List.of(
            oreVariant("overworld", ModBlocks.SAPPHIRE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(-48), VerticalAnchor.absolute(24), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(-48), VerticalAnchor.absolute(24), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("sugilite", List.of(
            oreVariant("end", ModBlocks.END_SUGILITE_ORE.get(), new BlockMatchTest(Blocks.END_STONE), 4, 3, VerticalAnchor.absolute(0), VerticalAnchor.absolute(128), BiomeTags.IS_END)
        )),
        new GemSettings("spinel", List.of(
            oreVariant("end", ModBlocks.END_SPINEL_ORE.get(), new BlockMatchTest(Blocks.END_STONE), 4, 3, VerticalAnchor.absolute(16), VerticalAnchor.absolute(128), BiomeTags.IS_END)
        )),
        new GemSettings("pink_diamond", List.of(
            oreVariant("overworld", ModBlocks.PINK_DIAMOND_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(0), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_PINK_DIAMOND_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(0), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("seraphinite", List.of(
            oreVariant("overworld", ModBlocks.SERAPHINITE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(20), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_SERAPHINITE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(20), VerticalAnchor.absolute(96), BiomeTags.IS_OVERWORLD)
        )),
        new GemSettings("watermelon_tourmaline", List.of(
            oreVariant("overworld", ModBlocks.WATERMELON_TOURMALINE_ORE.get(), new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(10), VerticalAnchor.absolute(90), BiomeTags.IS_OVERWORLD),
            oreVariant("deepslate", ModBlocks.DEEPSLATE_WATERMELON_TOURMALINE_ORE.get(), new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), 6, 7, VerticalAnchor.absolute(10), VerticalAnchor.absolute(90), BiomeTags.IS_OVERWORLD)
        ))
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

    //unchecked//
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

