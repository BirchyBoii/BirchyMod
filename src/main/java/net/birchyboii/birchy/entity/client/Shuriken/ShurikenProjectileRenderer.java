package net.birchyboii.birchy.entity.client.Shuriken;

import net.birchyboii.birchy.entity.custom.ShurikenProjectileEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;

public class ShurikenProjectileRenderer extends EntityRenderer<ShurikenProjectileEntity, EntityRenderState> {
    protected ShurikenProjectileModel model;

    public ShurikenProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new ShurikenProjectileModel(ctx.getPart(ShurikenProjectileModel.SHURIKEN));
    }

    @Override
    public void render(EntityRenderState renderState, MatrixStack matrices,
                       OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
       // matrices.push();

       // VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
       //         this.model.getLayer(Identifier.of(BirchyMod.MOD_ID, "textures/entity/shuriken/shuriken.png")), false, false);
       // this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

       // matrices.pop();
        super.render(renderState, matrices, queue, cameraState);
    }


    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

}
