package net.birchyboii.birchy.block.custom;

import com.mojang.serialization.MapCodec;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.particle.ModParticles;
import net.birchyboii.birchy.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BirchyBlock extends HorizontalFacingBlock {
    public BirchyBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_CORAL_BLOCK_FALL, SoundCategory.BLOCKS, 1, 1);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof PlayerEntity player) {
            if(entity.isAlive()) {
                float yaw = player.getYaw();
                double yawRad = Math.toRadians(yaw);
                double xDir = -Math.sin(yawRad);
                double zDir = Math.cos(yawRad);
                double intensity = 0.25;

                world.addParticle(ParticleTypes.WARPED_SPORE, pos.getX() + 0.5, pos.getY() + 1,
                        pos.getZ() + 0.5, 0, 1, 0);

                player.addVelocity((xDir * intensity), 0.5, (zDir * intensity));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.BIRCHY_BLOCK_TRANSFORMABLE_ITEMS);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
