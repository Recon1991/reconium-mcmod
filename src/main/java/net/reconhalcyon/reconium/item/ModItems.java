package net.reconhalcyon.reconium.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.item.custom.ModGeologyPickaxeItem;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import net.reconhalcyon.reconium.registry.ReconRegistryHelper;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.ITEM, Reconium.MOD_ID);

    public static final java.util.function.Supplier<Item> MOONSTONE = createAndRegisterGemItem("moonstone");
    public static final java.util.function.Supplier<Item> GREY_QUARTZ = createAndRegisterGemItem("grey_quartz");
    public static final java.util.function.Supplier<Item> HEMATITE = createAndRegisterGemItem("hematite");
    public static final java.util.function.Supplier<Item> ONYX = createAndRegisterGemItem("onyx");
    public static final java.util.function.Supplier<Item> ZIRCON = createAndRegisterGemItem("zircon");
    public static final java.util.function.Supplier<Item> RUBY = createAndRegisterGemItem("ruby");
    public static final java.util.function.Supplier<Item> TOPAZ = createAndRegisterGemItem("topaz");
    public static final java.util.function.Supplier<Item> CITRINE = createAndRegisterGemItem("citrine");
    public static final java.util.function.Supplier<Item> PERIDOT = createAndRegisterGemItem("peridot");
    public static final java.util.function.Supplier<Item> JADE = createAndRegisterGemItem("jade");
    public static final java.util.function.Supplier<Item> TURQUOISE = createAndRegisterGemItem("turquoise");
    public static final java.util.function.Supplier<Item> LARIMAR = createAndRegisterGemItem("larimar");
    public static final java.util.function.Supplier<Item> SAPPHIRE = createAndRegisterGemItem("sapphire");
    public static final java.util.function.Supplier<Item> SUGILITE = createAndRegisterGemItem("sugilite");
    public static final java.util.function.Supplier<Item> SPINEL = createAndRegisterGemItem("spinel");
    public static final java.util.function.Supplier<Item> PINK_DIAMOND = createAndRegisterGemItem("pink_diamond");
    public static final java.util.function.Supplier<Item> SERAPHINITE = createAndRegisterGemItem("seraphinite");
    public static final java.util.function.Supplier<Item> WATERMELON_TOURMALINE = createAndRegisterGemItem("watermelon_tourmaline");
    public static final java.util.function.Supplier<Item> GEOLOGY_PICKAXE = ITEMS.register("geology_pickaxe", ModGeologyPickaxeItem::new);

    public static final java.util.function.Supplier<Item> GEM_SEEDS = ITEMS.register("gem_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GEM_TALL_CROP.get(), new Item.Properties()));

    // Gem register helper method to condense boilerplate
    private static java.util.function.Supplier<Item> createAndRegisterGemItem(String name) {
        java.util.function.Supplier<Item> item = ReconRegistryHelper.registerSimpleItem(ITEMS, name);
        ModGemRegistry.trackGemItem(name, item);
        return item;
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}




