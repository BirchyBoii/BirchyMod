package net.birchyboii.birchy.entity;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BirchyBoyEntity> BIRCHY_BOY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BirchyMod.MOD_ID, "birchy_boy"),
            EntityType.Builder.create(BirchyBoyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.25f, 0.75f).build());

    public static void registerModEntities() {
        BirchyMod.LOGGER.info("Registering Mod Entities " + BirchyMod.MOD_ID);
    }
}
