package net.birchyboii.birchy.entity;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.birchyboii.birchy.entity.custom.SweetRideEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BirchyBoyEntity> BIRCHY_BOY = register("birchy_boy",
            EntityType.Builder.create(BirchyBoyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.25f, 0.75f));
    public static final EntityType<SweetRideEntity> SWEET_RIDE = register("sweet_ride",
            EntityType.Builder.create(SweetRideEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.75f, 1f));


    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(BirchyMod.MOD_ID, name), builder.build());
    }

    public static void registerModEntities() {
        BirchyMod.LOGGER.info("Registering Mod Entities " + BirchyMod.MOD_ID);
    }
}
