package net.birchyboii.birchy.block;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.custom.*;
import net.birchyboii.birchy.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {
    public static final Block BIRCHY_BLOCK = registerBlock("birchy_block",
            properties -> new BirchyBlock(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.CORAL)));
    public static final Block BIRCHY_ORE = registerBlock("birchy_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BIRCHY_DEEPSLATE_ORE = registerBlock("deepslate_birchy_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block BIRCHY_NETHER_ORE = registerBlock("nether_birchy_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(4, 7),
                    properties.strength(2f)
                            .requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE)));
    public static final Block BIRCHY_END_ORE = registerBlock("end_birchy_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(4, 9),
                    properties.strength(3f)
                            .requiresTool().sounds(BlockSoundGroup.STONE)));


    public static final Block BIRCHY_LOG = registerBlock("birchy_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_WOOD = registerBlock("birchy_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_BIRCHY_LOG = registerBlock("stripped_birchy_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_BIRCHY_WOOD = registerBlock("stripped_birchy_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_PLANKS = registerBlock("birchy_planks",
            properties -> new Block(properties.strength(3f)));
    public static final Block BIRCHY_LEAVES = registerBlock("birchy_leaves",
            properties -> new LeavesBlock(properties
                    .mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block BIRCHY_SAPLING = registerBlock("birchy_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerators.BIRCHY_TREE,
                    properties.mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly()
                    .breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY), Blocks.END_STONE));

    public static final Block BIRCHY_STAIRS = registerBlock("birchy_stairs",
            properties -> new StairsBlock(ModBlocks.BIRCHY_PLANKS.getDefaultState(),
                    properties.strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_SLAB = registerBlock("birchy_slabs",
            properties -> new SlabBlock(properties.strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_BUTTON = registerBlock("birchy_button",
            properties -> new ButtonBlock(BlockSetType.BIRCH, 2,
                    properties.strength(1f)
                            .requiresTool().noCollision().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_PRESSURE_PLATE = registerBlock("birchy_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.BIRCH,
                    properties.strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_FENCE = registerBlock("birchy_fence",
            properties -> new FenceBlock(properties.strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_FENCE_GATE = registerBlock("birchy_fence_gate",
            properties -> new FenceGateBlock(WoodType.BIRCH,
                    properties.strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_DOOR = registerBlock("birchy_door",
            properties -> new DoorBlock(BlockSetType.BIRCH,
                    properties.strength(1f)
                            .requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_TRAPDOOR = registerBlock("birchy_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.BIRCH,
                    properties.strength(1f)
                            .requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_LAMP = registerBlock("birchy_lamp",
            properties -> new BirchyLamp(properties
                    .strength(1f).requiresTool().luminance(state -> state.get(BirchyLamp.CLICKED) ? 15 : 0).sounds(BlockSoundGroup.GLASS)));

    public static final Block BIRCHY_GRAINS_CROP = registerBlockWithoutBlockItem("birchy_grains_crop",
            properties -> new BirchyCropBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block BIRCHY_BERRY_BUSH = registerBlockWithoutBlockItem("birchy_berry_bush",
            properties -> new BirchyBerryBushBlock(properties.mapColor(MapColor.DARK_GREEN).ticksRandomly()
                    .noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY),
                    Blocks.END_STONE));

    public static final Block CHAIR = registerBlock("chair",
            properties -> new ChairBlock(properties.nonOpaque()));
    public static final Block PEDESTAL = registerBlock("pedestal",
            properties -> new PedestalBlock(properties.nonOpaque()));
    public static final Block BIRCHISIZER = registerBlock("birchisizer", BirchisizerBlock::new);




    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BirchyMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(BirchyMod.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(BirchyMod.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BirchyMod.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BirchyMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BirchyMod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        BirchyMod.LOGGER.info("Registering Mod Blocks for " + BirchyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BIRCHY_BLOCK);
            entries.add(ModBlocks.BIRCHY_ORE);
            entries.add(ModBlocks.BIRCHY_DEEPSLATE_ORE);
            entries.add(ModBlocks.BIRCHY_LOG);
        });
    }
}
