package net.birchyboii.birchy.entity.client;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.SweetRideEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;


public class SweetRideModel<T extends SweetRideEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SWEET_RIDE = new EntityModelLayer(Identifier.of(BirchyMod.MOD_ID, "sweet_ride"), "main");

    private final ModelPart main;
    private final ModelPart head;

    public SweetRideModel(ModelPart root) {
        this.main = root.getChild("main");
        this.head = this.main.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData left_wheel = main.addChild("left_wheel", ModelPartBuilder.create(), ModelTransform.pivot(-4.5F, -4.75F, 0.0F));

        ModelPartData left_rim = left_wheel.addChild("left_rim", ModelPartBuilder.create().uv(53, 12).cuboid(-0.5F, 3.65F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = left_rim.addChild("cube_r1", ModelPartBuilder.create().uv(53, 12).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.15F, -4.3F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r2 = left_rim.addChild("cube_r2", ModelPartBuilder.create().uv(53, 12).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.15F, 4.8F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r3 = left_rim.addChild("cube_r3", ModelPartBuilder.create().uv(53, 12).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, -3.4F, -2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r4 = left_rim.addChild("cube_r4", ModelPartBuilder.create().uv(53, 12).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, 3.4F, 2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r5 = left_rim.addChild("cube_r5", ModelPartBuilder.create().uv(53, 12).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, 3.4F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r6 = left_rim.addChild("cube_r6", ModelPartBuilder.create().uv(53, 12).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, -3.4F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r7 = left_rim.addChild("cube_r7", ModelPartBuilder.create().uv(53, 12).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.45F, 0.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData left_spokes = left_wheel.addChild("left_spokes", ModelPartBuilder.create().uv(56, 18).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F))
                .uv(56, 18).cuboid(-0.5F, -4.25F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r8 = left_spokes.addChild("cube_r8", ModelPartBuilder.create().uv(56, 18).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, 4.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r9 = left_spokes.addChild("cube_r9", ModelPartBuilder.create().uv(56, 18).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, -0.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r10 = left_spokes.addChild("cube_r10", ModelPartBuilder.create().uv(56, 18).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.75F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r11 = left_spokes.addChild("cube_r11", ModelPartBuilder.create().uv(56, 18).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, -1.7322F, 1.6893F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r12 = left_spokes.addChild("cube_r12", ModelPartBuilder.create().uv(56, 18).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, 1.7678F, -1.8107F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r13 = left_spokes.addChild("cube_r13", ModelPartBuilder.create().uv(56, 18).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, 2.75F, 3.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData left_hub = left_wheel.addChild("left_hub", ModelPartBuilder.create().uv(55, 25).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.25F))
                .uv(55, 25).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r14 = left_hub.addChild("cube_r14", ModelPartBuilder.create().uv(56, 26).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(0.5F, 0.5F, 1.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r15 = left_hub.addChild("cube_r15", ModelPartBuilder.create().uv(56, 26).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(0.5F, 0.5F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData left_overlay = left_wheel.addChild("left_overlay", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r16 = left_overlay.addChild("cube_r16", ModelPartBuilder.create().uv(45, 9).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(0.5F, -3.55F, -3.4F, -2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r17 = left_overlay.addChild("cube_r17", ModelPartBuilder.create().uv(45, 9).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(0.0F, -4.45F, 0.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData cube_r18 = left_overlay.addChild("cube_r18", ModelPartBuilder.create().uv(45, 9).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(0.5F, -3.55F, 3.4F, 2.3562F, 0.0F, 0.0F));

        ModelPartData right_wheel = main.addChild("right_wheel", ModelPartBuilder.create(), ModelTransform.pivot(4.5F, -4.75F, 0.0F));

        ModelPartData right_rim = right_wheel.addChild("right_rim", ModelPartBuilder.create().uv(53, 30).cuboid(-0.5F, 3.65F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r19 = right_rim.addChild("cube_r19", ModelPartBuilder.create().uv(53, 30).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.15F, -4.3F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r20 = right_rim.addChild("cube_r20", ModelPartBuilder.create().uv(53, 30).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.15F, 4.8F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r21 = right_rim.addChild("cube_r21", ModelPartBuilder.create().uv(53, 30).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, -3.4F, -2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r22 = right_rim.addChild("cube_r22", ModelPartBuilder.create().uv(53, 30).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, 3.4F, 2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r23 = right_rim.addChild("cube_r23", ModelPartBuilder.create().uv(53, 30).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, 3.4F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r24 = right_rim.addChild("cube_r24", ModelPartBuilder.create().uv(53, 30).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, -3.4F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r25 = right_rim.addChild("cube_r25", ModelPartBuilder.create().uv(53, 30).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.45F, 0.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData right_spokes = right_wheel.addChild("right_spokes", ModelPartBuilder.create().uv(56, 36).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F))
                .uv(56, 36).cuboid(-0.5F, -4.25F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r26 = right_spokes.addChild("cube_r26", ModelPartBuilder.create().uv(56, 36).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, 4.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r27 = right_spokes.addChild("cube_r27", ModelPartBuilder.create().uv(56, 36).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, -0.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r28 = right_spokes.addChild("cube_r28", ModelPartBuilder.create().uv(56, 36).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.75F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r29 = right_spokes.addChild("cube_r29", ModelPartBuilder.create().uv(56, 36).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, -1.7322F, 1.6893F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r30 = right_spokes.addChild("cube_r30", ModelPartBuilder.create().uv(56, 36).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, 1.6178F, -1.6607F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r31 = right_spokes.addChild("cube_r31", ModelPartBuilder.create().uv(56, 36).cuboid(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, 2.75F, 3.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData right_hub = right_wheel.addChild("right_hub", ModelPartBuilder.create().uv(55, 43).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.25F))
                .uv(55, 43).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r32 = right_hub.addChild("cube_r32", ModelPartBuilder.create().uv(56, 44).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(0.5F, 0.5F, 1.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r33 = right_hub.addChild("cube_r33", ModelPartBuilder.create().uv(56, 44).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(0.5F, 0.5F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData right_overlay = right_wheel.addChild("right_overlay", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r34 = right_overlay.addChild("cube_r34", ModelPartBuilder.create().uv(45, 27).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(0.5F, -3.55F, -3.4F, -2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r35 = right_overlay.addChild("cube_r35", ModelPartBuilder.create().uv(45, 27).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(0.0F, -4.45F, 0.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData cube_r36 = right_overlay.addChild("cube_r36", ModelPartBuilder.create().uv(45, 27).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(0.5F, -3.55F, 3.4F, 2.3562F, 0.0F, 0.0F));

        ModelPartData base = main.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.4571F, -2.1843F));

        ModelPartData cube_r37 = base.addChild("cube_r37", ModelPartBuilder.create().uv(19, 29).cuboid(-5.0F, -10.0F, -4.0F, 8.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.4571F, 5.1843F, 0.9163F, 0.0F, 0.0F));

        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(21, 0).cuboid(-3.0F, -4.0F, -2.5F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 6).cuboid(-3.0F, -4.0F, -2.5F, 6.0F, 5.0F, 5.0F, new Dilation(0.15F)), ModelTransform.pivot(0.0F, -13.0F, -8.5F));

        ModelPartData body = main.addChild("body", ModelPartBuilder.create().uv(20, 14).cuboid(-4.5F, -2.5F, -1.5F, 9.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.5F, -6.5F));

        ModelPartData left_arm = main.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(-4.5F, -12.875F, -8.0F));

        ModelPartData left_upper_arm = left_arm.addChild("left_upper_arm", ModelPartBuilder.create().uv(9, 20).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.125F, 0.0F));

        ModelPartData left_forearm = left_arm.addChild("left_forearm", ModelPartBuilder.create().uv(9, 34).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 6.125F, 0.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData right_arm = main.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(4.5F, -13.0F, -8.0F));

        ModelPartData right_upper_arm = right_arm.addChild("right_upper_arm", ModelPartBuilder.create().uv(0, 20).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_forearm = right_arm.addChild("right_forearm", ModelPartBuilder.create().uv(0, 34).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 6.25F, 0.0F, -0.2618F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(SweetRideEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(SweetRideAnimations.ANIM_SWEET_RIDE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, SweetRideAnimations.ANIM_SWEET_RIDE_IDLE, ageInTicks, 1f);

    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = (float) (headYaw * (Math.PI / 180));
        this.head.pitch = (float) (headPitch * (Math.PI / 180));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        main.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return main;
    }

}