package net.reconhalcyon.reconium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Reconium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MOONSTONE_BLOCK.get())
                .add(ModBlocks.GREY_QUARTZ_BLOCK.get())
                .add(ModBlocks.HEMATITE_BLOCK.get())
                .add(ModBlocks.ONYX_BLOCK.get())
                .add(ModBlocks.ZIRCON_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.CITRINE_BLOCK.get())
                .add(ModBlocks.PERIDOT_BLOCK.get())
                .add(ModBlocks.JADE_BLOCK.get())
                .add(ModBlocks.TURQUOISE_BLOCK.get())
                .add(ModBlocks.LARIMAR_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.AMETHYST_BLOCK.get())
                .add(ModBlocks.SPINEL_BLOCK.get())
                .add(ModBlocks.PINK_DIAMOND_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MOONSTONE_BLOCK.get())
                .add(ModBlocks.GREY_QUARTZ_BLOCK.get())
                .add(ModBlocks.HEMATITE_BLOCK.get())
                .add(ModBlocks.ONYX_BLOCK.get())
                .add(ModBlocks.ZIRCON_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.CITRINE_BLOCK.get())
                .add(ModBlocks.PERIDOT_BLOCK.get())
                .add(ModBlocks.JADE_BLOCK.get())
                .add(ModBlocks.TURQUOISE_BLOCK.get())
                .add(ModBlocks.LARIMAR_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.AMETHYST_BLOCK.get())
                .add(ModBlocks.SPINEL_BLOCK.get())
                .add(ModBlocks.PINK_DIAMOND_BLOCK.get());

    }
}
