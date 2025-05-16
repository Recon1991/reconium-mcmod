package net.reconhalcyon.reconium.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModGemRegistry {

    public static final Map<String, RegistryObject<Item>> GEMS = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> GEM_BLOCKS = new LinkedHashMap<>();

    public static void registerGem(String name, RegistryObject<Item> gem, RegistryObject<Block> block) {
        GEMS.put(name, gem);
        GEM_BLOCKS.put(name, block);
    }
}
