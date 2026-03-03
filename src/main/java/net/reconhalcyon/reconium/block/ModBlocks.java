package net.reconhalcyon.reconium.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.custom.CustomBuddingGemBlock;
import net.reconhalcyon.reconium.block.custom.GemPolishingStationBlock;
import net.reconhalcyon.reconium.block.custom.GemTallCropBlock;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import net.reconhalcyon.reconium.registry.ReconRegistryHelper;

import java.util.Locale;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK, Reconium.MOD_ID);

    // ═══╬═══ Base Gem Blocks ═══╬═══
    public static final java.util.function.Supplier<Block> MOONSTONE_BLOCK = createAndRegisterGemBlock("moonstone");
    public static final java.util.function.Supplier<Block> GREY_QUARTZ_BLOCK = createAndRegisterGemBlock("grey_quartz");
    public static final java.util.function.Supplier<Block> HEMATITE_BLOCK = createAndRegisterGemBlock("hematite");
    public static final java.util.function.Supplier<Block> ONYX_BLOCK = createAndRegisterGemBlock("onyx");
    public static final java.util.function.Supplier<Block> ZIRCON_BLOCK = createAndRegisterGemBlock("zircon");
    public static final java.util.function.Supplier<Block> RUBY_BLOCK = createAndRegisterGemBlock("ruby");
    public static final java.util.function.Supplier<Block> TOPAZ_BLOCK = createAndRegisterGemBlock("topaz");
    public static final java.util.function.Supplier<Block> CITRINE_BLOCK = createAndRegisterGemBlock("citrine");
    public static final java.util.function.Supplier<Block> PERIDOT_BLOCK = createAndRegisterGemBlock("peridot");
    public static final java.util.function.Supplier<Block> JADE_BLOCK = createAndRegisterGemBlock("jade");
    public static final java.util.function.Supplier<Block> TURQUOISE_BLOCK = createAndRegisterGemBlock("turquoise");
    public static final java.util.function.Supplier<Block> LARIMAR_BLOCK = createAndRegisterGemBlock("larimar");
    public static final java.util.function.Supplier<Block> SAPPHIRE_BLOCK = createAndRegisterGemBlock("sapphire");
    public static final java.util.function.Supplier<Block> SUGILITE_BLOCK = createAndRegisterGemBlock("sugilite");
    public static final java.util.function.Supplier<Block> SPINEL_BLOCK = createAndRegisterGemBlock("spinel");
    public static final java.util.function.Supplier<Block> PINK_DIAMOND_BLOCK = createAndRegisterGemBlock("pink_diamond");
    public static final java.util.function.Supplier<Block> SERAPHINITE_BLOCK = createAndRegisterGemBlock("seraphinite");
    public static final java.util.function.Supplier<Block> WATERMELON_TOURMALINE_BLOCK = createAndRegisterGemBlock("watermelon_tourmaline");

    // ═══╬═══ Gem Glass Blocks ═══╬═══
    public static final java.util.function.Supplier<Block> MOONSTONE_GLASS = createAndRegisterGemGlassBlock("moonstone");
    public static final java.util.function.Supplier<Block> GREY_QUARTZ_GLASS = createAndRegisterGemGlassBlock("grey_quartz");
    public static final java.util.function.Supplier<Block> HEMATITE_GLASS = createAndRegisterGemGlassBlock("hematite");
    public static final java.util.function.Supplier<Block> ONYX_GLASS = createAndRegisterGemGlassBlock("onyx");
    public static final java.util.function.Supplier<Block> ZIRCON_GLASS = createAndRegisterGemGlassBlock("zircon");
    public static final java.util.function.Supplier<Block> RUBY_GLASS = createAndRegisterGemGlassBlock("ruby");
    public static final java.util.function.Supplier<Block> TOPAZ_GLASS = createAndRegisterGemGlassBlock("topaz");
    public static final java.util.function.Supplier<Block> CITRINE_GLASS = createAndRegisterGemGlassBlock("citrine");
    public static final java.util.function.Supplier<Block> PERIDOT_GLASS = createAndRegisterGemGlassBlock("peridot");
    public static final java.util.function.Supplier<Block> JADE_GLASS = createAndRegisterGemGlassBlock("jade");
    public static final java.util.function.Supplier<Block> TURQUOISE_GLASS = createAndRegisterGemGlassBlock("turquoise");
    public static final java.util.function.Supplier<Block> LARIMAR_GLASS = createAndRegisterGemGlassBlock("larimar");
    public static final java.util.function.Supplier<Block> SAPPHIRE_GLASS = createAndRegisterGemGlassBlock("sapphire");
    public static final java.util.function.Supplier<Block> SUGILITE_GLASS = createAndRegisterGemGlassBlock("sugilite");
    public static final java.util.function.Supplier<Block> SPINEL_GLASS = createAndRegisterGemGlassBlock("spinel");
    public static final java.util.function.Supplier<Block> PINK_DIAMOND_GLASS = createAndRegisterGemGlassBlock("pink_diamond");
    public static final java.util.function.Supplier<Block> SERAPHINITE_GLASS = createAndRegisterGemGlassBlock("seraphinite");
    public static final java.util.function.Supplier<Block> WATERMELON_TOURMALINE_GLASS = createAndRegisterGemGlassBlock("watermelon_tourmaline");

    // ═══╬═══ Gem Ores ═══╬═══
    public static final java.util.function.Supplier<Block> MOONSTONE_ORE = createAndRegisterGemOre("moonstone");
    public static final java.util.function.Supplier<Block> DEEPSLATE_MOONSTONE_ORE = createAndRegisterDeepslateGemOre("moonstone");
    //public static final java.util.function.Supplier<Block> NETHER_MOONSTONE_ORE = createAndRegisterNetherGemOre("moonstone");
    //public static final java.util.function.Supplier<Block> END_MOONSTONE_ORE = createAndRegisterEndGemOre("moonstone");

    public static final java.util.function.Supplier<Block> GREY_QUARTZ_ORE = createAndRegisterGemOre("grey_quartz");
    public static final java.util.function.Supplier<Block> DEEPSLATE_GREY_QUARTZ_ORE = createAndRegisterDeepslateGemOre("grey_quartz");
    //public static final java.util.function.Supplier<Block> NETHER_GREY_QUARTZ_ORE = createAndRegisterNetherGemOre("grey_quartz");
    //public static final java.util.function.Supplier<Block> END_GREY_QUARTZ_ORE = createAndRegisterEndGemOre("grey_quartz");

    public static final java.util.function.Supplier<Block> HEMATITE_ORE = createAndRegisterGemOre("hematite");
    public static final java.util.function.Supplier<Block> DEEPSLATE_HEMATITE_ORE = createAndRegisterDeepslateGemOre("hematite");
    //public static final java.util.function.Supplier<Block> NETHER_HEMATITE_ORE = createAndRegisterNetherGemOre("hematite");
    //public static final java.util.function.Supplier<Block> END_HEMATITE_ORE = createAndRegisterEndGemOre("hematite");

    //public static final java.util.function.Supplier<Block> ONYX_ORE = createAndRegisterGemOre("onyx");
    //public static final java.util.function.Supplier<Block> DEEPSLATE_ONYX_ORE = createAndRegisterDeepslateGemOre("onyx");
    public static final java.util.function.Supplier<Block> NETHER_ONYX_ORE = createAndRegisterNetherGemOre("onyx");
    //public static final java.util.function.Supplier<Block> END_ONYX_ORE = createAndRegisterEndGemOre("onyx");

    public static final java.util.function.Supplier<Block> ZIRCON_ORE = createAndRegisterGemOre("zircon");
    public static final java.util.function.Supplier<Block> DEEPSLATE_ZIRCON_ORE = createAndRegisterDeepslateGemOre("zircon");
    //public static final java.util.function.Supplier<Block> NETHER_ZIRCON_ORE = createAndRegisterNetherGemOre("zircon");
    //public static final java.util.function.Supplier<Block> END_ZIRCON_ORE = createAndRegisterEndGemOre("zircon");

    public static final java.util.function.Supplier<Block> RUBY_ORE = createAndRegisterGemOre("ruby");
    public static final java.util.function.Supplier<Block> DEEPSLATE_RUBY_ORE = createAndRegisterDeepslateGemOre("ruby");
    //public static final java.util.function.Supplier<Block> NETHER_RUBY_ORE = createAndRegisterNetherGemOre("ruby");
    //public static final java.util.function.Supplier<Block> END_RUBY_ORE = createAndRegisterEndGemOre("ruby");

    public static final java.util.function.Supplier<Block> TOPAZ_ORE = createAndRegisterGemOre("topaz");
    public static final java.util.function.Supplier<Block> DEEPSLATE_TOPAZ_ORE = createAndRegisterDeepslateGemOre("topaz");
    //public static final java.util.function.Supplier<Block> NETHER_TOPAZ_ORE = createAndRegisterNetherGemOre("topaz");
    //public static final java.util.function.Supplier<Block> END_TOPAZ_ORE = createAndRegisterEndGemOre("topaz");

    public static final java.util.function.Supplier<Block> CITRINE_ORE = createAndRegisterGemOre("citrine");
    public static final java.util.function.Supplier<Block> DEEPSLATE_CITRINE_ORE = createAndRegisterDeepslateGemOre("citrine");
    //public static final java.util.function.Supplier<Block> NETHER_CITRINE_ORE = createAndRegisterNetherGemOre("citrine");
    //public static final java.util.function.Supplier<Block> END_CITRINE_ORE = createAndRegisterEndGemOre("citrine");

    public static final java.util.function.Supplier<Block> PERIDOT_ORE = createAndRegisterGemOre("peridot");
    public static final java.util.function.Supplier<Block> DEEPSLATE_PERIDOT_ORE = createAndRegisterDeepslateGemOre("peridot");
    //public static final java.util.function.Supplier<Block> NETHER_PERIDOT_ORE = createAndRegisterNetherGemOre("peridot");
    //public static final java.util.function.Supplier<Block> END_PERIDOT_ORE = createAndRegisterEndGemOre("peridot");

    public static final java.util.function.Supplier<Block> JADE_ORE = createAndRegisterGemOre("jade");
    public static final java.util.function.Supplier<Block> DEEPSLATE_JADE_ORE = createAndRegisterDeepslateGemOre("jade");
    //public static final java.util.function.Supplier<Block> NETHER_JADE_ORE = createAndRegisterNetherGemOre("jade");
    //public static final java.util.function.Supplier<Block> END_JADE_ORE = createAndRegisterEndGemOre("jade");

    public static final java.util.function.Supplier<Block> TURQUOISE_ORE = createAndRegisterGemOre("turquoise");
    public static final java.util.function.Supplier<Block> DEEPSLATE_TURQUOISE_ORE = createAndRegisterDeepslateGemOre("turquoise");
    //public static final java.util.function.Supplier<Block> NETHER_TURQUOISE_ORE = createAndRegisterNetherGemOre("turquoise");
    //public static final java.util.function.Supplier<Block> END_TURQUOISE_ORE = createAndRegisterEndGemOre("turquoise");

    public static final java.util.function.Supplier<Block> LARIMAR_ORE = createAndRegisterGemOre("larimar");
    public static final java.util.function.Supplier<Block> DEEPSLATE_LARIMAR_ORE = createAndRegisterDeepslateGemOre("larimar");
    //public static final java.util.function.Supplier<Block> NETHER_LARIMAR_ORE = createAndRegisterNetherGemOre("larimar");
    //public static final java.util.function.Supplier<Block> END_LARIMAR_ORE = createAndRegisterEndGemOre("larimar");

    public static final java.util.function.Supplier<Block> SAPPHIRE_ORE = createAndRegisterGemOre("sapphire");
    public static final java.util.function.Supplier<Block> DEEPSLATE_SAPPHIRE_ORE = createAndRegisterDeepslateGemOre("sapphire");
    //public static final java.util.function.Supplier<Block> NETHER_SAPPHIRE_ORE = createAndRegisterNetherGemOre("sapphire");
    //public static final java.util.function.Supplier<Block> END_SAPPHIRE_ORE = createAndRegisterEndGemOre("sapphire");

    //public static final java.util.function.Supplier<Block> SUGILITE_ORE = createAndRegisterGemOre("sugilite");
    //public static final java.util.function.Supplier<Block> DEEPSLATE_SUGILITE_ORE = createAndRegisterDeepslateGemOre("sugilite");
    //public static final java.util.function.Supplier<Block> NETHER_SUGILITE_ORE = createAndRegisterNetherGemOre("sugilite");
    public static final java.util.function.Supplier<Block> END_SUGILITE_ORE = createAndRegisterEndGemOre("sugilite");

    //public static final java.util.function.Supplier<Block> SPINEL_ORE = createAndRegisterGemOre("spinel");
    //public static final java.util.function.Supplier<Block> DEEPSLATE_SPINEL_ORE = createAndRegisterDeepslateGemOre("spinel");
    //public static final java.util.function.Supplier<Block> NETHER_SPINEL_ORE = createAndRegisterNetherGemOre("spinel");
    public static final java.util.function.Supplier<Block> END_SPINEL_ORE = createAndRegisterEndGemOre("spinel");

    public static final java.util.function.Supplier<Block> PINK_DIAMOND_ORE = createAndRegisterGemOre("pink_diamond");
    public static final java.util.function.Supplier<Block> DEEPSLATE_PINK_DIAMOND_ORE = createAndRegisterDeepslateGemOre("pink_diamond");
    //public static final java.util.function.Supplier<Block> NETHER_PINK_DIAMOND_ORE = createAndRegisterNetherGemOre("pink_diamond");
    //public static final java.util.function.Supplier<Block> END_PINK_DIAMOND_ORE = createAndRegisterEndGemOre("pink_diamond");

    public static final java.util.function.Supplier<Block> SERAPHINITE_ORE = createAndRegisterGemOre("seraphinite");
    public static final java.util.function.Supplier<Block> DEEPSLATE_SERAPHINITE_ORE = createAndRegisterDeepslateGemOre("seraphinite");
    //public static final java.util.function.Supplier<Block> NETHER_SERAPHINITE_ORE = createAndRegisterNetherGemOre("seraphinite");
    //public static final java.util.function.Supplier<Block> END_SERAPHINITE_ORE = createAndRegisterEndGemOre("seraphinite");

    public static final java.util.function.Supplier<Block> WATERMELON_TOURMALINE_ORE = createAndRegisterGemOre("watermelon_tourmaline");
    public static final java.util.function.Supplier<Block> DEEPSLATE_WATERMELON_TOURMALINE_ORE = createAndRegisterDeepslateGemOre("watermelon_tourmaline");
    //public static final java.util.function.Supplier<Block> NETHER_WATERMELON_TOURMALINE_ORE = createAndRegisterNetherGemOre("watermelon_tourmaline");
    //public static final java.util.function.Supplier<Block> END_WATERMELON_TOURMALINE_ORE = createAndRegisterEndGemOre("watermelon_tourmaline");

    public static final java.util.function.Supplier<Block> MOONSTONE_FLOWER = registerBlock("moonstone_flower",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).noOcclusion().noCollission()));
    public static final java.util.function.Supplier<Block> POTTED_MOONSTONE_FLOWER = BLOCKS.register("potted_moonstone_flower",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.MOONSTONE_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final java.util.function.Supplier<Block> GEM_TALL_CROP = BLOCKS.register("gem_tall_crop",
            () -> new GemTallCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
                    .noOcclusion().noCollission()));

    public static final java.util.function.Supplier<Block> GEM_POLISHING_STATION = registerBlock("gem_polishing_station",
            () -> new GemPolishingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> java.util.function.Supplier<T> registerBlock(String name, Supplier<T> block) {
        java.util.function.Supplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, java.util.function.Supplier<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Register gem blocks using gem item name
    @SuppressWarnings("unchecked")
    private static <T extends Block> java.util.function.Supplier<T> createAndRegisterGemBlock(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .ofFullCopy(Blocks.IRON_BLOCK)
                .sound(SoundType.AMETHYST)
                .requiresCorrectToolForDrops());

        java.util.function.Supplier<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_block", supplier
        );
        ModGemRegistry.trackGemBlock(name, (java.util.function.Supplier<Block>) block);
        return block;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> java.util.function.Supplier<T> createAndRegisterGemGlassBlock(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .ofFullCopy(Blocks.GLASS)
                .noOcclusion()
                .sound(SoundType.AMETHYST)
                .strength(0.3F)
                .requiresCorrectToolForDrops());

        java.util.function.Supplier<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_glass", supplier
        );
        ModGemRegistry.trackGemGlassBlock(name, (java.util.function.Supplier<Block>) block);
        return block;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> java.util.function.Supplier<T> createAndRegisterGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .ofFullCopy(Blocks.STONE)
                .strength(3.0F, 3.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());

        java.util.function.Supplier<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_ore", supplier
        );
        ModGemRegistry.trackGemOre(name, (java.util.function.Supplier<Block>) block);
        ModGemRegistry.trackGemOreBase((java.util.function.Supplier<Block>) block, "stone");
        return block;
    }
    @SuppressWarnings("unchecked")
    private static <T extends Block> java.util.function.Supplier<T> createAndRegisterDeepslateGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                .sound(SoundType.DEEPSLATE)
                .requiresCorrectToolForDrops());

        java.util.function.Supplier<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, "deepslate_" + name + "_ore", supplier
        );
        ModGemRegistry.trackDeepslateGemOre(name, (java.util.function.Supplier<Block>) block);
        ModGemRegistry.trackGemOreBase((java.util.function.Supplier<Block>) block, "deepslate");
        return block;
    }
    @SuppressWarnings("unchecked")
    private static <T extends Block> java.util.function.Supplier<T> createAndRegisterNetherGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
                .sound(SoundType.NETHERRACK)
                .requiresCorrectToolForDrops());

        java.util.function.Supplier<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, "nether_" + name + "_ore", supplier
        );
        ModGemRegistry.trackNetherGemOre(name, (java.util.function.Supplier<Block>) block);
        ModGemRegistry.trackGemOreBase((java.util.function.Supplier<Block>) block, "nether");
        return block;
    }
    @SuppressWarnings("unchecked")
    private static <T extends Block> java.util.function.Supplier<T> createAndRegisterEndGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .ofFullCopy(Blocks.END_STONE)
                .strength(3.2F, 3.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());

        java.util.function.Supplier<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, "end_" + name + "_ore", supplier
        );
        ModGemRegistry.trackEndGemOre(name, (java.util.function.Supplier<Block>) block);
        ModGemRegistry.trackGemOreBase((java.util.function.Supplier<Block>) block, "end");
        return block;
    }

    public static void registerGemBudStages(String gemId) {
        String base = gemId.toLowerCase(Locale.ROOT);

        java.util.function.Supplier<Block> budding = BLOCKS.register("budding_" + base,
                () -> new CustomBuddingGemBlock(gemId,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.BUDDING_AMETHYST)));

        java.util.function.Supplier<Block> small = BLOCKS.register("small_" + base + "_bud",
                () -> new AmethystClusterBlock(1, 3,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.SMALL_AMETHYST_BUD).noOcclusion()));

        java.util.function.Supplier<Block> medium = BLOCKS.register("medium_" + base + "_bud",
                () -> new AmethystClusterBlock(2, 4,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.MEDIUM_AMETHYST_BUD).noOcclusion()));

        java.util.function.Supplier<Block> large = BLOCKS.register("large_" + base + "_bud",
                () -> new AmethystClusterBlock(3, 5,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.LARGE_AMETHYST_BUD).noOcclusion()));

        java.util.function.Supplier<Block> cluster = BLOCKS.register(base + "_cluster",
                () -> new AmethystClusterBlock(4, 6,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).noOcclusion()));

        ModGemRegistry.trackGemBuddingBlocks(gemId, budding, small, medium, large, cluster);

        registerBlockItem("budding_" + base, budding);
        registerBlockItem("small_"   + base + "_bud", small);
        registerBlockItem("medium_"  + base + "_bud", medium);
        registerBlockItem("large_"   + base + "_bud", large);
        registerBlockItem(base       + "_cluster",   cluster);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        ModGemRegistry.GEMS.keySet().forEach(ModBlocks::registerGemBudStages);
    }
}





