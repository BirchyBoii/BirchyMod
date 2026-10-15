package net.birchyboii.birchy.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.util.Map;
import java.util.WeakHashMap;


public class FreeFlyEffect extends StatusEffect {
    private static final Map<AttributeContainer, LivingEntity> ENTITY_MAP = new WeakHashMap<>();
    protected FreeFlyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player) {
            if (!player.getAbilities().allowFlying) {

                player.getAbilities().allowFlying = true;
                player.sendAbilitiesUpdate();

            } else if (player.getAbilities().allowFlying && player.getAbilities().flying
                    && player.getPlayerInput().forward()) {

                Vec3d playerVelocityBase = Vec3d.fromPolar(player.getPitch(), player.getYaw());
                double multiplier = Math.clamp(amplifier * 0.1, 0.05, 0.5);
                Vec3d playerVelocity = new Vec3d(playerVelocityBase.x * multiplier, playerVelocityBase.y * multiplier * 6.5, playerVelocityBase.z * multiplier);

                player.addVelocity(playerVelocity);

                player.velocityModified = true;
                return true;
            }
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        ENTITY_MAP.put(entity.getAttributes(), entity);
        super.onApplied(entity, amplifier);
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        LivingEntity entity = ENTITY_MAP.remove(attributeContainer);

        if (entity instanceof ServerPlayerEntity player) {
            if (!player.isCreative() && !player.isSpectator()) {
                player.getAbilities().allowFlying = false;
                player.getAbilities().flying = false;
                player.sendAbilitiesUpdate();
            }
        }
        super.onRemoved(attributeContainer);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
