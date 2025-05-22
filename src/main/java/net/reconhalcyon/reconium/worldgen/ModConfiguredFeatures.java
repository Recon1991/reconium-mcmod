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

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MOONSTONE_ORE_KEY = registerKey("moonstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_MOONSTONE_ORE_KEY = registerKey("moonstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_MOONSTONE_ORE_KEY = registerKey("moonstone_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldMoonstoneOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.MOONSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MOONSTONE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_MOONSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMoonstoneOres, 6));
        register(context, NETHER_MOONSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_MOONSTONE_ORE.get().defaultBlockState(), 6));
        register(context, END_MOONSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.END_MOONSTONE_ORE.get().defaultBlockState(), 6));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Reconium.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}