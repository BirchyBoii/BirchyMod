package net.birchyboii.birchy.world;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BIRCHY_ORE_PLACED_KEY = registerKey("birchy_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_BIRCHY_ORE_PLACED_KEY = registerKey("nether_birchy_ore_placed");
    public static final RegistryKey<PlacedFeature> END_BIRCHY_ORE_PLACED_KEY = registerKey("end_birchy_ore_placed");

    public static final RegistryKey<PlacedFeature> BIRCHY_TREE_PLACED_KEY = registerKey("birchy_tree_placed");

    public static final RegistryKey<PlacedFeature> BIRCHY_BERRY_BUSH_PLACED_KEY = registerKey("birchy_berry_bush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BIRCHY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIRCHY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))
                        ));
        register(context, NETHER_BIRCHY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BIRCHY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))
                ));
        register(context, END_BIRCHY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BIRCHY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))
                ));

        register(context, BIRCHY_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIRCHY_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.BIRCHY_SAPLING));

        register(context, BIRCHY_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIRCHY_BERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(BirchyMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}