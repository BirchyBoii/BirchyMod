package net.birchyboii.birchy.item.custom;

import net.birchyboii.birchy.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;


public class CustomBlockTransformerItem extends Item {
    private final Map<Block, Block> customBlockList;
    private final SoundEvent soundEvent;
    private final ParticleEffect particleType;

    public CustomBlockTransformerItem(Settings settings, Map<Block, Block> customBlockList, SoundEvent soundEvent, ParticleEffect particleType) {
        super(settings);
        this.customBlockList = customBlockList;
        this.soundEvent = soundEvent;
        this.particleType = particleType;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(customBlockList.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), customBlockList.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), soundEvent, SoundCategory.BLOCKS);
                ((ServerWorld) world).spawnParticles(particleType,
                        context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 1.2,
                        context.getBlockPos().getZ() + 0.5, 7, 0.3, 0.1, 0.3, 0);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }



    public Map<Block, Block> getCustomBlockList() {
        return customBlockList;
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    public ParticleEffect getParticleType() {
        return particleType;
    }
}
