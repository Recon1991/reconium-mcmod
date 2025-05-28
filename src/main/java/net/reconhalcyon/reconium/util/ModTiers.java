package net.reconhalcyon.reconium.util;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeTier;
import net.minecraft.tags.BlockTags;

public final class ModTiers {
    // level=2 (iron), durability=250, speed=6f, attackBonus=2f, enchant=14
    public static final Tier GEOLOGY = new ForgeTier(
            2,                     // harvest level
            250,                   // max uses (durability)
            6.0F,                  // mining speed multiplier
            2.0F,                  // attack damage bonus
            14,                    // enchantability
            BlockTags.NEEDS_IRON_TOOL, // blocks this tier can mine
            () -> Ingredient.of(Items.IRON_INGOT) // repair material
    );

    private ModTiers() { /* no instances */ }
}
