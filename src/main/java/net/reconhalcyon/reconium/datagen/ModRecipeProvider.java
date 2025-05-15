package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOONSTONE_BLOCK.get())
                .pattern("   ")
                .pattern(" MM")
                .pattern(" MM")
                .define('M', ModItems.MOONSTONE.get())
                .unlockedBy(getHasName(ModItems.MOONSTONE.get()), has(ModItems.MOONSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MOONSTONE.get(), 4)
                .requires(ModBlocks.MOONSTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MOONSTONE_BLOCK.get()), has(ModBlocks.MOONSTONE_BLOCK.get()))
                .save(consumer);
    }
}
