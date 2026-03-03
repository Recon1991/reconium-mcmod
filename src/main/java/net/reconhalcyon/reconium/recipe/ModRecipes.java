package net.reconhalcyon.reconium.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.reconium.Reconium;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.RECIPE_SERIALIZER, Reconium.MOD_ID);

    public static final java.util.function.Supplier<RecipeSerializer<GemPolishingRecipe>> GEM_POLISHING_SERIALIZER =
            SERIALIZERS.register("gem_polishing", () -> GemPolishingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}




