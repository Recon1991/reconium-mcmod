package net.reconhalcyon.reconium.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.reconhalcyon.reconium.util.ModTiers;

public class ModGeologyPickaxeItem extends PickaxeItem {
    public ModGeologyPickaxeItem() {
        super(
                ModTiers.GEOLOGY,     // custom geology tier
                new Item.Properties()
        );
    }
}




