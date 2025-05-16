package net.reconhalcyon.reconium.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.registry.ModGemRegistry;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        ModGemRegistry.GEM_BLOCKS.values().forEach(block ->
                this.dropSelf(block.get())
        );

        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(block ->
                this.add(block.get(), createSilkTouchOnlyTable(block.get()))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
