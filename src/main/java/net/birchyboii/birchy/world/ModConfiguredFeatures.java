package net.birchyboii.birchy.world;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCHY_ORE_KEY = registryKey("birchy_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BIRCHY_ORE_KEY = registryKey("nether_birchy_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_BIRCHY_ORE_KEY = registryKey("end_birchy_ore");


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

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BirchyMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
