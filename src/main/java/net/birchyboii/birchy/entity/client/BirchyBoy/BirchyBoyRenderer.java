package net.birchyboii.birchy.entity.client.BirchyBoy;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BirchyBoyRenderer extends MobEntityRenderer<BirchyBoyEntity, BirchyBoyRenderState, BirchyBoyModel> {
    public BirchyBoyRenderer(EntityRendererFactory.Context context) {
        super(context, new BirchyBoyModel(context.getPart(BirchyBoyModel.BIRCHY_BOY)), 0.25f);
    }

    @Override
    public Identifier getTexture(BirchyBoyRenderState state) {
        return Identifier.of(BirchyMod.MOD_ID, "textures/entity/birchy_boy/birchy_boy.png");
    }

    @Override
    public void render(BirchyBoyRenderState state, MatrixStack matrixStack,
                       OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if(state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(state, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public BirchyBoyRenderState createRenderState() {
        return new BirchyBoyRenderState();
    }

    @Override
    public void updateRenderState(BirchyBoyEntity livingEntity, BirchyBoyRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);

    }
}
