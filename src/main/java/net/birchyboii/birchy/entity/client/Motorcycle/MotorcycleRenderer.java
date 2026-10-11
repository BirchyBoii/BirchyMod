package net.birchyboii.birchy.entity.client.Motorcycle;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.MotorcycleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MotorcycleRenderer extends MobEntityRenderer<MotorcycleEntity, MotorcycleModel<MotorcycleEntity>> {
    public MotorcycleRenderer(EntityRendererFactory.Context context) {
        super(context, new MotorcycleModel<>(context.getPart(MotorcycleModel.MOTORCYCLE)), 0.25f);
    }

    @Override
    public Identifier getTexture(MotorcycleEntity entity) {
        return Identifier.of(BirchyMod.MOD_ID, "textures/entity/motorcycle/motorcycle.png");
    }



    @Override
    public void render(MotorcycleEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(1.25f, 1.25f, 1.25f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
