package net.birchyboii.birchy.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.birchyboii.birchy.recipe.BirchisizerRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.Arrays;
import java.util.List;


public class BirchisizerDisplay extends BasicDisplay {
    public BirchisizerDisplay(RecipeEntry<BirchisizerRecipe> recipe) {
        super(List.of(EntryIngredients.ofItemStacks(
                                Arrays.stream(recipe.value().inputItem().getMatchingStacks())
                                        .map(stack -> stack.copyWithCount(recipe.value().inputCount()))
                                        .toList())),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return BirchisizerCategory.BIRCHISIZER;
    }
}
