package net.reconhalcyon.reconium.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE, Reconium.MOD_ID);

    public static final java.util.function.Supplier<BlockEntityType<GemPolishingStationBlockEntity>> GEM_POLISHING_BE =
            BLOCK_ENTITIES.register("gem_polishing_be",() ->
                    BlockEntityType.Builder.of(GemPolishingStationBlockEntity::new,
                            ModBlocks.GEM_POLISHING_STATION.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}




