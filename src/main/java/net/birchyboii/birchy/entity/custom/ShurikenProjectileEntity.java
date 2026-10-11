package net.birchyboii.birchy.entity.custom;

import net.birchyboii.birchy.entity.ModEntities;
import net.birchyboii.birchy.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ShurikenProjectileEntity extends PersistentProjectileEntity {
private float rotation;
public Vector2f groundedOffset;

    public ShurikenProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShurikenProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.SHURIKEN, player, world, new ItemStack(ModItems.SHURIKEN), null);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_SCALE, 2);

    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.SHURIKEN);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 4);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

        if(result.getSide() == Direction.SOUTH) {
            groundedOffset = new Vector2f(215f,180f);
        }
        if(result.getSide() == Direction.NORTH) {
            groundedOffset = new Vector2f(215f, 0f);
        }
        if(result.getSide() == Direction.EAST) {
            groundedOffset = new Vector2f(215f,-90f);
        }
        if(result.getSide() == Direction.WEST) {
            groundedOffset = new Vector2f(215f,90f);
        }

        if(result.getSide() == Direction.DOWN) {
            groundedOffset = new Vector2f(115f,180f);
        }
        if(result.getSide() == Direction.UP) {
            groundedOffset = new Vector2f(285f,180f);
        }
    }
}
