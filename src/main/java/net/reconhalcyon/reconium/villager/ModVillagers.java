package net.reconhalcyon.reconium.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;

public class ModVillagers {
    // ═══╬═══ Registry ═══╬═══
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Reconium.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Reconium.MOD_ID);

    // ═══╬═══ Custom Villagers ═══╬═══
    public static final RegistryObject<PoiType> LAPIDARY_POI = POI_TYPES.register("lapidary_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FACETING_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> LAPIDARY_MASTER =
            VILLAGER_PROFESSIONS.register("lapidary", () -> new VillagerProfession("lapidary",
                    holder -> holder.get() == LAPIDARY_POI.get(), holder -> holder.get() == LAPIDARY_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
