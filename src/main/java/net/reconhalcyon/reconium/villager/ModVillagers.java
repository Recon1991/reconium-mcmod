package net.reconhalcyon.reconium.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;

public class ModVillagers {
    // ═══╬═══ Registry ═══╬═══
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.POINT_OF_INTEREST_TYPE, Reconium.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.VILLAGER_PROFESSION, Reconium.MOD_ID);

    // ═══╬═══ Custom Villagers ═══╬═══
    public static final java.util.function.Supplier<PoiType> LAPIDARY_POI = POI_TYPES.register("lapidary_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GEM_POLISHING_STATION.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final java.util.function.Supplier<VillagerProfession> LAPIDARY_MASTER =
            VILLAGER_PROFESSIONS.register("lapidary", () -> new VillagerProfession("lapidary",
                    holder -> holder.value() == LAPIDARY_POI.get(), holder -> holder.value() == LAPIDARY_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}




