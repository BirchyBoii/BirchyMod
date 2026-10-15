package net.birchyboii.birchy.villager;

import com.google.common.collect.ImmutableSet;
import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;


public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> BIRCHY_POI_KEY = registerPoiKey("birchy_poi");
    public static final PointOfInterestType BIRCHY_POI = registerPOI("birchy_poi", ModBlocks.BIRCHY_BLOCK);

    public static final RegistryKey<VillagerProfession> BIRCHER_KEY =
            RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(BirchyMod.MOD_ID, "bircher"));
    public static final VillagerProfession BIRCHER = registerProfession("bircher", BIRCHY_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(BirchyMod.MOD_ID, name),
                new VillagerProfession(Text.literal("Bircher"),
                        entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(BirchyMod.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(BirchyMod.MOD_ID, name));
    }

    public static void registerVillagers() {
        BirchyMod.LOGGER.info("Registering Villagers for " + BirchyMod.MOD_ID);
    }
}
