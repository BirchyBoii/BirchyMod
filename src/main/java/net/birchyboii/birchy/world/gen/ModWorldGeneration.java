package net.birchyboii.birchy.world.gen;

import net.birchyboii.birchy.entity.ModEntities;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModVegetationGeneration.generateTrees();
        ModVegetationGeneration.generateBushes();

        ModEntitySpawns.addSpawns();

    }
}
