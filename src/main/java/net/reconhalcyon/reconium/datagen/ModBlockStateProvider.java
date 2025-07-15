package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.client.model.generators.ModelFile;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.block.custom.GemTallCropBlock;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

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

        // ═══╬═══ Flower/Potted Flower States ═══╬═══
        simpleBlockWithItem(ModBlocks.MOONSTONE_FLOWER.get(), models().cross("moonstone_flower",
                modLoc("block/flower/moonstone_flower")).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_MOONSTONE_FLOWER.get(), models().singleTexture("potted_moonstone_flower", new ResourceLocation("flower_pot_cross"), "plant",
                modLoc("block/flower/moonstone_flower")).renderType("cutout"));

        makeGemCrop(((CropBlock) ModBlocks.GEM_TALL_CROP.get()), "gem_tall_crop_stage_", "gem_tall_crop_stage_");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemTranslucent(RegistryObject<Block> blockRegistryObject) {
        assert blockRegistryObject.getId() != null;
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(blockRegistryObject.getId().getPath(), modLoc("block/" + blockRegistryObject.getId().getPath())));
    }

    public void makeGemCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> gemCropStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] gemCropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GemTallCropBlock) block).getAgeProperty()),
                new ResourceLocation(Reconium.MOD_ID, "block/crop/" + textureName + state.getValue(((GemTallCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void createAmethystClusterModel(RegistryObject<Block> block, String name) {
        System.out.println("→ Generating cluster model for: " + name);
        ModelFile model = models().cross(name, modLoc("block/budding/" + name)).renderType("cutout");
        getVariantBuilder(block.get()).forAllStates(state -> {
            Direction dir = state.getValue(AmethystClusterBlock.FACING);
            int rotX, rotY;
            rotY = switch (dir) {
                case DOWN -> {
                    rotX = 180;
                    yield 0;
                }
                case NORTH -> {
                    rotX = 90;
                    yield 0;
                }
                case SOUTH -> {
                    rotX = 90;
                    yield 180;
                }
                case WEST -> {
                    rotX = 90;
                    yield 270;
                }
                case EAST -> {
                    rotX = 90;
                    yield 90;
                }
                default -> {
                    rotX = 0;
                    yield 0;
                }
            };
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationX(rotX)
                    .rotationY(rotY)
                    //.uvLock(true)
                    .build();
        });
    }

}
