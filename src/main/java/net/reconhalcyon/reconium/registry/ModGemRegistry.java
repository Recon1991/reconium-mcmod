package net.reconhalcyon.reconium.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModGemRegistry {

    public static final Map<String, RegistryObject<Item>> GEMS = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> GEM_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> GEM_GLASS_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> GEM_ORES = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> DEEPSLATE_GEM_ORES = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> NETHER_GEM_ORES = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> END_GEM_ORES = new LinkedHashMap<>();

    public static void trackGemItem(String name, RegistryObject<Item> gem){
        GEMS.put(name, gem);
    }
    public static void trackGemBlock(String name, RegistryObject<Block> block) {
        GEM_BLOCKS.put(name, block);
    }
    public static void trackGemGlassBlock(String name, RegistryObject<Block> block) {
        GEM_GLASS_BLOCKS.put(name, block);
    }

    public static void trackGemOre(String name, RegistryObject<Block> block) {
        GEM_ORES.put(name, block);
    }
    public static void trackDeepslateGemOre(String name, RegistryObject<Block> block) {
        DEEPSLATE_GEM_ORES.put(name, block);
    }
    public static void trackNetherGemOre(String name, RegistryObject<Block> block) {
        NETHER_GEM_ORES.put(name, block);
    }
    public static void trackEndGemOre(String name, RegistryObject<Block> block) {
        END_GEM_ORES.put(name, block);
    }
}
