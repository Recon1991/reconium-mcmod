package net.reconhalcyon.reconium.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModGemRegistry {

    // ═══╬═══ Core Gem Maps ═══╬═══
    public static final Map<String, java.util.function.Supplier<Item>> GEMS = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> GEM_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> GEM_GLASS_BLOCKS = new LinkedHashMap<>();

    // ═══╬═══ Ore Block Maps by Base Material ═══╬═══
    public static final Map<String, java.util.function.Supplier<Block>> ORE_BLOCKS_STONE = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> ORE_BLOCKS_DEEPSLATE = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> ORE_BLOCKS_NETHERRACK = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> ORE_BLOCKS_ENDSTONE = new LinkedHashMap<>();

    // ═══╬═══ Optional: Map block registry to base type name ═══╬═══
    public static final Map<java.util.function.Supplier<Block>, String> GEM_ORE_BASES = new LinkedHashMap<>();

    // ═══╬═══ Budding Gem Block Maps ═══╬═══
    public static final Map<String, java.util.function.Supplier<Block>> BUDDING_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> SMALL_BUDS = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> MEDIUM_BUDS = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> LARGE_BUDS = new LinkedHashMap<>();
    public static final Map<String, java.util.function.Supplier<Block>> CLUSTERS = new LinkedHashMap<>();


    // ═══╬═══ Tracking Helpers ═══╬═══
    public static void trackGemItem(String name, java.util.function.Supplier<Item> gem) {
        GEMS.put(name, gem);
    }

    public static void trackGemBlock(String name, java.util.function.Supplier<Block> block) {
        GEM_BLOCKS.put(name, block);
    }

    public static void trackGemGlassBlock(String name, java.util.function.Supplier<Block> block) {
        GEM_GLASS_BLOCKS.put(name, block);
    }

    public static void trackGemOre(String name, java.util.function.Supplier<Block> block) {
        ORE_BLOCKS_STONE.put(name, block);
        GEM_ORE_BASES.put(block, "stone");
    }

    public static void trackDeepslateGemOre(String name, java.util.function.Supplier<Block> block) {
        ORE_BLOCKS_DEEPSLATE.put(name, block);
        GEM_ORE_BASES.put(block, "deepslate");
    }

    public static void trackNetherGemOre(String name, java.util.function.Supplier<Block> block) {
        ORE_BLOCKS_NETHERRACK.put(name, block);
        GEM_ORE_BASES.put(block, "netherrack");
    }

    public static void trackEndGemOre(String name, java.util.function.Supplier<Block> block) {
        ORE_BLOCKS_ENDSTONE.put(name, block);
        GEM_ORE_BASES.put(block, "end_stone");
    }

    // ═══╬═══ Ore Map Group Accessors ═══╬═══
    public static List<Map<String, java.util.function.Supplier<Block>>> getAllOreBlockGroups() {
        return List.of(
                ORE_BLOCKS_STONE,
                ORE_BLOCKS_DEEPSLATE,
                ORE_BLOCKS_NETHERRACK,
                ORE_BLOCKS_ENDSTONE
        );
    }

    public static String getBaseNameFromMap(Map<String, java.util.function.Supplier<Block>> map) {
        if (map == ORE_BLOCKS_STONE) return "stone";
        if (map == ORE_BLOCKS_DEEPSLATE) return "deepslate";
        if (map == ORE_BLOCKS_NETHERRACK) return "netherrack";
        if (map == ORE_BLOCKS_ENDSTONE) return "end_stone";
        return "unknown_base";
    }

    public static void trackGemOreBase(java.util.function.Supplier<Block> block, String baseType) {
        GEM_ORE_BASES.put(block, baseType);
    }

    public static void trackGemBuddingBlocks(String name,
                                             java.util.function.Supplier<Block> budding,
                                             java.util.function.Supplier<Block> small,
                                             java.util.function.Supplier<Block> medium,
                                             java.util.function.Supplier<Block> large,
                                             java.util.function.Supplier<Block> cluster) {

        BUDDING_BLOCKS.put(name, budding);
        SMALL_BUDS.put(name, small);
        MEDIUM_BUDS.put(name, medium);
        LARGE_BUDS.put(name, large);
        CLUSTERS.put(name, cluster);
    }

}




