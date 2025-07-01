package net.reconhalcyon.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import org.jetbrains.annotations.NotNull;


import java.util.Objects;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // ═══╬═══ Gem to Block and Back Recipe Loop ═══╬═══
        ModGemRegistry.GEMS.keySet().forEach(name -> {
            Item gem = ModGemRegistry.GEMS.get(name).get();
            Block block = ModGemRegistry.GEM_BLOCKS.get(name).get();
            gemToBlockAndBack(consumer, block, gem);
        });
        // ═══╬═══ Gem Glass Block Recipe Loop ═══╬═══
        ModGemRegistry.GEM_GLASS_BLOCKS.keySet().forEach(name -> {
            Item gem = ModGemRegistry.GEMS.get(name).get();
            Block glassBlock = ModGemRegistry.GEM_GLASS_BLOCKS.get(name).get();
            gemGlassRecipe(consumer, glassBlock, gem);
        });
        ModGemRegistry.BUDDING_BLOCKS.keySet().forEach( name -> {
            Item gem = ModGemRegistry.GEMS.get(name).get();
            Block buddingBlock = ModGemRegistry.BUDDING_BLOCKS.get(name).get();
            Block gemBlock = ModGemRegistry.GEM_BLOCKS.get(name).get();
            gemBuddingBlockRecipe(consumer, buddingBlock, gem, gemBlock);
        });

        // ═══╬═══ Geology Pickaxe Recipe ═══╬═══
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEOLOGY_PICKAXE.get())
                .pattern("ISI")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(consumer, new ResourceLocation(Reconium.MOD_ID, "geology_pickaxe"));
    }

    private void gemToBlockAndBack(Consumer<FinishedRecipe> consumer, Block block, Item gem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                .pattern("MM")
                .pattern("MM")
                .define('M', gem)
                .unlockedBy(getHasName(gem), has(gem))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, gem, 4)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(consumer);
    }

    private void gemGlassRecipe(Consumer<FinishedRecipe> consumer, Block glassBlock, Item gem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, glassBlock)
                .pattern("GGG")
                .pattern("GCG")
                .pattern("GGG")
                .define('G', Items.GLASS)
                .define('C', gem)
                .unlockedBy(getHasName(gem), has(gem))
                .save(consumer, new ResourceLocation(Reconium.MOD_ID,
                        Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(glassBlock)).getPath() + "_crafting"));
    }

    private void gemBuddingBlockRecipe(Consumer<FinishedRecipe> consumer, Block buddingBlock, Item gem, Block GemBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, buddingBlock)
                .pattern("CGC")
                .pattern("GBG")
                .pattern("CGC")
                .define('C', Items.COBBLESTONE)
                .define('G', gem)
                .define('B', GemBlock)
                .unlockedBy(getHasName(gem), has(gem))
                .save(consumer, new ResourceLocation(Reconium.MOD_ID,
                        Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(buddingBlock)).getPath() + "_crafting"));
    }
}
