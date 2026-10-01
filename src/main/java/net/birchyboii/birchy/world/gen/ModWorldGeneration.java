package net.birchyboii.birchy.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModVegetationGeneration.generateTrees();
        ModVegetationGeneration.generateBushes();

    }
}
