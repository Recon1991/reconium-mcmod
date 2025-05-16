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

    public static final RegistryObject<Block> MOONSTONE_BLOCK = registerGemBlock("moonstone");
    public static final RegistryObject<Block> GREY_QUARTZ_BLOCK = registerGemBlock("grey_quartz");
    public static final RegistryObject<Block> HEMATITE_BLOCK = registerGemBlock("hematite");
    public static final RegistryObject<Block> ONYX_BLOCK = registerGemBlock("onyx");
    public static final RegistryObject<Block> ZIRCON_BLOCK = registerGemBlock("zircon");
    public static final RegistryObject<Block> RUBY_BLOCK = registerGemBlock("ruby");
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerGemBlock("topaz");
    public static final RegistryObject<Block> CITRINE_BLOCK = registerGemBlock("citrine");
    public static final RegistryObject<Block> PERIDOT_BLOCK = registerGemBlock("peridot");
    public static final RegistryObject<Block> JADE_BLOCK = registerGemBlock("jade");
    public static final RegistryObject<Block> TURQUOISE_BLOCK = registerGemBlock("turquoise");
    public static final RegistryObject<Block> LARIMAR_BLOCK = registerGemBlock("larimar");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerGemBlock("sapphire");
    public static final RegistryObject<Block> SUGILITE_BLOCK = registerGemBlock("sugilite");
    public static final RegistryObject<Block> SPINEL_BLOCK = registerGemBlock("spinel");
    public static final RegistryObject<Block> PINK_DIAMOND_BLOCK = registerGemBlock("pink_diamond");
    public static final RegistryObject<Block> SERAPHINITE_BLOCK = registerGemBlock("seraphinite");
    public static final RegistryObject<Block> WATERMELON_TOURMALINE_BLOCK = registerGemBlock("watermelon_tourmaline");

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
    private static <T extends Block> RegistryObject<T> registerGemBlock(String name) {
        Supplier<T> supplier = () -> (T) new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK));
        RegistryObject<T> gemblock = ReconRegistryHelper.registerBlockWithItem(
                BLOCKS, ModItems.ITEMS, name + "_block", supplier
        );
        ModGemRegistry.GEM_BLOCKS.put(name, (RegistryObject<Block>) gemblock); // Safe cast
        return gemblock;
    }

    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);
    }
}
