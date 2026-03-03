package net.reconhalcyon.reconium.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

import java.util.List;

public record GemPolishingRecipe(Ingredient inputItem, ItemStack output) implements Recipe<SingleRecipeInput> {
    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        return inputItem.test(input.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.EMPTY, inputItem);
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static final class Type implements RecipeType<GemPolishingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "gem_polishing";
    }

    public static final class Serializer implements RecipeSerializer<GemPolishingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final MapCodec<GemPolishingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").forGetter(recipe -> List.of(recipe.inputItem())),
                        ItemStack.STRICT_CODEC.fieldOf("result").forGetter(GemPolishingRecipe::output)
                ).apply(instance, (ingredients, result) -> new GemPolishingRecipe(ingredients.getFirst(), result))
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, GemPolishingRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC,
                GemPolishingRecipe::inputItem,
                ItemStack.STREAM_CODEC,
                GemPolishingRecipe::output,
                GemPolishingRecipe::new
        );

        @Override
        public MapCodec<GemPolishingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, GemPolishingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
