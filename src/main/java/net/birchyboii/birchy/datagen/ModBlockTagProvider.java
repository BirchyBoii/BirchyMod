package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BIRCHY_DEEPSLATE_ORE)
                .add(ModBlocks.BIRCHY_ORE)
                .add(ModBlocks.BIRCHY_NETHER_ORE)
                .add(ModBlocks.BIRCHY_END_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BIRCHY_DEEPSLATE_ORE)
                .add(ModBlocks.BIRCHY_ORE)
                .add(ModBlocks.BIRCHY_NETHER_ORE)
                .add(ModBlocks.BIRCHY_END_ORE);

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.BIRCHY_BLOCK);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BIRCHY_LOG)
                .add(ModBlocks.BIRCHY_WOOD)
                .add(ModBlocks.STRIPPED_BIRCHY_LOG)
                .add(ModBlocks.STRIPPED_BIRCHY_WOOD)
                .add(ModBlocks.BIRCHY_PLANKS);

        valueLookupBuilder(BlockTags.LOGS)
                .add(ModBlocks.BIRCHY_LOG)
                .add(ModBlocks.BIRCHY_WOOD)
                .add(ModBlocks.STRIPPED_BIRCHY_LOG)
                .add(ModBlocks.STRIPPED_BIRCHY_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.BIRCHY_PLANKS);

        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.BIRCHY_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.BIRCHY_FENCE_GATE);

        valueLookupBuilder(ModTags.Blocks.NEEDS_BIRCHY_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);


    }
}
