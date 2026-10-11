package net.birchyboii.birchy.particle;

import net.birchyboii.birchy.BirchyMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType BIKE_SMOKE_PARTICLE =
            registerParticle("bike_smoke_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(BirchyMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        BirchyMod.LOGGER.info("Registering Mod Particles for " + BirchyMod.MOD_ID);
    }
}
