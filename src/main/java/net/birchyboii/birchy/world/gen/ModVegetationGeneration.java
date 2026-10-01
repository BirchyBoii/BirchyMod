package net.birchyboii.birchy.world.gen;

import net.birchyboii.birchy.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModVegetationGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIRCHY_TREE_PLACED_KEY);
    }

    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_BARRENS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIRCHY_BERRY_BUSH_PLACED_KEY);
    }
}
