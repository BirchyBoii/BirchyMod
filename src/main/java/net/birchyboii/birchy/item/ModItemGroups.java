package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.enchantment.ModEnchantments;
import net.birchyboii.birchy.potion.ModPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BIRCHY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BirchyMod.MOD_ID, "birchy_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BIRCHY_CHUNK))
                    .displayName(Text.translatable("itemgroup.birchy.birchy_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BIRCHY_SHEET);
                        entries.add(ModItems.BIRCHY_CHUNK);

                        entries.add(ModItems.BIRCHY_BALLS);
                        entries.add(ModItems.BIRCHISIZED_COAL);

                        entries.add(ModItems.DRY_WAND);
                        entries.add(ModItems.MOIST_WAND);
                        entries.add(ModItems.BIRCHY_SWORD);
                        entries.add(ModItems.BIRCHY_PICKAXE);
                        entries.add(ModItems.BIRCHY_AXE);
                        entries.add(ModItems.BIRCHY_SHOVEL);
                        entries.add(ModItems.BIRCHY_HOE);
                        entries.add(ModItems.BIRCHY_HAMMER);
                        entries.add(ModItems.BIRCHY_BOW);

                        entries.add(ModItems.BIRCHY_HELMET);
                        entries.add(ModItems.BIRCHY_CHESTPLATE);
                        entries.add(ModItems.BIRCHY_LEGGINGS);
                        entries.add(ModItems.BIRCHY_BOOTS);
                        entries.add(ModItems.BIRCHY_HORSE_ARMOR);

                        entries.add(ModItems.BIRCHY_SMITHING_TEMPLATE);
                        entries.add(ModItems.STAL_BIRCHY_COVER_MUSIC_DISC);

                        entries.add(PotionContentsComponent.createStack(Items.POTION, ModPotions.SLIMEY_POTION));
                        entries.add(PotionContentsComponent.createStack(Items.SPLASH_POTION, ModPotions.SLIMEY_POTION));
                        entries.add(PotionContentsComponent.createStack(Items.LINGERING_POTION, ModPotions.SLIMEY_POTION));

                        entries.add(ModItems.BIRCHY_GRAINS);
                        entries.add(ModItems.BIRCHY_FIBERS);
                        entries.add(ModItems.BIRCHY_BERRIES);
                        entries.add(ModItems.BIRCHY_BOY_SPAWN_EGG);
                        entries.add(ModItems.SWEET_RIDE_SPAWN_EGG);


                    }).build());

        public static final ItemGroup BIRCHY_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(BirchyMod.MOD_ID, "birchy_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BIRCHY_BLOCK))
                        .displayName(Text.translatable("itemgroup.birchy.birchy_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BIRCHY_BLOCK);
                            entries.add(ModBlocks.BIRCHY_ORE);
                            entries.add(ModBlocks.BIRCHY_DEEPSLATE_ORE);

                            entries.add(ModBlocks.BIRCHY_LOG);
                            entries.add(ModBlocks.BIRCHY_WOOD);
                            entries.add(ModBlocks.STRIPPED_BIRCHY_LOG);
                            entries.add(ModBlocks.STRIPPED_BIRCHY_WOOD);
                            entries.add(ModBlocks.BIRCHY_PLANKS);
                            entries.add(ModBlocks.BIRCHY_LEAVES);
                            entries.add(ModBlocks.BIRCHY_SAPLING);
                            entries.add(ModBlocks.BIRCHY_STAIRS);
                            entries.add(ModBlocks.BIRCHY_SLAB);
                            entries.add(ModBlocks.BIRCHY_BUTTON);
                            entries.add(ModBlocks.BIRCHY_PRESSURE_PLATE);
                            entries.add(ModBlocks.BIRCHY_FENCE);
                            entries.add(ModBlocks.BIRCHY_FENCE_GATE);
                            entries.add(ModBlocks.BIRCHY_DOOR);
                            entries.add(ModBlocks.BIRCHY_TRAPDOOR);

                            entries.add(ModBlocks.BIRCHY_LAMP);


                        }).build());


    public static void registerItemGroups() {
        BirchyMod.LOGGER.info("Registering Item Groups for " + BirchyMod.MOD_ID);
    }
}
