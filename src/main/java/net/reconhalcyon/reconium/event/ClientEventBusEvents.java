package net.reconhalcyon.reconium.event;

//import mezz.jei.api.client.gui.handlers.IGuiContainerHandler;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.screen.GemPolishingStationScreen;
import net.reconhalcyon.reconium.screen.ModMenuTypes;

@Mod.EventBusSubscriber(modid = Reconium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Reconium.LOGGER.info("Registering MenuScreen for: {}", ModMenuTypes.GEM_POLISHING_MENU.get());
            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        });
    }
}
