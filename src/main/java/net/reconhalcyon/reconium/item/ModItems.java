package net.reconhalcyon.reconium.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Reconium.MOD_ID);

    public static final RegistryObject<Item> MOONSTONE = ITEMS.register("moonstone", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREY_QUARTZ = ITEMS.register("grey_quartz", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEMATITE = ITEMS.register("hematite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TURQUOISE = ITEMS.register("turquoise", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARIMAR = ITEMS.register("larimar", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE = ITEMS.register("sugilite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPINEL = ITEMS.register("spinel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINK_DIAMOND = ITEMS.register("pink_diamond", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SERAPHINITE = ITEMS.register("seraphinite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATERMELON_TOURMALINE = ITEMS.register("watermelon_tourmaline", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
