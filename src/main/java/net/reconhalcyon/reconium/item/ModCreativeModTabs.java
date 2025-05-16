package net.reconhalcyon.reconium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reconium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RECONIUM_TAB = CREATIVE_MODE_TABS.register("reconium_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOONSTONE.get()))
                    .title(Component.translatable("creativetab.reconium_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MOONSTONE.get());
                        pOutput.accept(ModItems.GREY_QUARTZ.get());
                        pOutput.accept(ModItems.HEMATITE.get());
                        pOutput.accept(ModItems.ONYX.get());
                        pOutput.accept(ModItems.ZIRCON.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModItems.TOPAZ.get());
                        pOutput.accept(ModItems.CITRINE.get());
                        pOutput.accept(ModItems.PERIDOT.get());
                        pOutput.accept(ModItems.JADE.get());
                        pOutput.accept(ModItems.TURQUOISE.get());
                        pOutput.accept(ModItems.LARIMAR.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.SUGILITE.get());
                        pOutput.accept(ModItems.SPINEL.get());
                        pOutput.accept(ModItems.PINK_DIAMOND.get());
                        pOutput.accept(ModItems.SERAPHINITE.get());
                        pOutput.accept(ModItems.WATERMELON_TOURMALINE.get());

                        pOutput.accept(ModBlocks.MOONSTONE_BLOCK.get());
                        pOutput.accept(ModBlocks.GREY_QUARTZ_BLOCK.get());
                        pOutput.accept(ModBlocks.HEMATITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ONYX_BLOCK.get());
                        pOutput.accept(ModBlocks.ZIRCON_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.TOPAZ_BLOCK.get());
                        pOutput.accept(ModBlocks.CITRINE_BLOCK.get());
                        pOutput.accept(ModBlocks.PERIDOT_BLOCK.get());
                        pOutput.accept(ModBlocks.JADE_BLOCK.get());
                        pOutput.accept(ModBlocks.TURQUOISE_BLOCK.get());
                        pOutput.accept(ModBlocks.LARIMAR_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SUGILITE_BLOCK.get());
                        pOutput.accept(ModBlocks.SPINEL_BLOCK.get());
                        pOutput.accept(ModBlocks.PINK_DIAMOND_BLOCK.get());
                        pOutput.accept(ModBlocks.SERAPHINITE_BLOCK.get());
                        pOutput.accept(ModBlocks.WATERMELON_TOURMALINE_BLOCK.get());

                        pOutput.accept(ModBlocks.MOONSTONE_GLASS.get());
                        pOutput.accept(ModBlocks.GREY_QUARTZ_GLASS.get());
                        pOutput.accept(ModBlocks.HEMATITE_GLASS.get());
                        pOutput.accept(ModBlocks.ONYX_GLASS.get());
                        pOutput.accept(ModBlocks.ZIRCON_GLASS.get());
                        pOutput.accept(ModBlocks.RUBY_GLASS.get());
                        pOutput.accept(ModBlocks.TOPAZ_GLASS.get());
                        pOutput.accept(ModBlocks.CITRINE_GLASS.get());
                        pOutput.accept(ModBlocks.PERIDOT_GLASS.get());
                        pOutput.accept(ModBlocks.JADE_GLASS.get());
                        pOutput.accept(ModBlocks.TURQUOISE_GLASS.get());
                        pOutput.accept(ModBlocks.LARIMAR_GLASS.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_GLASS.get());
                        pOutput.accept(ModBlocks.SUGILITE_GLASS.get());
                        pOutput.accept(ModBlocks.SPINEL_GLASS.get());
                        pOutput.accept(ModBlocks.PINK_DIAMOND_GLASS.get());
                        pOutput.accept(ModBlocks.SERAPHINITE_GLASS.get());
                        pOutput.accept(ModBlocks.WATERMELON_TOURMALINE_GLASS.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
