package net.birchyboii.birchy.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public record KnockbackPantsEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<KnockbackPantsEnchantmentEffect> CODEC = MapCodec.unit(KnockbackPantsEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (level != 0) {
            if (!(target instanceof LivingEntity centerEntity)) return;

            double range = 2;
            Box area = centerEntity.getBoundingBox().expand(range);

            List<LivingEntity> nearbyEntities = world.getEntitiesByClass(
                    LivingEntity.class,
                    area,
                    e -> e != centerEntity && e.isAlive() && centerEntity.squaredDistanceTo(e) <=  range * range
            );

            for (LivingEntity nearby : nearbyEntities) {
                double dx = nearby.getX() - centerEntity.getX();
                double dz = nearby.getZ() - centerEntity.getZ();
                double length = Math.sqrt(dx * dx + dz * dz);
                if (length > 0.0001) {
                    nearby.setVelocity((dx / length), 0.5, (dz / length));
                }
            }

        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
