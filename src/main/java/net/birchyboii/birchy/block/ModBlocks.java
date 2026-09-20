package net.birchyboii.birchy.block;

import com.mojang.serialization.MapCodec;
import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.custom.BirchyBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.impl.util.log.Log;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block BIRCHY_BLOCK = registerBlock("birchy_block",
            new BirchyBlock(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.CORAL)));
    public static final Block BIRCHY_ORE = registerBlock("birchy_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BIRCHY_DEEPSLATE_ORE = registerBlock("deepslate_birchy_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f)
                            .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    public static final Block BIRCHY_LOG = registerBlock("birchy_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_WOOD = registerBlock("birchy_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_PLANKS = registerBlock("birchy_planks",
            new Block(AbstractBlock.Settings.create().strength(1f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_STAIRS = registerBlock("birchy_stairs",
            new StairsBlock(ModBlocks.BIRCHY_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_SLAB = registerBlock("birchy_slabs",
            new SlabBlock(AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_BUTTON = registerBlock("birchy_button",
            new ButtonBlock(BlockSetType.BIRCH, 2,
                    AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().noCollision().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_PRESSURE_PLATE = registerBlock("birchy_pressure_plate",
            new PressurePlateBlock(BlockSetType.BIRCH,
                    AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_FENCE = registerBlock("birchy_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_FENCE_GATE = registerBlock("birchy_fence_gate",
            new FenceGateBlock(WoodType.BIRCH,
                    AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block BIRCHY_DOOR = registerBlock("birchy_door",
            new DoorBlock(BlockSetType.BIRCH,
                    AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)));
    public static final Block BIRCHY_TRAPDOOR = registerBlock("birchy_trapdoor",
            new TrapdoorBlock(BlockSetType.BIRCH,
                    AbstractBlock.Settings.create().strength(1f)
                            .requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BirchyMod.MOD_ID, name), block);
    }



    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BirchyMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
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
