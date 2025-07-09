package net.reconhalcyon.reconium.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.custom.ModGeologyPickaxeItem;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

    // All registered items are tracked here if needed
    public static final Map<String, Item> ITEM_REGISTRY = new LinkedHashMap<>();

    // Custom tool
    public static Item GEOLOGY_PICKAXE;

    public static void init() {
        // Register gem items
        for (String name : new String[]{
                "moonstone", "grey_quartz", "hematite", "onyx", "zircon",
                "ruby", "topaz", "citrine", "peridot", "jade",
                "turquoise", "larimar", "sapphire", "sugilite", "spinel",
                "pink_diamond", "seraphinite", "watermelon_tourmaline"
        }) {
            createAndRegisterGemItem(name);
        }

        // Register the custom geology pickaxe
        GEOLOGY_PICKAXE = register("geology_pickaxe", new ModGeologyPickaxeItem());
    }

    private static Item createAndRegisterGemItem(String name) {
        Item item = register(name, new Item(new Item.Properties()));
        ModGemRegistry.trackGemItem(name, item);
        return item;
    }

    private static Item register(String name, Item item) {
        ResourceLocation id = new ResourceLocation(Reconium.MOD_ID, name);
        Item result = Registry.register(BuiltInRegistries.ITEM, id, item);
        ITEM_REGISTRY.put(name, result);
        return result;
    }
}
