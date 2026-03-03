package net.reconhalcyon.reconium;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

@EventBusSubscriber(modid = Reconium.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Apply RenderType for glass blocks (cutout)
            ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(block ->
                    ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.translucent())
            );
        });
    }
}




