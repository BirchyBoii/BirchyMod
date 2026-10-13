package net.birchyboii.birchy.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.birchyboii.birchy.recipe.BirchisizerRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;


public class BirchisizerDisplay extends BasicDisplay {
    public BirchisizerDisplay(RecipeEntry<BirchisizerRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().inputItem())),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().output()))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return BirchisizerCategory.BIRCHISIZER;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return null;
    }
}
