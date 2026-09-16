package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BIRCHY_CHUNK = registerItem("birchy_chunk", new Item(new Item.Settings()));
    public static final Item BIRCHY_SHEET = registerItem("birchy_sheet", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BirchyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BirchyMod.LOGGER.info("Registering Mod Items for " + BirchyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BIRCHY_CHUNK);
            entries.add(BIRCHY_SHEET);
        });
    }
}
