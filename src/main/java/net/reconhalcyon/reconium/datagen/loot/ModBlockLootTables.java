package net.reconhalcyon.reconium.datagen.loot;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.registries.RegistryObject;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.block.custom.GemTallCropBlock;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Gem Blocks: always drop self
        ModGemRegistry.GEM_BLOCKS.values().forEach(reg ->
                this.dropSelf(reg.get())
        );

        // Gem Glass Blocks: silk touch only
        ModGemRegistry.GEM_GLASS_BLOCKS.values().forEach(reg ->
                this.add(reg.get(), createSilkTouchOnlyTable(reg.get()))
        );

        // Gem Ores: unified loot table with geology pickaxe vs normal
        TagKey<Item> geologyPickTag = ItemTags.create(
                new ResourceLocation(Reconium.MOD_ID, "geology_pickaxes")
        );

        this.dropSelf(ModBlocks.MOONSTONE_FLOWER.get());
        this.add(ModBlocks.POTTED_MOONSTONE_FLOWER.get(),
                createPotFlowerItemTable(ModBlocks.MOONSTONE_FLOWER.get())
        );

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.GEM_TALL_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GemTallCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.GEM_TALL_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GemTallCropBlock.AGE, 8)));

        // LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
        //         .hasBlockStateProperties(ModBlocks.GEM_TALL_CROP.get())
        //         .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GemTallCropBlock.AGE, 8));

        this.add(ModBlocks.GEM_TALL_CROP.get(), createCropDrops(ModBlocks.GEM_TALL_CROP.get(), ModItems.MOONSTONE.get(),
                ModItems.GEM_SEEDS.get(), lootitemcondition$builder2));


        ModGemRegistry.getAllOreBlockGroups().forEach(group -> {
            for (Map.Entry<String, RegistryObject<Block>> entry : group.entrySet()) {
                String gemName = entry.getKey();
                Block  block   = entry.getValue().get();
                Item   drop    = ModGemRegistry.GEMS.get(gemName).get();

                LootTable.Builder builder = LootTable.lootTable()
                        // Pool #1: geology pickaxe yields 2–5 + Fortune
                        .withPool(LootPool.lootPool()
                                .when(MatchTool.toolMatches(
                                        ItemPredicate.Builder.item()
                                                .of(geologyPickTag)
                                ))
                                .add(LootItem.lootTableItem(drop)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(2, 5)
                                        ))
                                        .apply(ApplyBonusCount.addUniformBonusCount(
                                                Enchantments.BLOCK_FORTUNE
                                        ))
                                )
                        )
                        // Pool #2: normal pick yields 1–2 + Fortune
                        .withPool(LootPool.lootPool()
                                .when(InvertedLootItemCondition.invert(
                                        MatchTool.toolMatches(
                                                ItemPredicate.Builder.item()
                                                        .of(geologyPickTag)
                                        )
                                ))
                                .add(LootItem.lootTableItem(drop)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1, 2)
                                        ))
                                        .apply(ApplyBonusCount.addUniformBonusCount(
                                                Enchantments.BLOCK_FORTUNE
                                        ))
                                )
                        );

                this.add(block, builder);
            }
        });

        // Budding Blocks: drop self
        ModGemRegistry.BUDDING_BLOCKS.values().forEach(reg ->
                this.dropSelf(reg.get())
        );

        // Bud Stages: small/medium/large drop only with Silk Touch
        Stream.of(
                        ModGemRegistry.SMALL_BUDS,
                        ModGemRegistry.MEDIUM_BUDS,
                        ModGemRegistry.LARGE_BUDS
                ).flatMap(map -> map.values().stream())
                .forEach(reg -> this.add(reg.get(), createSilkTouchOnlyTable(reg.get())));

        // Clusters: silk touch yields block, otherwise drop shards 4–5 + Fortune
        ModGemRegistry.CLUSTERS.forEach((gemName, reg) -> {
            Block clusterBlock = reg.get();
            Item shardItem    = ModGemRegistry.GEMS.get(gemName).get();

            LootTable.Builder builder = LootTable.lootTable()
                    // Pool 1: geology pickaxe, 4–5 + Fortune 2
                    .withPool(LootPool.lootPool()
                            .when(MatchTool.toolMatches(
                                    ItemPredicate.Builder.item().of(geologyPickTag)
                            ))
                            .add(LootItem.lootTableItem(shardItem)
                                    .apply(SetItemCountFunction.setCount(
                                            UniformGenerator.between(4, 5)
                                    ))
                                    .apply(ApplyBonusCount.addUniformBonusCount(
                                            Enchantments.BLOCK_FORTUNE, 2 // Fortune level 2
                                    ))
                            )
                    )
                    // Pool 2: other tools, 1–2, no Fortune
                    .withPool(LootPool.lootPool()
                            .when(InvertedLootItemCondition.invert(
                                    MatchTool.toolMatches(
                                            ItemPredicate.Builder.item().of(geologyPickTag)
                                    )
                            ))
                            .add(LootItem.lootTableItem(shardItem)
                                    .apply(SetItemCountFunction.setCount(
                                            UniformGenerator.between(1, 2)
                                    ))
                            )
                    );

            this.add(clusterBlock, builder);
        });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        // Return all blocks registered in ModBlocks
        return ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}