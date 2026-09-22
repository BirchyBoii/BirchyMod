package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.component.ModDataComponentTypes;
import net.birchyboii.birchy.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.Map;

public class ModItems {
    public static final Item BIRCHY_CHUNK = registerItem("birchy_chunk", new Item(new Item.Settings().fireproof()));
    public static final Item BIRCHY_SHEET = registerItem("birchy_sheet", new Item(new Item.Settings().fireproof()));

    public static final Item DRY_WAND = registerItem("dryer_wand", new CustomBlockTransformerItem(new Item.Settings()
            .maxDamage(500).maxCount(1).rarity(Rarity.RARE).fireproof(),
            Map.of(
                    Blocks.GRASS_BLOCK, Blocks.DIRT,
                    Blocks.SHORT_GRASS, Blocks.AIR,
                    Blocks.TALL_GRASS, Blocks.DEAD_BUSH,
                    Blocks.WET_SPONGE, Blocks.SPONGE,

                    ModBlocks.BIRCHY_DEEPSLATE_ORE, ModBlocks.BIRCHY_ORE
            ), SoundEvents.BLOCK_WET_SPONGE_DRIES, ParticleTypes.CLOUD) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.birchy.dryer_wand.shift_down"));
            } else {
                tooltip.add(Text.translatable("tooltip.birchy.dryer_wand"));
            }

            if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
                tooltip.add(Text.literal("§8Last Block Changed at §8" + stack.get(ModDataComponentTypes.COORDINATES)));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item MOIST_WAND = registerItem("moistening_wand", new CustomBlockTransformerItem(new Item.Settings()
            .maxDamage(500).maxCount(1).rarity(Rarity.RARE).fireproof(),
            Map.of(
                    Blocks.DIRT, Blocks.GRASS_BLOCK,
                    Blocks.DEAD_BUSH, Blocks.TALL_GRASS,
                    Blocks.SPONGE, Blocks.WET_SPONGE,

                    ModBlocks.BIRCHY_ORE, ModBlocks.BIRCHY_DEEPSLATE_ORE
            ), SoundEvents.BLOCK_SPONGE_ABSORB, ParticleTypes.FALLING_WATER) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.birchy.moistening_wand.shift_down"));
            } else {
                tooltip.add(Text.translatable("tooltip.birchy.moistening_wand"));
            }

            if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
                tooltip.add(Text.literal("§8Last Block Changed at §8" + stack.get(ModDataComponentTypes.COORDINATES)));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BIRCHY_BALLS = registerItem("birchy_balls", new Item(new Item.Settings().food(ModFoodComponents.BIRCHY_BALLS).fireproof()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.birchy.birchy_balls"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BIRCHISIZED_COAL = registerItem("birchisized_coal", new Item(new Item.Settings().fireproof()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.birchy.birchisized_coal"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BIRCHY_SWORD = registerItem("birchy_sword",
            new SwordItem(ModToolMaterials.BIRCHY, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BIRCHY, 3, -2.0f))));
    public static final Item BIRCHY_PICKAXE = registerItem("birchy_pickaxe",
            new PickaxeItem(ModToolMaterials.BIRCHY, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BIRCHY, 1, -2.8f))));
    public static final Item BIRCHY_AXE = registerItem("birchy_axe",
            new AxeItem(ModToolMaterials.BIRCHY, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BIRCHY, 6, -3.2f))));
    public static final Item BIRCHY_SHOVEL = registerItem("birchy_shovel",
            new ShovelItem(ModToolMaterials.BIRCHY, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BIRCHY, 1.5f, -3.0f))));
    public static final Item BIRCHY_HOE = registerItem("birchy_hoe",
            new HoeItem(ModToolMaterials.BIRCHY, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BIRCHY, 0, -3f))));

    public static final Item BIRCHY_BOW = registerItem("birchy_bow",
            new BowItem(new Item.Settings().maxDamage(500)));
    public static final Item BIRCHY_HAMMER = registerItem("birchy_hammer",
            new HammerItem(ModToolMaterials.BIRCHY, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BIRCHY, 9, -3.7f))));

    public static final Item BIRCHY_HELMET = registerItem("birchy_helmet",
            new ModArmorItem(ModArmorMaterials.BIRCHY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .fireproof()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))));
    public static final Item BIRCHY_CHESTPLATE = registerItem("birchy_chestplate",
            new ArmorItem(ModArmorMaterials.BIRCHY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .fireproof()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40))));
    public static final Item BIRCHY_LEGGINGS = registerItem("birchy_leggings",
            new ArmorItem(ModArmorMaterials.BIRCHY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .fireproof()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));
    public static final Item BIRCHY_BOOTS = registerItem("birchy_boots",
            new ArmorItem(ModArmorMaterials.BIRCHY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .fireproof()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40))));
    public static final Item BIRCHY_HORSE_ARMOR = registerItem("birchy_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.BIRCHY_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item BIRCHY_SMITHING_TEMPLATE = registerItem("birchy_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(BirchyMod.MOD_ID, "birchy"), FeatureFlags.VANILLA));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BirchyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BirchyMod.LOGGER.info("Registering Mod Items for " + BirchyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BIRCHY_CHUNK);
            entries.add(BIRCHY_SHEET);
            entries.add(BIRCHISIZED_COAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(DRY_WAND);
            entries.add(MOIST_WAND);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(BIRCHY_BALLS);
        });
    }
}
