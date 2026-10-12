package net.birchyboii.birchy.recipe;

import net.birchyboii.birchy.BirchyMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<BirchisizerRecipe> BIRCHISIZER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(BirchyMod.MOD_ID, "birchisizer"),
                    new BirchisizerRecipe.Serializer());
    public static final RecipeType<BirchisizerRecipe> BIRCHISIZER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(BirchyMod.MOD_ID, "birchisizer"), new RecipeType<BirchisizerRecipe>() {
                @Override
                public String toString() {
                    return "birchisizer";
                }
            });

    public static void registerRecipes() {
        BirchyMod.LOGGER.info("Registering Custom Recipes for " + BirchyMod.MOD_ID);
    }

}
