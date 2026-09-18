package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.item.custom.DryerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item BIRCHY_CHUNK = registerItem("birchy_chunk", new Item(new Item.Settings()));
    public static final Item BIRCHY_SHEET = registerItem("birchy_sheet", new Item(new Item.Settings()));

    public static final Item DRY_WAND = registerItem("dryer_wand", new DryerItem(new Item.Settings().maxDamage(500).maxCount(1).rarity(Rarity.RARE)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BirchyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BirchyMod.LOGGER.info("Registering Mod Items for " + BirchyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BIRCHY_CHUNK);
            entries.add(BIRCHY_SHEET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(DRY_WAND);
        });
    }
}
