package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
            ReconRecipeHelper.gemToBlockAndBack(consumer, block, gem);
        });
    }

}
