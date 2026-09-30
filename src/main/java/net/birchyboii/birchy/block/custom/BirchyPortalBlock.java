package net.birchyboii.birchy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Portal;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TeleportTarget;
import org.jetbrains.annotations.Nullable;

public class BirchyPortalBlock extends Block implements Portal {
    public BirchyPortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable TeleportTarget createTeleportTarget(ServerWorld world, Entity entity, BlockPos pos) {
        return null;
    }
}
