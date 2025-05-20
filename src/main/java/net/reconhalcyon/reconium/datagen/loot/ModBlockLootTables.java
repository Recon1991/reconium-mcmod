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

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    // Custom method for gem ore drops (like createCopperOreDrops)
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
        ModGemRegistry.GEM_BLOCKS.values().forEach(block ->
                this.dropSelf(block.get())
        );

        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(block ->
                this.add(block.get(), createSilkTouchOnlyTable(block.get()))
        );

        // Automate loot tables for all gem ores with custom drop counts
        ModGemRegistry.GEM_ORE_BASES.forEach((block, baseType) -> {
            assert block.getId() != null;
            String blockId = block.getId().getPath();
            String gemName = blockId
                .replaceFirst("^deepslate_", "")
                .replaceFirst("^nether_", "")
                .replaceFirst("^end_", "")
                .replaceFirst("_ore$", "");
            RegistryObject<?> gemItemObj = ModGemRegistry.GEMS.get(gemName);
            if (gemItemObj != null) {
                this.add(block.get(), createGemOreDrops(block.get(), (Item) gemItemObj.get())); // 2-5 drops
            }
        });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
