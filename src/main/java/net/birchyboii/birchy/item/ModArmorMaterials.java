package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static EquipmentModel BIRCHY = EquipmentModel.builder().addHumanoidLayers(Identifier.of(BirchyMod.MOD_ID, "birchy")).build();

    public static final ArmorMaterial BIRCHY_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 6);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0, ModTags.Items.BIRCHY_REPAIR,
            Identifier.of(BirchyMod.MOD_ID, "birchy"));
}

