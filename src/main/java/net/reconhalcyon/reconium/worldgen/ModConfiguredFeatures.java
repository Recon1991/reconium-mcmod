package net.reconhalcyon.reconium.worldgen;

import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.reconhalcyon.reconium.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<ModGemOreGenSettings> GEM_ORE_SETTINGS = List.of(
            new ModGemOreGenSettings(
                    "moonstone_overworld",
                    ModBlocks.MOONSTONE_ORE.get(),
                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                    6, 7,
                    VerticalAnchor.aboveBottom(-32),
                    VerticalAnchor.aboveBottom(128),
                    BiomeTags.IS_OVERWORLD
            ),
            new ModGemOreGenSettings(
                    "moonstone_deepslate",
                    ModBlocks.DEEPSLATE_MOONSTONE_ORE.get(),
                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                    6, 7,
                    VerticalAnchor.aboveBottom(-64),
                    VerticalAnchor.aboveBottom(16),
                    BiomeTags.IS_OVERWORLD
            ),
            new ModGemOreGenSettings(
                    "moonstone_nether",
                    ModBlocks.MOONSTONE_ORE.get(),
                    new BlockMatchTest(Blocks.NETHERRACK),
                    5, 5,
                    VerticalAnchor.aboveBottom(0),
                    VerticalAnchor.aboveBottom(128),
                    BiomeTags.IS_NETHER
            ),
            new ModGemOreGenSettings(
                    "moonstone_end",
                    ModBlocks.MOONSTONE_ORE.get(),
                    new BlockMatchTest(Blocks.END_STONE),
                    4, 3,
                    VerticalAnchor.aboveBottom(32),
                    VerticalAnchor.aboveBottom(128),
                    BiomeTags.IS_END
            )
            // Add other gem ores here as needed
    );
}
