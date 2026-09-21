package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BIRCHY_SHEET_SMELTABLES = List.of(ModItems.BIRCHY_CHUNK, ModBlocks.BIRCHY_ORE, ModBlocks.BIRCHY_DEEPSLATE_ORE);


        offerSmelting(exporter, BIRCHY_SHEET_SMELTABLES, RecipeCategory.MISC, ModItems.BIRCHY_SHEET, 0.25f, 200, "birchy_sheet");
        offerBlasting(exporter, BIRCHY_SHEET_SMELTABLES, RecipeCategory.MISC, ModItems.BIRCHY_SHEET, 0.25f, 100, "birchy_sheet");
        offerPlanksRecipe(exporter, ModBlocks.BIRCHY_PLANKS, ModTags.Items.BIRCHY_LOGS, 4);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BIRCHY_SHEET, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCHY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DRY_WAND)
                .pattern(" b ")
                .pattern(" s ")
                .pattern(" s ")
                .input('s', Items.STICK)
                .input('b', ModItems.BIRCHY_SHEET)
                .criterion(hasItem(ModItems.BIRCHY_SHEET), conditionsFromItem(ModItems.BIRCHY_SHEET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DRY_WAND, 1)
                .input(ModItems.MOIST_WAND)
                .criterion(hasItem(ModItems.MOIST_WAND), conditionsFromItem(ModItems.MOIST_WAND))
                .offerTo(exporter, Identifier.of(BirchyMod.MOD_ID, "dryer_wand_from_moist_wand"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOIST_WAND, 1)
                .input(ModItems.DRY_WAND)
                .criterion(hasItem(ModItems.DRY_WAND), conditionsFromItem(ModItems.DRY_WAND))
                .offerTo(exporter, Identifier.of(BirchyMod.MOD_ID, "moistening_wand_from_dry_wand"));

        createStairsRecipe(ModBlocks.BIRCHY_STAIRS, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCHY_SLAB, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCHY_BUTTON)
                .input(ModBlocks.BIRCHY_PLANKS)
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCHY_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        createFenceRecipe(ModBlocks.BIRCHY_FENCE, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        createFenceGateRecipe(ModBlocks.BIRCHY_FENCE_GATE, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        createDoorRecipe(ModBlocks.BIRCHY_DOOR, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        createTrapdoorRecipe(ModBlocks.BIRCHY_TRAPDOOR, Ingredient.ofItems(ModBlocks.BIRCHY_PLANKS))
                .criterion(hasItem(ModBlocks.BIRCHY_PLANKS), conditionsFromItem(ModBlocks.BIRCHY_PLANKS)).offerTo(exporter);

        offerSmithingTrimRecipe(exporter, ModItems.BIRCHY_SMITHING_TEMPLATE, Identifier.of(BirchyMod.MOD_ID, "birchy"));

    }
}
