package net.reconhalcyon.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.reconhalcyon.reconium.util.ModTiers;

public class ModGeologyPickaxeItem extends PickaxeItem {
    public ModGeologyPickaxeItem() {
        super(
                ModTiers.GEOLOGY,     // custom geology tier
                1,                    // +1 attack damage
                -2.8F,                // -2.8 attack speed
                new Item.Properties()
        );
    }
}
