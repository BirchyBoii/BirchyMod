package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        valueLookupBuilder(ModTags.Items.BIRCHY_BLOCK_TRANSFORMABLE_ITEMS)
                .add(ModItems.BIRCHY_CHUNK);
        valueLookupBuilder(ModTags.Items.BIRCHY_REPAIR)
                .add(ModItems.BIRCHY_SHEET);

        valueLookupBuilder(ModTags.Items.BIRCHY_LOGS)
                .add(ModBlocks.BIRCHY_LOG.asItem())
                .add(ModBlocks.BIRCHY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BIRCHY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BIRCHY_LOG.asItem());

        valueLookupBuilder(ItemTags.LOGS)
                .add(ModBlocks.BIRCHY_LOG.asItem())
                .add(ModBlocks.BIRCHY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BIRCHY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BIRCHY_LOG.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BIRCHY_PLANKS.asItem());

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.BIRCHY_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.BIRCHY_PICKAXE);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.BIRCHY_AXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.BIRCHY_SHOVEL);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.BIRCHY_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BIRCHY_HELMET)
                .add(ModItems.BIRCHY_CHESTPLATE)
                .add(ModItems.BIRCHY_LEGGINGS)
                .add(ModItems.BIRCHY_BOOTS);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.BIRCHY_SHEET);


    }
}
