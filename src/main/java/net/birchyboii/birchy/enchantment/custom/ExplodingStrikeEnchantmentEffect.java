package net.birchyboii.birchy.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;



public record ExplodingStrikeEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<ExplodingStrikeEnchantmentEffect> CODEC = MapCodec.unit(ExplodingStrikeEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(level != 0) {
                double explosionPower;
                if (!(user instanceof LivingEntity attacker)) return;
                Vec3d velocity = new Vec3d(0.0, -5, 0);
                if(level >= 1 && level <= 3) {
                    explosionPower = level;
                } else {
                    explosionPower = 3 + (level - 3) * 0.5;
                }
                    FireballEntity fireballEntity = new FireballEntity(world, attacker, velocity, ((int) explosionPower));
                    fireballEntity.setPosition(pos.x, pos.y, pos.z);
                    world.spawnEntity(fireballEntity);

        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
