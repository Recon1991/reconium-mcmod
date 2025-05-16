package net.reconhalcyon.reconium.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import net.reconhalcyon.reconium.registry.ReconRegistryHelper;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Reconium.MOD_ID);

    public static final RegistryObject<Item> MOONSTONE = registerGemItem("moonstone");
    public static final RegistryObject<Item> GREY_QUARTZ = registerGemItem("grey_quartz");
    public static final RegistryObject<Item> HEMATITE = registerGemItem("hematite");
    public static final RegistryObject<Item> ONYX = registerGemItem("onyx");
    public static final RegistryObject<Item> ZIRCON = registerGemItem("zircon");
    public static final RegistryObject<Item> RUBY = registerGemItem("ruby");
    public static final RegistryObject<Item> TOPAZ = registerGemItem("topaz");
    public static final RegistryObject<Item> CITRINE = registerGemItem("citrine");
    public static final RegistryObject<Item> PERIDOT = registerGemItem("peridot");
    public static final RegistryObject<Item> JADE = registerGemItem("jade");
    public static final RegistryObject<Item> TURQUOISE = registerGemItem("turquoise");
    public static final RegistryObject<Item> LARIMAR = registerGemItem("larimar");
    public static final RegistryObject<Item> SAPPHIRE = registerGemItem("sapphire");
    public static final RegistryObject<Item> SUGILITE = registerGemItem("sugilite");
    public static final RegistryObject<Item> SPINEL = registerGemItem("spinel");
    public static final RegistryObject<Item> PINK_DIAMOND = registerGemItem("pink_diamond");
    public static final RegistryObject<Item> SERAPHINITE = registerGemItem("seraphinite");
    public static final RegistryObject<Item> WATERMELON_TOURMALINE = registerGemItem("watermelon_tourmaline");

    // Gem register helper method to condense boilerplate
    private static RegistryObject<Item> registerGemItem(String name) {
        RegistryObject<Item> item = ReconRegistryHelper.registerSimpleItem(ITEMS, name);
        ModGemRegistry.GEMS.put(name, item);
        return item;
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
