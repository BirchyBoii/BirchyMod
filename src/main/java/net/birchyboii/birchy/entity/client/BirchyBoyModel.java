package net.birchyboii.birchy.entity.client;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class BirchyBoyModel<T extends BirchyBoyEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BIRCHY_BOY = new EntityModelLayer(Identifier.of(BirchyMod.MOD_ID, "birchy_boy"), "main");

    private final ModelPart body;
    private final ModelPart head;

    public BirchyBoyModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -4.75F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-2.5F, -4.75F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, -8.5F, 0.5F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(21, 0).cuboid(-1.5F, -2.5F, -1.0F, 3.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(21, 8).cuboid(-1.5F, -2.5F, -1.0F, 3.0F, 5.0F, 2.0F, new Dilation(0.15F)), ModelTransform.pivot(0.0F, -6.0F, 0.5F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(21, 16).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(5, 22).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.15F)), ModelTransform.pivot(-2.0F, -8.0F, 0.5F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(0, 22).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(10, 22).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.15F)), ModelTransform.pivot(2.0F, -8.0F, 0.5F));

        ModelPartData left_leg = body.addChild("left_leg", ModelPartBuilder.create().uv(20, 23).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(25, 23).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.15F)), ModelTransform.pivot(-0.75F, -4.0F, 0.5F));

        ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create().uv(15, 22).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(26, 16).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.15F)), ModelTransform.pivot(0.75F, -4.0F, 0.5F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(BirchyBoyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(BirchyBoyAnimations.ANIM_BIRCHY_BOY_RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BirchyBoyAnimations.ANIM_BIRCHY_BOY_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        body.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return body;
    }
}
