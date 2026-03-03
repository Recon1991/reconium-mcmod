package net.reconhalcyon.reconium.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ReconRegistryHelper {

    public static <T extends Block> java.util.function.Supplier<T> registerBlockWithItem(
            DeferredRegister<Block> blockRegister,
            DeferredRegister<Item> itemRegister,
            String name,
            Supplier<T> blockSupplier
    ) {
        java.util.function.Supplier<T> block = blockRegister.register(name, blockSupplier);
        itemRegister.register(name, () ->
                new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static java.util.function.Supplier<Item> registerSimpleItem(
            DeferredRegister<Item> itemRegister,
            String name
    ) {
        return itemRegister.register(name, () -> new Item(new Item.Properties()));
    }
}




