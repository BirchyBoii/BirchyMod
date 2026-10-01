package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.block.custom.BirchyBerryBushBlock;
import net.birchyboii.birchy.block.custom.BirchyCropBlock;
import net.birchyboii.birchy.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() { 		RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.BIRCHY_BLOCK);

        addDrop(ModBlocks.BIRCHY_LOG);
        addDrop(ModBlocks.BIRCHY_WOOD);
        addDrop(ModBlocks.STRIPPED_BIRCHY_WOOD);
        addDrop(ModBlocks.STRIPPED_BIRCHY_LOG);
        addDrop(ModBlocks.BIRCHY_PLANKS);
        addDrop(ModBlocks.BIRCHY_SAPLING);
        addDrop(ModBlocks.BIRCHY_LEAVES, leavesDrops(ModBlocks.BIRCHY_LEAVES, ModBlocks.BIRCHY_SAPLING, 0.0625f));
        addDrop(ModBlocks.BIRCHY_STAIRS);
        addDrop(ModBlocks.BIRCHY_SLAB, slabDrops(ModBlocks.BIRCHY_SLAB));
        addDrop(ModBlocks.BIRCHY_BUTTON);
        addDrop(ModBlocks.BIRCHY_PRESSURE_PLATE);
        addDrop(ModBlocks.BIRCHY_FENCE);
        addDrop(ModBlocks.BIRCHY_FENCE_GATE);
        addDrop(ModBlocks.BIRCHY_DOOR, doorDrops(ModBlocks.BIRCHY_DOOR));
        addDrop(ModBlocks.BIRCHY_TRAPDOOR);

        addDrop(ModBlocks.BIRCHY_ORE, multipleOreDrops(ModBlocks.BIRCHY_ORE, ModItems.BIRCHY_CHUNK, 1, 3));
        addDrop(ModBlocks.BIRCHY_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.BIRCHY_DEEPSLATE_ORE, ModItems.BIRCHY_CHUNK, 1, 5));
        addDrop(ModBlocks.BIRCHY_NETHER_ORE, multipleOreDrops(ModBlocks.BIRCHY_NETHER_ORE, ModItems.BIRCHY_CHUNK, 1, 1));
        addDrop(ModBlocks.BIRCHY_END_ORE, multipleOreDrops(ModBlocks.BIRCHY_END_ORE, ModItems.BIRCHY_CHUNK, 2, 6));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.BIRCHY_GRAINS_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BirchyCropBlock.AGE, BirchyCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.BIRCHY_GRAINS_CROP, this.cropDrops(ModBlocks.BIRCHY_GRAINS_CROP, ModItems.BIRCHY_GRAINS, ModItems.BIRCHY_GRAINS, builder2));
        this.addDrop(ModBlocks.BIRCHY_BERRY_BUSH,
                block -> this.applyExplosionDecay(block, LootTable.builder()
                                .pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.BIRCHY_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BirchyBerryBushBlock.AGE, 3)))
                                        .with(ItemEntry.builder(ModItems.BIRCHY_BERRIES))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                                .pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.BIRCHY_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BirchyBerryBushBlock.AGE, 2)))
                                        .with(ItemEntry.builder(ModItems.BIRCHY_BERRIES))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                ));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));

    }
}
