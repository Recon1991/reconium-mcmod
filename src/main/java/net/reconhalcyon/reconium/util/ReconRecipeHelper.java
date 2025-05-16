package net.reconhalcyon.reconium.util;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

import static net.minecraft.data.recipes.RecipeBuilder.getHasName;
import static net.minecraft.data.recipes.RecipeBuilder.has;

public class ReconRecipeHelper {

    public static void gemToBlockAndBack(Consumer<FinishedRecipe> consumer, Block block, Item gem) {
        // 4 gems → 1 block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                .pattern("   ")
                .pattern(" MM")
                .pattern(" MM")
                .define('M', gem)
                .unlockedBy(getHasName(gem), has(gem))
                .save(consumer);

        // 1 block → 4 gems
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, gem, 4)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(consumer);
    }
}
