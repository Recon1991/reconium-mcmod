package net.reconhalcyon.reconium;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

@Mod.EventBusSubscriber(modid = Reconium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
