package net.birchyboii.birchy.event;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.effect.ModEffects;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SunGazeHandler {
    private static final Map<UUID, Integer> LOOK_AWAY_TIMERS = new HashMap<>();
    private static final Map<UUID, Integer> LOOK_AT_TIMERS = new HashMap<>();

    public static void register() {
        BirchyMod.LOGGER.info("Registering Tick Events for " + BirchyMod.MOD_ID);
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                handlePlayerSunCheck(player);
            }
        });
    }

    private static void handlePlayerSunCheck(ServerPlayerEntity player) {
        if (player.hasStatusEffect(StatusEffects.BLINDNESS) ||
            player.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
            if (player.hasStatusEffect(ModEffects.SUN_STARE)) {
                player.removeStatusEffect(ModEffects.SUN_STARE);
            }
             LOOK_AWAY_TIMERS.remove(player.getUuid());
             LOOK_AT_TIMERS.remove(player.getUuid());
             return;
        }

        boolean isLookingAtSun = isLookingAtSun(player);

        if (isLookingAtSun) {
            LOOK_AWAY_TIMERS.remove(player.getUuid());
            int lookTicks = LOOK_AT_TIMERS.getOrDefault(player.getUuid(), 0) + 1;
            LOOK_AT_TIMERS.put(player.getUuid(), lookTicks);
            if (lookTicks >= 40) {
                if (!player.hasStatusEffect(ModEffects.SUN_STARE)) {
                    player.addStatusEffect(new StatusEffectInstance(
                            ModEffects.SUN_STARE,
                            500,
                            0,
                            false,
                            false,
                            true
                        ));
                    }
                }
            } else {
            LOOK_AT_TIMERS.remove(player.getUuid());
            if (player.hasStatusEffect(ModEffects.SUN_STARE)) {
                int ticksAway = LOOK_AWAY_TIMERS.getOrDefault(player.getUuid(), 0) + 1;

                if (ticksAway >= 20) {
                    player.removeStatusEffect(ModEffects.SUN_STARE);
                    LOOK_AWAY_TIMERS.remove(player.getUuid());
                } else {
                    LOOK_AWAY_TIMERS.put(player.getUuid(), ticksAway);
                }
            } else {
                LOOK_AWAY_TIMERS.remove(player.getUuid());
                }
            }
        }

    private static boolean isLookingAtSun(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();

        if (!world.isDay() || world.isRaining() || !world.isSkyVisible(player.getBlockPos())) {
            return false;
        }

        float celestialAngle = world.getSkyAngle(1.0f);
        double radians = celestialAngle * 2.0 * Math.PI;
        Vec3d sunVector = new Vec3d(-Math.sin(radians), Math.cos(radians), 0.0).normalize();

        Vec3d lookVector = player.getRotationVector();
        double dot = lookVector.dotProduct(sunVector);

        return dot > 0.98;
    }

}
