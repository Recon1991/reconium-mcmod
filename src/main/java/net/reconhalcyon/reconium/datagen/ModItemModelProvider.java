package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reconium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MOONSTONE);
        simpleItem(ModItems.GREY_QUARTZ);
        simpleItem(ModItems.HEMATITE);
        simpleItem(ModItems.ONYX);
        simpleItem(ModItems.ZIRCON);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.TOPAZ);
        simpleItem(ModItems.CITRINE);
        simpleItem(ModItems.PERIDOT);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.TURQUOISE);
        simpleItem(ModItems.LARIMAR);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.SUGILITE);
        simpleItem(ModItems.SPINEL);
        simpleItem(ModItems.PINK_DIAMOND);
        simpleItem(ModItems.SERAPHINITE);
        simpleItem(ModItems.WATERMELON_TOURMALINE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Reconium.MOD_ID, "item/" + item.getId().getPath()));
    }
}
