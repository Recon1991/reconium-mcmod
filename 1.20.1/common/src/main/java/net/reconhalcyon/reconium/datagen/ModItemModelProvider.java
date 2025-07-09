package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reconium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Gem items
        ModGemRegistry.GEMS.values().forEach(this::simpleItem);

        // Blocks
        ModGemRegistry.GEM_BLOCKS.values().forEach(this::blockWithItem);
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(this::blockWithItem);

        // Tool
        simpleItem(ModItems.GEOLOGY_PICKAXE);

        // Budding + clusters
        ModGemRegistry.BUDDING_BLOCKS.forEach((name, block) ->
                withExistingParent(getName(block), modLoc("block/budding_" + name)));
        ModGemRegistry.SMALL_BUDS.forEach((name, block) ->
                withExistingParent(getName(block), modLoc("block/small_" + name + "_bud")));
        ModGemRegistry.MEDIUM_BUDS.forEach((name, block) ->
                withExistingParent(getName(block), modLoc("block/medium_" + name + "_bud")));
        ModGemRegistry.LARGE_BUDS.forEach((name, block) ->
                withExistingParent(getName(block), modLoc("block/large_" + name + "_bud")));
        ModGemRegistry.CLUSTERS.forEach((name, block) ->
                withExistingParent(getName(block), modLoc("block/" + name + "_cluster")));
    }

    private void simpleItem(Item item) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        withExistingParent(id.getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Reconium.MOD_ID, "item/" + id.getPath()));
    }

    private void blockWithItem(Block block) {
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(block);
        withExistingParent(id.getPath(), modLoc("block/" + id.getPath()));
    }

    private String getName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }
}
