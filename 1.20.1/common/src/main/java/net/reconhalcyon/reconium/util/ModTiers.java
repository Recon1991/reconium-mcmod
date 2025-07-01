package net.reconhalcyon.reconium.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.reconhalcyon.reconium.Reconium;

import java.util.List;

public class ModTiers {
    // level=2 (iron), durability=250, speed=6f, attackBonus=2f, enchant=14
    public static final Tier GEOLOGY = TierSortingRegistry.registerTier(
            new ForgeTier(
                    2,                     // harvest level
                    250,                   // max uses (durability)
                    6.0F,                  // mining speed multiplier
                    2.0F,                  // attack damage bonus
                    14,                    // enchant level
                    ModTags.Blocks.NEEDS_GEOLOGY_TOOL, // blocks this tier can mine
                    () -> Ingredient.of(Items.IRON_INGOT)),
            new ResourceLocation(Reconium.MOD_ID, "geology"), List.of(Tiers.IRON), List.of());

    private ModTiers() { /* no instances */ }
}
