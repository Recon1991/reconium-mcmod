package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.Map;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider (PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Reconium.MOD_ID, exFileHelper);
    }

    private static final Map<String, String> BASE_STONES = Map.of(
            "stone", "minecraft:block/stone",
            "deepslate", "minecraft:block/deepslate",
            "nether", "minecraft:block/netherrack",
            "end", "minecraft:block/end_stone"
    );

    @Override
    protected void registerStatesAndModels() {
        // Gem Block State Registry Entries
        ModGemRegistry.GEM_BLOCKS.values().forEach(this::blockWithItem);
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(this::blockWithItemTranslucent
        );
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemTranslucent(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(blockRegistryObject.getId().getPath(), modLoc("block/" + blockRegistryObject.getId().getPath())));
    }

    private void blockWithOverlayOre(RegistryObject<Block> block, String baseTexture, String overlayTexture) {
        String name = block.getId().getPath();

        // Block model with overlay
        models().withExistingParent(name, mcLoc("block/ore"))
                .texture("base", baseTexture)
                .texture("overlay", modLoc("block/" + overlayTexture));

        // Blockstate and inventory model
        simpleBlockWithItem(block.get(), models().getExistingFile(modLoc("block/" + name)));
    }


}
