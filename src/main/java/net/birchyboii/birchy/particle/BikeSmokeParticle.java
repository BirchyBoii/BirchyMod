package net.birchyboii.birchy.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class BikeSmokeParticle extends SpriteBillboardParticle {
    public BikeSmokeParticle(ClientWorld clientWorld, double x, double y, double z,
                             SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.velocityMultiplier = 0.1f;

        this.maxAge = 10;
        this.setSpriteForAge(spriteProvider);

        this.velocityY = velocityY + (Math.random() * (double)2.0F - (double)1.0F) * (double)0.08F;

        this.collidesWithWorld = true;

        float f = this.random.nextFloat() * 0.1F + 0.2F;
        this.red = f;
        this.green = f;
        this.blue = f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new BikeSmokeParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
