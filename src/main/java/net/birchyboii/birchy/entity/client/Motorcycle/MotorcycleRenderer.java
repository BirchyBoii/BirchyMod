package net.birchyboii.birchy.entity.client.Motorcycle;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.client.BirchyBoy.BirchyBoyRenderState;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.birchyboii.birchy.entity.custom.MotorcycleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MotorcycleRenderer extends MobEntityRenderer<MotorcycleEntity, MotorcycleRenderState, MotorcycleModel> {
    public MotorcycleRenderer(EntityRendererFactory.Context context) {
        super(context, new MotorcycleModel(context.getPart(MotorcycleModel.MOTORCYCLE)), 0.25f);
    }

    @Override
    public Identifier getTexture(MotorcycleRenderState state) {
        return Identifier.of(BirchyMod.MOD_ID, "textures/entity/motorcycle/motorcycle.png");
    }

    @Override
    public void render(MotorcycleRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(1.25f, 1.25f, 1.25f);
        }

        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public MotorcycleRenderState createRenderState() {
        return new MotorcycleRenderState();
    }

    @Override
    public void updateRenderState(MotorcycleEntity livingEntity, MotorcycleRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);

    }
}
