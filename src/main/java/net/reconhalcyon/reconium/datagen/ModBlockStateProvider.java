package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.Map;
import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Reconium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Map<String, RegistryObject<Block>> group : ModGemRegistry.getAllOreBlockGroups()) {
            String base = ModGemRegistry.getBaseNameFromMap(group);
            for (Map.Entry<String, RegistryObject<Block>> entry : group.entrySet()) {
                String gem = entry.getKey();
                Block block = entry.getValue().get();
                registerGemOreModel(block, gem, base);
            }
        }

        ModGemRegistry.GEM_BLOCKS.values().forEach(this::blockWithItem);
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(this::blockWithItemTranslucent);
    }

    private void registerGemOreModel(Block block, String gemName, String baseTextureName) {
        String blockName = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();

        ModelFile model = models().withExistingParent(blockName, modLoc("block/template_overlay"))
                .texture("base", modLoc("block/base_" + baseTextureName))
                .texture("overlay", modLoc("block/overlay/gem_" + gemName));

        simpleBlockWithItem(block, model);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemTranslucent(RegistryObject<Block> blockRegistryObject) {
        assert blockRegistryObject.getId() != null;
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(blockRegistryObject.getId().getPath(), modLoc("block/" + blockRegistryObject.getId().getPath())));
    }
}
