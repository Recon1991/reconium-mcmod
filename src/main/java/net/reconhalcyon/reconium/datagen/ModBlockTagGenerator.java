package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Reconium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModGemRegistry.GEM_BLOCKS.values().stream().map(RegistryObject::get).toArray(Block[]::new)
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModGemRegistry.GEM_GLASS_BLOCKS.values().stream().map(RegistryObject::get).toArray(Block[]::new)
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModGemRegistry.GEM_BLOCKS.values().stream().map(RegistryObject::get).toArray(Block[]::new)
        );
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModGemRegistry.GEM_GLASS_BLOCKS.values().stream().map(RegistryObject::get).toArray(Block[]::new)
        );

    }
}
