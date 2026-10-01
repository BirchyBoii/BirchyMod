package net.birchyboii.birchy.world.tree;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator BIRCHY_TREE = new SaplingGenerator(BirchyMod.MOD_ID + ":birchy_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BIRCHY_TREE_KEY), Optional.empty());
}
