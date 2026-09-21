package net.birchyboii.birchy.trim;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> BIRCHY = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(BirchyMod.MOD_ID, "birchy"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, BIRCHY, Registries.ITEM.getEntry(ModItems.BIRCHY_SHEET),
                Style.EMPTY.withColor(TextColor.parse("#c92a30").getOrThrow()), 0.4f);
    }


    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
