package net.birchyboii.birchy.entity.client.Shuriken;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.ShurikenProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

public class ShurikenProjectileModel extends EntityModel<ShurikenProjectileEntity> {
    public static final EntityModelLayer SHURIKEN = new EntityModelLayer(Identifier.of(BirchyMod.MOD_ID, "shuriken"), "main");
    private final ModelPart shuriken;

    public ShurikenProjectileModel(ModelPart root) {
        this.shuriken = root.getChild("shuriken");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData shuriken = modelPartData.addChild("shuriken", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = shuriken.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r2 = shuriken.addChild("cube_r2", ModelPartBuilder.create().uv(4, 0).cuboid(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -0.99F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r3 = shuriken.addChild("cube_r3", ModelPartBuilder.create().uv(0, 4).cuboid(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.99F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r4 = shuriken.addChild("cube_r4", ModelPartBuilder.create().uv(0, 3).cuboid(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.99F, -1.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r5 = shuriken.addChild("cube_r5", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.99F, 1.0F, 0.0F, -0.7854F, 0.0F));
        return TexturedModelData.of(modelData, 8, 8);
    }
    @Override
    public void setAngles(ShurikenProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        shuriken.render(matrices, vertexConsumer, light, overlay, color);
    }
}
