package net.reconhalcyon.fabric;

import net.fabricmc.api.ModInitializer;
import net.reconhalcyon.reconium.Reconium;

public final class ReconiumFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // Run common initialization logic
        Reconium.initCommon();
    }
}
