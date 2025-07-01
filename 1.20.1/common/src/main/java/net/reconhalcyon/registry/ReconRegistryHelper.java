package net.reconhalcyon.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ReconRegistryHelper {

    public static <T extends Block> RegistryObject<T> registerBlockWithItem(
            DeferredRegister<Block> blockRegister,
            DeferredRegister<Item> itemRegister,
            String name,
            Supplier<T> blockSupplier
    ) {
        RegistryObject<T> block = blockRegister.register(name, blockSupplier);
        itemRegister.register(name, () ->
                new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static RegistryObject<Item> registerSimpleItem(
            DeferredRegister<Item> itemRegister,
            String name
    ) {
        return itemRegister.register(name, () -> new Item(new Item.Properties()));
    }
}
