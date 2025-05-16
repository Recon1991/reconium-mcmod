package net.reconhalcyon.reconium.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import net.reconhalcyon.reconium.registry.ReconRegistryHelper;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Reconium.MOD_ID);

    // Gem Blocks
    public static final RegistryObject<Block> MOONSTONE_BLOCK = createAndRegisterGemBlock("moonstone");
    public static final RegistryObject<Block> GREY_QUARTZ_BLOCK = createAndRegisterGemBlock("grey_quartz");
    public static final RegistryObject<Block> HEMATITE_BLOCK = createAndRegisterGemBlock("hematite");
    public static final RegistryObject<Block> ONYX_BLOCK = createAndRegisterGemBlock("onyx");
    public static final RegistryObject<Block> ZIRCON_BLOCK = createAndRegisterGemBlock("zircon");
    public static final RegistryObject<Block> RUBY_BLOCK = createAndRegisterGemBlock("ruby");
    public static final RegistryObject<Block> TOPAZ_BLOCK = createAndRegisterGemBlock("topaz");
    public static final RegistryObject<Block> CITRINE_BLOCK = createAndRegisterGemBlock("citrine");
    public static final RegistryObject<Block> PERIDOT_BLOCK = createAndRegisterGemBlock("peridot");
    public static final RegistryObject<Block> JADE_BLOCK = createAndRegisterGemBlock("jade");
    public static final RegistryObject<Block> TURQUOISE_BLOCK = createAndRegisterGemBlock("turquoise");
    public static final RegistryObject<Block> LARIMAR_BLOCK = createAndRegisterGemBlock("larimar");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = createAndRegisterGemBlock("sapphire");
    public static final RegistryObject<Block> SUGILITE_BLOCK = createAndRegisterGemBlock("sugilite");
    public static final RegistryObject<Block> SPINEL_BLOCK = createAndRegisterGemBlock("spinel");
    public static final RegistryObject<Block> PINK_DIAMOND_BLOCK = createAndRegisterGemBlock("pink_diamond");
    public static final RegistryObject<Block> SERAPHINITE_BLOCK = createAndRegisterGemBlock("seraphinite");
    public static final RegistryObject<Block> WATERMELON_TOURMALINE_BLOCK = createAndRegisterGemBlock("watermelon_tourmaline");

    // Gem Glass Blocks
    public static final RegistryObject<Block> MOONSTONE_GLASS = createAndRegisterGemGlassBlock("moonstone");
    public static final RegistryObject<Block> GREY_QUARTZ_GLASS = createAndRegisterGemGlassBlock("grey_quartz");
    public static final RegistryObject<Block> HEMATITE_GLASS = createAndRegisterGemGlassBlock("hematite");
    public static final RegistryObject<Block> ONYX_GLASS = createAndRegisterGemGlassBlock("onyx");
    public static final RegistryObject<Block> ZIRCON_GLASS = createAndRegisterGemGlassBlock("zircon");
    public static final RegistryObject<Block> RUBY_GLASS = createAndRegisterGemGlassBlock("ruby");
    public static final RegistryObject<Block> TOPAZ_GLASS = createAndRegisterGemGlassBlock("topaz");
    public static final RegistryObject<Block> CITRINE_GLASS = createAndRegisterGemGlassBlock("citrine");
    public static final RegistryObject<Block> PERIDOT_GLASS = createAndRegisterGemGlassBlock("peridot");
    public static final RegistryObject<Block> JADE_GLASS = createAndRegisterGemGlassBlock("jade");
    public static final RegistryObject<Block> TURQUOISE_GLASS = createAndRegisterGemGlassBlock("turquoise");
    public static final RegistryObject<Block> LARIMAR_GLASS = createAndRegisterGemGlassBlock("larimar");
    public static final RegistryObject<Block> SAPPHIRE_GLASS = createAndRegisterGemGlassBlock("sapphire");
    public static final RegistryObject<Block> SUGILITE_GLASS = createAndRegisterGemGlassBlock("sugilite");
    public static final RegistryObject<Block> SPINEL_GLASS = createAndRegisterGemGlassBlock("spinel");
    public static final RegistryObject<Block> PINK_DIAMOND_GLASS = createAndRegisterGemGlassBlock("pink_diamond");
    public static final RegistryObject<Block> SERAPHINITE_GLASS = createAndRegisterGemGlassBlock("seraphinite");
    public static final RegistryObject<Block> WATERMELON_TOURMALINE_GLASS = createAndRegisterGemGlassBlock("watermelon_tourmaline");


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Register gem blocks using gem item name
    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> createAndRegisterGemBlock(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .copy(Blocks.IRON_BLOCK)
                .sound(SoundType.AMETHYST)
                .requiresCorrectToolForDrops());

        RegistryObject<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_block", supplier
        );
        ModGemRegistry.trackGemBlock(name, (RegistryObject<Block>) block);
        return block;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> createAndRegisterGemGlassBlock(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .copy(Blocks.GLASS)
                .noOcclusion()
                .sound(SoundType.AMETHYST)
                .strength(0.3F)
                .requiresCorrectToolForDrops());

        RegistryObject<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_glass", supplier
        );
        ModGemRegistry.trackGemGlassBlock(name, (RegistryObject<Block>) block);
        return block;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> createAndRegisterGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .copy(Blocks.STONE)
                .strength(3.0F, 3.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());

        RegistryObject<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_ore", supplier
        );
        ModGemRegistry.trackGemOre(name, (RegistryObject<Block>) block);
        return block;
    }
    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> createAndRegisterDeepslateGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .copy(Blocks.DEEPSLATE_IRON_ORE)
                .sound(SoundType.DEEPSLATE)
                .requiresCorrectToolForDrops());

        RegistryObject<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, "deepslate_" + name + "_ore", supplier
        );
        ModGemRegistry.trackDeepslateGemOre(name, (RegistryObject<Block>) block);
        return block;
    }
    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> createAndRegisterNetherGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .copy(Blocks.NETHER_QUARTZ_ORE)
                .sound(SoundType.NETHERRACK)
                .requiresCorrectToolForDrops());

        RegistryObject<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, "nether_" + name + "_ore", supplier
        );
        ModGemRegistry.trackNetherGemOre(name, (RegistryObject<Block>) block);
        return block;
    }
    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> createAndRegisterEndGemOre(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties
                .copy(Blocks.END_STONE)
                .strength(3.2F, 3.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());

        RegistryObject<T> block = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, "end_" + name + "_ore", supplier
        );
        ModGemRegistry.trackEndGemOre(name, (RegistryObject<Block>) block);
        return block;
    }

    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);
    }
}
