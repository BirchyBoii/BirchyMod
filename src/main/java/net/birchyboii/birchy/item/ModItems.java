package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.item.custom.DryerItem;
import net.birchyboii.birchy.item.custom.MoisteningItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {
    public static final Item BIRCHY_CHUNK = registerItem("birchy_chunk", new Item(new Item.Settings()));
    public static final Item BIRCHY_SHEET = registerItem("birchy_sheet", new Item(new Item.Settings()));

    public static final Item DRY_WAND = registerItem("dryer_wand", new DryerItem(new Item.Settings().maxDamage(500).maxCount(1).rarity(Rarity.RARE)));
    public static final Item MOIST_WAND = registerItem("moistening_wand", new MoisteningItem(new Item.Settings().maxDamage(500).maxCount(1).rarity(Rarity.RARE)));

    public static final Item BIRCHY_BALLS = registerItem("birchy_balls", new Item(new Item.Settings().food(ModFoodComponents.BIRCHY_BALLS)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.birchy.birchy_balls"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BIRCHISIZED_COAL = registerItem("birchisized_coal", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.birchy.birchisized_coal"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });


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
