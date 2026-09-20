package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.tag.ItemTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.BIRCHY_BLOCK_TRANSFORMABLE_ITEMS)
                .add(ModItems.BIRCHY_CHUNK);

        getOrCreateTagBuilder(ModTags.Items.BIRCHY_LOGS)
                .add(ModBlocks.BIRCHY_LOG.asItem())
                .add(ModBlocks.BIRCHY_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.BIRCHY_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BIRCHY_PLANKS.asItem());

    }
}
