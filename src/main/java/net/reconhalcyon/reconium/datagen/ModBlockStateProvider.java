package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.Locale;
import java.util.Map;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Reconium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Map<String, RegistryObject<Block>> group : ModGemRegistry.getAllOreBlockGroups()) {
            for (RegistryObject<Block> block : group.values()) {
                blockWithItem(block);
            }
        }

        ModGemRegistry.GEM_BLOCKS.values().forEach(this::blockWithItem);
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(this::blockWithItemTranslucent);

        // ═══╬═══ Budding Block States ═══╬═══
        for (String gemId : ModGemRegistry.BUDDING_BLOCKS.keySet()) {
            String base = gemId.toLowerCase(Locale.ROOT);

            // Budding block (like budding_amethyst): cube_all
            simpleBlock(ModGemRegistry.BUDDING_BLOCKS.get(gemId).get(),
                    models().cubeAll("budding_" + base, modLoc("block/budding/budding_" + base)));

            // Cluster blocks
            createAmethystClusterModel(ModGemRegistry.SMALL_BUDS.get(gemId), "small_" + base + "_bud");
            createAmethystClusterModel(ModGemRegistry.MEDIUM_BUDS.get(gemId), "medium_" + base + "_bud");
            createAmethystClusterModel(ModGemRegistry.LARGE_BUDS.get(gemId), "large_" + base + "_bud");
            createAmethystClusterModel(ModGemRegistry.CLUSTERS.get(gemId), base + "_cluster");
        }
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemTranslucent(RegistryObject<Block> blockRegistryObject) {
        assert blockRegistryObject.getId() != null;
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(blockRegistryObject.getId().getPath(), modLoc("block/" + blockRegistryObject.getId().getPath())));
    }

    private void createAmethystClusterModel(RegistryObject<Block> block, String name) {
        getVariantBuilder(block.get()).forAllStates(state -> {
            Direction dir = state.getValue(AmethystClusterBlock.FACING);
            boolean waterlogged = state.hasProperty(AmethystClusterBlock.WATERLOGGED) && state.getValue(AmethystClusterBlock.WATERLOGGED);

            return ConfiguredModel.builder()
                    .modelFile(models().cross(name, modLoc("block/budding/" + name)).renderType("cutout"))
                    .rotationX(dir.getAxis().isVertical() ? (dir == Direction.UP ? 0 : 180) : 90)
                    .rotationY((int) dir.toYRot())
                    .uvLock(true)
                    .build();
        });
    }
}
