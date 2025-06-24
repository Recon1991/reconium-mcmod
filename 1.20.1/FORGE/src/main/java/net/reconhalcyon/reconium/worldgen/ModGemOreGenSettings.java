package net.reconhalcyon.reconium.worldgen;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import java.util.List;

/**
 * Encapsulates all ore generation settings for a single gem, including all its world gen variants (overworld, deepslate, nether, end, etc.).
 */
public class ModGemOreGenSettings {
    public record GemOreGenSettings(
        String variant, // e.g., "overworld", "deepslate", "nether", "end"
        Block oreBlock,
        RuleTest ruleTest,
        int veinSize,
        int veinsPerChunk,
        VerticalAnchor minY,
        VerticalAnchor maxY,
        TagKey<Biome> biomeTag
    ) {}

    public record GemSettings(
        String gemName,
        List<GemOreGenSettings> variants
    ) {}
}

