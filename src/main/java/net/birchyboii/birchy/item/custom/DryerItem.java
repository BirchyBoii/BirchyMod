package net.birchyboii.birchy.item.custom;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class DryerItem extends Item {
    private static final Map<Block, Block> DRY_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, Blocks.DIRT,
                    Blocks.SHORT_GRASS, Blocks.AIR,
                    Blocks.TALL_GRASS, Blocks.DEAD_BUSH,
                    Blocks.WET_SPONGE, Blocks.SPONGE,

                    ModBlocks.BIRCHY_DEEPSLATE_ORE, ModBlocks.BIRCHY_ORE
            );

    public DryerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(DRY_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), DRY_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_WET_SPONGE_DRIES, SoundCategory.BLOCKS);
                ((ServerWorld) world).spawnParticles(ParticleTypes.CLOUD,
                        context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 1.2,
                        context.getBlockPos().getZ() + 0.5, 7, 0.3, 0.1, 0.3, 0);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.birchy.dryer_wand.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.birchy.dryer_wand"));
        }

        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("§8Last Block Changed at §8" + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
