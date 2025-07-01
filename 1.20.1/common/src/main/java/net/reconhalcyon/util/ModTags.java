package net.reconhalcyon.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.reconhalcyon.reconium.Reconium;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_GEOLOGY_TOOL = tag("needs_geology_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Reconium.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Reconium.MOD_ID, name));
        }
    }
}
