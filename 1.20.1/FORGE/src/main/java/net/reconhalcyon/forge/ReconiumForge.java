package net.reconhalcyon.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.reconhalcyon.reconium.Reconium;

@Mod(Reconium.MOD_ID)
public final class ReconiumForge {
    @SuppressWarnings("deprecation")
    public ReconiumForge() {
        // Required: Registers your mod's event bus with Forge through Architectury
        EventBuses.registerModEventBus(Reconium.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Call common setup
        Reconium.initCommon();
    }
}
