package net.birchyboii.birchy.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

public record BirchisizerRecipe(Ingredient inputItem, int inputCount, ItemStack output) implements Recipe<BirchisizerRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }



    @Override
    public boolean matches(BirchisizerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(BirchisizerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }


    @Override
    public RecipeSerializer<? extends Recipe<BirchisizerRecipeInput>> getSerializer() {
        return ModRecipes.BIRCHISIZER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<BirchisizerRecipeInput>> getType() {
        return ModRecipes.BIRCHISIZER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<BirchisizerRecipe> {
        public static final MapCodec<BirchisizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(BirchisizerRecipe::inputItem),
                Codecs.POSITIVE_INT.fieldOf("input_count").orElse(1).forGetter(BirchisizerRecipe::inputCount),
                ItemStack.CODEC.fieldOf("result").forGetter(BirchisizerRecipe::output)
        ).apply(inst, BirchisizerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, BirchisizerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, BirchisizerRecipe::inputItem,
                        PacketCodecs.INTEGER, BirchisizerRecipe::inputCount,
                        ItemStack.PACKET_CODEC, BirchisizerRecipe::output,
                        BirchisizerRecipe::new);

        @Override
        public MapCodec<BirchisizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, BirchisizerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
