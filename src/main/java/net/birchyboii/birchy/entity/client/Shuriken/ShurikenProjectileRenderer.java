package net.birchyboii.birchy.entity.client.Shuriken;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.ShurikenProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ShurikenProjectileRenderer extends EntityRenderer<ShurikenProjectileEntity, EntityRenderState> {
    protected ShurikenProjectileModel model;

    public ShurikenProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new ShurikenProjectileModel(ctx.getPart(ShurikenProjectileModel.SHURIKEN));
    }

    @Override
    public void render(EntityRenderState state, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();



        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(BirchyMod.MOD_ID, "textures/entity/shuriken/shuriken.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(state, matrices, vertexConsumers, light);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

}
