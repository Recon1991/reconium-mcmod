package net.reconhalcyon.reconium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.reconhalcyon.reconium.Reconium;
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
        ModGemRegistry.GEMS.keySet().forEach(name -> {
            Item gem = ModGemRegistry.GEMS.get(name).get();
            Block block = ModGemRegistry.GEM_BLOCKS.get(name).get();
            gemToBlockAndBack(consumer, block, gem);
        });
        // glass recipe loop
        ModGemRegistry.GEM_GLASS_BLOCKS.keySet().forEach(name -> {
            Item gem = ModGemRegistry.GEMS.get(name).get();
            Block glassBlock = ModGemRegistry.GEM_GLASS_BLOCKS.get(name).get();
            gemGlassRecipe(consumer, glassBlock, gem);
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


}
