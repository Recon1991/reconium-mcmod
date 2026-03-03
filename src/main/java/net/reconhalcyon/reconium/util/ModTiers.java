package net.reconhalcyon.reconium.util;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.SimpleTier;
import net.reconhalcyon.reconium.Reconium;

public class ModTiers {
    public static final Tier GEOLOGY = new SimpleTier(
            ModTags.Blocks.NEEDS_GEOLOGY_TOOL,
            250,
            6.0F,
            2.0F,
            14,
            () -> Ingredient.of(Items.IRON_INGOT)
    );

    private ModTiers() { /* no instances */ }
}




