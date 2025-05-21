package net.reconhalcyon.reconium.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModGemRegistry {

    // ═══╬═══ Core Gem Maps ═══╬═══
    public static final Map<String, RegistryObject<Item>> GEMS = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> GEM_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> GEM_GLASS_BLOCKS = new LinkedHashMap<>();

    // ═══╬═══ Ore Block Maps by Base Material ═══╬═══
    public static final Map<String, RegistryObject<Block>> ORE_BLOCKS_STONE = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> ORE_BLOCKS_DEEPSLATE = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> ORE_BLOCKS_NETHERRACK = new LinkedHashMap<>();
    public static final Map<String, RegistryObject<Block>> ORE_BLOCKS_ENDSTONE = new LinkedHashMap<>();

    // ═══╬═══ Optional: Map block registry to base type name ═══╬═══
    public static final Map<RegistryObject<Block>, String> GEM_ORE_BASES = new LinkedHashMap<>();

    // ═══╬═══ Tracking Helpers ═══╬═══
    public static void trackGemItem(String name, RegistryObject<Item> gem) {
        GEMS.put(name, gem);
    }

    public static void trackGemBlock(String name, RegistryObject<Block> block) {
        GEM_BLOCKS.put(name, block);
    }

    public static void trackGemGlassBlock(String name, RegistryObject<Block> block) {
        GEM_GLASS_BLOCKS.put(name, block);
    }

    public static void trackGemOre(String name, RegistryObject<Block> block) {
        ORE_BLOCKS_STONE.put(name, block);
        GEM_ORE_BASES.put(block, "stone");
    }

    public static void trackDeepslateGemOre(String name, RegistryObject<Block> block) {
        ORE_BLOCKS_DEEPSLATE.put(name, block);
        GEM_ORE_BASES.put(block, "deepslate");
    }

    public static void trackNetherGemOre(String name, RegistryObject<Block> block) {
        ORE_BLOCKS_NETHERRACK.put(name, block);
        GEM_ORE_BASES.put(block, "netherrack");
    }

    public static void trackEndGemOre(String name, RegistryObject<Block> block) {
        ORE_BLOCKS_ENDSTONE.put(name, block);
        GEM_ORE_BASES.put(block, "end_stone");
    }

    // ═══╬═══ Ore Map Group Accessors ═══╬═══
    public static List<Map<String, RegistryObject<Block>>> getAllOreBlockGroups() {
        return List.of(
                ORE_BLOCKS_STONE,
                ORE_BLOCKS_DEEPSLATE,
                ORE_BLOCKS_NETHERRACK,
                ORE_BLOCKS_ENDSTONE
        );
    }

    public static String getBaseNameFromMap(Map<String, RegistryObject<Block>> map) {
        if (map == ORE_BLOCKS_STONE) return "stone";
        if (map == ORE_BLOCKS_DEEPSLATE) return "deepslate";
        if (map == ORE_BLOCKS_NETHERRACK) return "netherrack";
        if (map == ORE_BLOCKS_ENDSTONE) return "end_stone";
        return "unknown_base";
    }

    public static void trackGemOreBase(RegistryObject<Block> block, String baseType) {
        GEM_ORE_BASES.put(block, baseType);
    }
}
