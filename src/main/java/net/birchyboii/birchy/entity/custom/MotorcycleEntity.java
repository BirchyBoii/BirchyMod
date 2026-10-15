package net.birchyboii.birchy.entity.custom;

import net.birchyboii.birchy.entity.ai.goal.CustomRangeWanderAroundFarGoal;
import net.birchyboii.birchy.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MotorcycleEntity extends PassiveEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private final ServerBossBar bossBar = new ServerBossBar(Text.literal("Fuel"),
            BossBar.Color.WHITE, BossBar.Style.NOTCHED_10);

    public MotorcycleEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(3, new CustomRangeWanderAroundFarGoal(this, 1.5D, 25, 3));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 50)
                .add(EntityAttributes.MOVEMENT_SPEED, 1);

    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }


    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        if (!this.getWorld().isClient()) {
            ServerWorld serverWorld = (ServerWorld) this.getWorld();
            boolean isMoving = this.getVelocity().horizontalLengthSquared() > 1.0E-4
                    || this.getX() != this.lastX
                    || this.getZ() != this.lastZ;

            if (isMoving) {
                float yaw = this.bodyYaw != 0 ? this.bodyYaw : this.getYaw();

                double yawRad = Math.toRadians(yaw);
                double distanceBehind = -1.25;
                double spawnX = this.getX() - (Math.sin(yawRad) * distanceBehind);
                double spawnZ = this.getZ() + (Math.cos(yawRad) * distanceBehind);
                double spawnY = this.getY() + 0.3;

                serverWorld.spawnParticles(
                        ModParticles.BIKE_SMOKE_PARTICLE,
                        spawnX, spawnY, spawnZ,
                        3, 0.1, 0.2, 0.1, 1
                );
            }
        }

    }



    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        super.tickControlled(controllingPlayer, movementInput);

        float turnSpeed = 8.0F;
        if (controllingPlayer.sidewaysSpeed != 0) {
            float yawDelta = (controllingPlayer.sidewaysSpeed > 0 ? -1.0F : 1.0F) * turnSpeed;
            this.setYaw(this.getYaw() + yawDelta);
        }

        this.bodyYaw = this.getYaw();
        this.headYaw = controllingPlayer.getHeadYaw();

    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient) {
            player.startRiding(this);
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        Entity firstPassenger = this.getFirstPassenger();
        return firstPassenger instanceof PlayerEntity ? (PlayerEntity) firstPassenger : null;
    }

    @Override
    protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
        float forward = controllingPlayer.forwardSpeed;

        if (forward <= 0.0F) {
            forward *= 0.25F;
        }
        return new Vec3d(0.0, 0.0, forward);
    }

    @Override
    protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
        return ((float) this.getAttributeBaseValue(EntityAttributes.MOVEMENT_SPEED));
    }

    @Override
    protected void updatePassengerPosition(Entity passenger, PositionUpdater positionUpdater) {
        super.updatePassengerPosition(passenger, positionUpdater);

        if (passenger instanceof LivingEntity controllingPlayer) {
            float yawLimit = 60.0F;

            float wrappedRiderYaw = MathHelper.wrapDegrees(controllingPlayer.getYaw());
            float wrappedEntityYaw = MathHelper.wrapDegrees(this.getYaw());
            float yawDiff = MathHelper.wrapDegrees(wrappedRiderYaw - wrappedEntityYaw);

            float clampedDiff = MathHelper.clamp(yawDiff, -yawLimit, yawLimit);
            float targetYaw = wrappedEntityYaw + clampedDiff;

            if (Math.abs(yawDiff) > yawLimit) {
                controllingPlayer.setYaw(targetYaw);
            }

            this.setHeadYaw(controllingPlayer.getHeadYaw());
        }
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.isAlive() && this.hasPassengers() && this.getControllingPassenger() instanceof PlayerEntity controllingPassenger) {
            float headAngleOffset = MathHelper.wrapDegrees(controllingPassenger.getYaw() - this.getYaw());
            float influenceFactor = 0.5F;
            float scaledOffset = headAngleOffset * influenceFactor;
            float movementYaw = this.getYaw() + scaledOffset;
            float originalYaw = this.getYaw();

            this.setYaw(movementYaw);
            super.travel(movementInput);

            this.setYaw(originalYaw);
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);

        if (!this.getWorld().isClient && passenger instanceof ServerPlayerEntity serverPlayer) {
            this.bossBar.addPlayer(serverPlayer);
        }
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);

        if (!this.getWorld().isClient && passenger instanceof ServerPlayerEntity serverPlayer) {
            this.bossBar.removePlayer(serverPlayer);
        }
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        if (this.hasPassenger(player)) {
            this.bossBar.addPlayer(player);
        }
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick(ServerWorld world) {
        super.mobTick(world);
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }


}
