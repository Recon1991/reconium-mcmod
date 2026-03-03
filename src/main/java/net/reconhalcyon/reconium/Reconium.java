package net.reconhalcyon.reconium;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.block.entity.ModBlockEntities;
import net.reconhalcyon.reconium.item.ModCreativeModTabs;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.recipe.ModRecipes;
import net.reconhalcyon.reconium.screen.GemPolishingStationScreen;
import net.reconhalcyon.reconium.screen.ModMenuTypes;
import net.reconhalcyon.reconium.villager.ModVillagers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reconium.MOD_ID)
public class Reconium {
    public static final String MOD_ID = "reconium";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Reconium(IEventBus modEventBus) {
        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ReconiumConfig.SPEC);

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            var moonstoneFlowerId = BuiltInRegistries.BLOCK.getKey(ModBlocks.MOONSTONE_FLOWER.get());
            if (moonstoneFlowerId != null) {
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(moonstoneFlowerId, ModBlocks.POTTED_MOONSTONE_FLOWER);
            }
            LOGGER.info("Common setup for Reconium mod is complete.");
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    /*
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Reconium.LOGGER.info("MenuType instance at client setup: {}", ModMenuTypes.GEM_POLISHING_MENU.get());
            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        }
    }
    */
}



