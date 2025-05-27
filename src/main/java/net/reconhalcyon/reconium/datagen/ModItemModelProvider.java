package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.Locale;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reconium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModGemRegistry.GEMS.values().forEach(this::simpleItem);
        ModGemRegistry.GEM_BLOCKS.values().forEach(this::blockWithItem);
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(this::blockWithItem);

        for (String gemId : ModGemRegistry.BUDDING_BLOCKS.keySet()) {
            String base = gemId.toLowerCase(Locale.ROOT);

            withExistingParent(ModGemRegistry.BUDDING_BLOCKS.get(gemId).getId().getPath(),
                    modLoc("block/budding_" + base));

            withExistingParent(ModGemRegistry.SMALL_BUDS.get(gemId).getId().getPath(),
                    modLoc("block/small_" + base + "_bud"));
            withExistingParent(ModGemRegistry.MEDIUM_BUDS.get(gemId).getId().getPath(),
                    modLoc("block/medium_" + base + "_bud"));
            withExistingParent(ModGemRegistry.LARGE_BUDS.get(gemId).getId().getPath(),
                    modLoc("block/large_" + base + "_bud"));
            withExistingParent(ModGemRegistry.CLUSTERS.get(gemId).getId().getPath(),
                    modLoc("block/" + base + "_cluster"));
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Reconium.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void blockWithItem(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(),
                modLoc("block/" + block.getId().getPath()));
    }

}
