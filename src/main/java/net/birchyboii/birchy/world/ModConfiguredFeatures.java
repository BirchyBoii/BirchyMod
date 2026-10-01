package net.birchyboii.birchy.world;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCHY_ORE_KEY = registryKey("birchy_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BIRCHY_ORE_KEY = registryKey("nether_birchy_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_BIRCHY_ORE_KEY = registryKey("end_birchy_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCHY_TREE_KEY = registryKey("birchy_tree_key");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCHY_BERRY_BUSH_KEY = registryKey("birchy_berry_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldBirchyOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.BIRCHY_ORE.getDefaultState()),
                    (OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.BIRCHY_DEEPSLATE_ORE.getDefaultState())));
        List<OreFeatureConfig.Target> netherBirchyOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.BIRCHY_NETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endBirchyOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.BIRCHY_END_ORE.getDefaultState()));

        register(context, BIRCHY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBirchyOres, 5));
        register(context, NETHER_BIRCHY_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherBirchyOres, 9));
        register(context, END_BIRCHY_ORE_KEY, Feature.ORE, new OreFeatureConfig(endBirchyOres, 6));

        register(context, BIRCHY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BIRCHY_LOG),
                new CherryTrunkPlacer(
                        3, 2, 3,
                        ConstantIntProvider.create(3), UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(-3, -1), UniformIntProvider.create(1, 3)),

                BlockStateProvider.of(ModBlocks.BIRCHY_LEAVES),
                new RandomSpreadFoliagePlacer(UniformIntProvider.create(2, 4), ConstantIntProvider.create(0), UniformIntProvider.create(2, 3), 90),
                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).build());

        register(context, BIRCHY_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BIRCHY_BERRY_BUSH
                                .getDefaultState().with(SweetBerryBushBlock.AGE, 3))),
                        List.of(Blocks.END_STONE)));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BirchyMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
