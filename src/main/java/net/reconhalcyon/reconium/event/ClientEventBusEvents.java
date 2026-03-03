package net.reconhalcyon.reconium.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.entity.ModBlockEntities;
import net.reconhalcyon.reconium.block.entity.renderer.GemPolishingBlockEntityRenderer;
import net.reconhalcyon.reconium.screen.GemPolishingStationScreen;
import net.reconhalcyon.reconium.screen.ModMenuTypes;

@EventBusSubscriber(modid = Reconium.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusEvents {
    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        Reconium.LOGGER.info("Registering MenuScreen for: {}", ModMenuTypes.GEM_POLISHING_MENU.get());
        event.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.GEM_POLISHING_BE.get(), GemPolishingBlockEntityRenderer::new);
    }
}




