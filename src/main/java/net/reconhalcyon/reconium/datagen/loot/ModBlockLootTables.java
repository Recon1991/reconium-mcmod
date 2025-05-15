package net.reconhalcyon.reconium.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MOONSTONE_BLOCK.get());
        this.dropSelf(ModBlocks.GREY_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.HEMATITE_BLOCK.get());
        this.dropSelf(ModBlocks.ONYX_BLOCK.get());
        this.dropSelf(ModBlocks.ZIRCON_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        this.dropSelf(ModBlocks.CITRINE_BLOCK.get());
        this.dropSelf(ModBlocks.PERIDOT_BLOCK.get());
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.TURQUOISE_BLOCK.get());
        this.dropSelf(ModBlocks.LARIMAR_BLOCK.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SUGILITE_BLOCK.get());
        this.dropSelf(ModBlocks.SPINEL_BLOCK.get());
        this.dropSelf(ModBlocks.PINK_DIAMOND_BLOCK.get());
        this.dropSelf(ModBlocks.SERAPHINITE_BLOCK.get());
        this.dropSelf(ModBlocks.WATERMELON_TOURMALINE_BLOCK.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
