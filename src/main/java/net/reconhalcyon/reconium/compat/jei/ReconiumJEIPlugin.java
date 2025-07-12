package net.reconhalcyon.reconium.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class ReconiumJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(Reconium.MOD_ID, "jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        // For custom categories — optional, can be skipped for basic recipes
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        // Optional if you're just using vanilla JSON shaped/shapeless recipes
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        // Show which blocks/tools open a category
        //registration.addRecipeCatalyst(new ItemStack(ModItems.GEOLOGY_PICKAXE.get()), net.minecraft.world.item.crafting.RecipeType.CRAFTING);
    }
}
