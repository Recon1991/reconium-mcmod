/*╭──────────────────────────────────────────────────────
│ [:: Halcyon Module ::] 
│ > Mod ID: Reconium >> 
│ > Purpose: Descriptor
│ 🤖 Handler: Tachikoma System Core */
package net.reconhalcyon.reconium.worldgen;
/*╰──────────────────────────────────────────────────────  */

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ModGemOreGenSettings {
    public record GemOreGenSettings(
            String name,
            Block oreBlock,
            RuleTest ruleTest,
            int veinSize,
            int veinsPerChunk,
            VerticalAnchor minY,
            VerticalAnchor maxY,
            TagKey<Biome> biomeTag
    ) {}
}
