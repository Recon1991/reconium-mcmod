package net.reconhalcyon.reconium.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.custom.ModGeologyPickaxeItem;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import net.reconhalcyon.reconium.registry.ReconRegistryHelper;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Reconium.MOD_ID);

    public static final RegistryObject<Item> MOONSTONE = createAndRegisterGemItem("moonstone");
    public static final RegistryObject<Item> GREY_QUARTZ = createAndRegisterGemItem("grey_quartz");
    public static final RegistryObject<Item> HEMATITE = createAndRegisterGemItem("hematite");
    public static final RegistryObject<Item> ONYX = createAndRegisterGemItem("onyx");
    public static final RegistryObject<Item> ZIRCON = createAndRegisterGemItem("zircon");
    public static final RegistryObject<Item> RUBY = createAndRegisterGemItem("ruby");
    public static final RegistryObject<Item> TOPAZ = createAndRegisterGemItem("topaz");
    public static final RegistryObject<Item> CITRINE = createAndRegisterGemItem("citrine");
    public static final RegistryObject<Item> PERIDOT = createAndRegisterGemItem("peridot");
    public static final RegistryObject<Item> JADE = createAndRegisterGemItem("jade");
    public static final RegistryObject<Item> TURQUOISE = createAndRegisterGemItem("turquoise");
    public static final RegistryObject<Item> LARIMAR = createAndRegisterGemItem("larimar");
    public static final RegistryObject<Item> SAPPHIRE = createAndRegisterGemItem("sapphire");
    public static final RegistryObject<Item> SUGILITE = createAndRegisterGemItem("sugilite");
    public static final RegistryObject<Item> SPINEL = createAndRegisterGemItem("spinel");
    public static final RegistryObject<Item> PINK_DIAMOND = createAndRegisterGemItem("pink_diamond");
    public static final RegistryObject<Item> SERAPHINITE = createAndRegisterGemItem("seraphinite");
    public static final RegistryObject<Item> WATERMELON_TOURMALINE = createAndRegisterGemItem("watermelon_tourmaline");
    public static final RegistryObject<Item> GEOLOGY_PICKAXE = ITEMS.register("geology_pickaxe", ModGeologyPickaxeItem::new);


    // Gem register helper method to condense boilerplate
    private static RegistryObject<Item> createAndRegisterGemItem(String name) {
        RegistryObject<Item> item = ReconRegistryHelper.registerSimpleItem(ITEMS, name);
        ModGemRegistry.trackGemItem(name, item);
        return item;
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
