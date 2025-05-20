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
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(this::blockWithItemTranslucent);
        // Register ore blocks with overlays using the new GEM_ORE_BASES map
        ModGemRegistry.GEM_ORE_BASES.forEach((block, baseType) -> {
            String baseTexture = BASE_STONES.get(baseType);
            blockWithOverlayOre(block, baseTexture);
        });
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemTranslucent(RegistryObject<Block> blockRegistryObject) {
        assert blockRegistryObject.getId() != null;
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(blockRegistryObject.getId().getPath(), modLoc("block/" + blockRegistryObject.getId().getPath())));
    }

    private void blockWithOverlayOre(RegistryObject<Block> block, String baseTexture) {
        assert block.getId() != null;
        String name = block.getId().getPath();
        // Extract gem name from block name (removes deepslate_, nether_, end_ prefixes and _ore suffix)
        String gemName = name
            .replaceFirst("^deepslate_", "")
            .replaceFirst("^nether_", "")
            .replaceFirst("^end_", "")
            .replaceFirst("_ore$", "");

        // Block model with per-gem overlay using vanilla-style layer0/layer1
        models().withExistingParent(name, modLoc("block/ore"))
                .texture("layer0", baseTexture)
                .texture("layer1", modLoc("block/ore_" + gemName));

        // Blockstate and inventory model
        simpleBlockWithItem(block.get(), models().getExistingFile(modLoc("block/" + name)));
    }
}

