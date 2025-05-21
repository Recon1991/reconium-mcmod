package net.reconhalcyon.reconium.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected LootTable.Builder createGemOreDrops(Block block, Item drop) {
        return createSilkTouchDispatchTable(
                block,
                this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }

    @Override
    protected void generate() {
        // Gem Blocks
        ModGemRegistry.GEM_BLOCKS.values().forEach(block ->
                this.dropSelf(block.get())
        );

        // Gem Glass Blocks (Silk Touch only)
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(block ->
                this.add(block.get(), createSilkTouchOnlyTable(block.get()))
        );

        // Gem Ores (2–5 drops + Fortune)
        for (Map<String, RegistryObject<Block>> group : ModGemRegistry.getAllOreBlockGroups()) {
            for (Map.Entry<String, RegistryObject<Block>> entry : group.entrySet()) {
                String gemName = entry.getKey();
                Block block = entry.getValue().get();

                RegistryObject<Item> gemItem = ModGemRegistry.GEMS.get(gemName);
                if (gemItem != null) {
                    this.add(block, createGemOreDrops(block, gemItem.get()));
                }
            }
        }
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
