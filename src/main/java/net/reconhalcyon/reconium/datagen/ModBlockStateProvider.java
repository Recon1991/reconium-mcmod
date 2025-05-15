package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider (PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Reconium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.GREY_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.HEMATITE_BLOCK);
        blockWithItem(ModBlocks.ONYX_BLOCK);
        blockWithItem(ModBlocks.ZIRCON_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.TOPAZ_BLOCK);
        blockWithItem(ModBlocks.CITRINE_BLOCK);
        blockWithItem(ModBlocks.PERIDOT_BLOCK);
        blockWithItem(ModBlocks.JADE_BLOCK);
        blockWithItem(ModBlocks.TURQUOISE_BLOCK);
        blockWithItem(ModBlocks.LARIMAR_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.AMETHYST_BLOCK);
        blockWithItem(ModBlocks.SPINEL_BLOCK);
        blockWithItem(ModBlocks.PINK_DIAMOND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
