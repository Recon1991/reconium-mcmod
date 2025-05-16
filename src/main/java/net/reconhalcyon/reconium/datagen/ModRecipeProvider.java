package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import net.reconhalcyon.reconium.util.ReconRecipeHelper;


import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ModGemRegistry.GEMS.keySet().forEach(name -> {
            var gem = ModGemRegistry.GEMS.get(name).get();
            var block = ModGemRegistry.GEM_BLOCKS.get(name).get();
            gemToBlockAndBack(consumer, block, gem);
        });
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


}
