package net.reconhalcyon.reconium.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.reconium.Reconium;

public class ModMenuTypes {
    static {
        Reconium.LOGGER.info("ModMenuTypes class loaded.");
    }

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.MENU, Reconium.MOD_ID);

    public static final java.util.function.Supplier<MenuType<GemPolishingStationMenu>> GEM_POLISHING_MENU =
            registerMenuType("gem_polishing_menu", GemPolishingStationMenu::new);


    private static <T extends AbstractContainerMenu>java.util.function.Supplier<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}



