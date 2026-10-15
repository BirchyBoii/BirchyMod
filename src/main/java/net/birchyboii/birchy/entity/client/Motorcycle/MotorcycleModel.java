package net.birchyboii.birchy.entity.client.Motorcycle;

import net.birchyboii.birchy.BirchyMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class MotorcycleModel extends EntityModel<MotorcycleRenderState> {
    public static final EntityModelLayer MOTORCYCLE = new EntityModelLayer(Identifier.of(BirchyMod.MOD_ID, "motorcycle"), "body");

    private final ModelPart wheeler;
    private final ModelPart head;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;

    public MotorcycleModel(ModelPart root) {
        super(root);
        this.wheeler = root.getChild("wheeler");
        this.head = this.wheeler.getChild("head");

        this.walkingAnimation = MotorcycleAnimations.ANIM_MOTORCYCLE_DRIVING.createAnimation(root);
        this.idlingAnimation = MotorcycleAnimations.ANIM_MOTORCYCLE_IDLE.createAnimation(root);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData wheeler = modelPartData.addChild("wheeler", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 4.0F, 0f, 0f, 0f));

        ModelPartData wheels = wheeler.addChild("wheels", ModelPartBuilder.create(), ModelTransform.of(-2.5F, -4.75F, 2.0F, 0f, 0f, 0f));

        ModelPartData back_leg_wheel = wheels.addChild("back_leg_wheel", ModelPartBuilder.create(), ModelTransform.of(2.5F, 0.0F, 1.0F, 0f, 0f, 0f));

        ModelPartData back_rim = back_leg_wheel.addChild("back_rim", ModelPartBuilder.create().uv(50, 47).cuboid(-1.5F, 3.65F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData cube_r1 = back_rim.addChild("cube_r1", ModelPartBuilder.create().uv(50, 47).cuboid(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.15F, -4.3F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r2 = back_rim.addChild("cube_r2", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.15F, 4.8F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r3 = back_rim.addChild("cube_r3", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, -3.4F, -2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r4 = back_rim.addChild("cube_r4", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, 3.4F, 2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r5 = back_rim.addChild("cube_r5", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, 3.4F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r6 = back_rim.addChild("cube_r6", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, -3.4F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r7 = back_rim.addChild("cube_r7", ModelPartBuilder.create().uv(50, 47).cuboid(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.45F, 0.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData back_spokes = back_leg_wheel.addChild("back_spokes", ModelPartBuilder.create().uv(54, 54).cuboid(-1.5F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F))
                .uv(54, 54).cuboid(-1.5F, -4.25F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData cube_r8 = back_spokes.addChild("cube_r8", ModelPartBuilder.create().uv(54, 54).cuboid(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, 4.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r9 = back_spokes.addChild("cube_r9", ModelPartBuilder.create().uv(54, 54).cuboid(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, -0.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r10 = back_spokes.addChild("cube_r10", ModelPartBuilder.create().uv(54, 54).cuboid(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.75F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r11 = back_spokes.addChild("cube_r11", ModelPartBuilder.create().uv(54, 54).cuboid(-1.5F, -2.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, -1.7322F, 1.6893F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r12 = back_spokes.addChild("cube_r12", ModelPartBuilder.create().uv(54, 54).cuboid(-1.5F, -2.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, 1.7678F, -1.8107F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r13 = back_spokes.addChild("cube_r13", ModelPartBuilder.create().uv(54, 54).cuboid(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, 2.75F, 3.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData back_hub = back_leg_wheel.addChild("back_hub", ModelPartBuilder.create().uv(53, 61).cuboid(-1.5F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.25F))
                .uv(53, 61).cuboid(-1.5F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData cube_r14 = back_hub.addChild("cube_r14", ModelPartBuilder.create().uv(53, 61).cuboid(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.26F)), ModelTransform.of(0.5F, 1.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r15 = back_hub.addChild("cube_r15", ModelPartBuilder.create().uv(53, 61).cuboid(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.26F)), ModelTransform.of(0.5F, 1.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData head = wheeler.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.75F, -8.0F, 0f, 0f, 0f));

        ModelPartData front_leg_wheel = head.addChild("front_leg_wheel", ModelPartBuilder.create(), ModelTransform.of(0.0F, 2.0F, -2.0F, 0f, 0f, 0f));

        ModelPartData front_rim = front_leg_wheel.addChild("front_rim", ModelPartBuilder.create().uv(50, 47).cuboid(-1.5F, 3.65F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData cube_r16 = front_rim.addChild("cube_r16", ModelPartBuilder.create().uv(50, 47).cuboid(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.15F, -4.3F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r17 = front_rim.addChild("cube_r17", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.15F, 4.8F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r18 = front_rim.addChild("cube_r18", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, -3.4F, -2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r19 = front_rim.addChild("cube_r19", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.55F, 3.4F, 2.3562F, 0.0F, 0.0F));

        ModelPartData cube_r20 = front_rim.addChild("cube_r20", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, 3.4F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r21 = front_rim.addChild("cube_r21", ModelPartBuilder.create().uv(50, 47).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.25F, -3.4F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r22 = front_rim.addChild("cube_r22", ModelPartBuilder.create().uv(50, 47).cuboid(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.45F, 0.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData front_spokes = front_leg_wheel.addChild("front_spokes", ModelPartBuilder.create().uv(54, 54).cuboid(-0.5F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F))
                .uv(54, 54).cuboid(-0.5F, -4.25F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData cube_r23 = front_spokes.addChild("cube_r23", ModelPartBuilder.create().uv(54, 54).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, 4.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r24 = front_spokes.addChild("cube_r24", ModelPartBuilder.create().uv(54, 54).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.5F, -0.25F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r25 = front_spokes.addChild("cube_r25", ModelPartBuilder.create().uv(54, 54).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, -0.75F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r26 = front_spokes.addChild("cube_r26", ModelPartBuilder.create().uv(54, 54).cuboid(-0.5F, -2.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, -1.7322F, 1.6893F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r27 = front_spokes.addChild("cube_r27", ModelPartBuilder.create().uv(54, 54).cuboid(-0.5F, -2.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.0F, 1.7678F, -1.8107F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r28 = front_spokes.addChild("cube_r28", ModelPartBuilder.create().uv(54, 54).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new Dilation(-0.35F)), ModelTransform.of(0.5F, 2.75F, 3.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData front_hub = front_leg_wheel.addChild("front_hub", ModelPartBuilder.create().uv(53, 61).cuboid(-0.5F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.25F))
                .uv(53, 61).cuboid(-0.5F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData cube_r29 = front_hub.addChild("cube_r29", ModelPartBuilder.create().uv(53, 61).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.26F)), ModelTransform.of(0.5F, 1.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r30 = front_hub.addChild("cube_r30", ModelPartBuilder.create().uv(53, 61).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(-0.26F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData bike_front = head.addChild("bike_front", ModelPartBuilder.create().uv(30, 59).cuboid(-3.0F, -1.0F, -3.25F, 6.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.25F, -0.75F, 0f, 0f, 0f));

        ModelPartData cube_r31 = bike_front.addChild("cube_r31", ModelPartBuilder.create().uv(50, 15).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 6.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, -5.75F, -1.6F, 0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r32 = bike_front.addChild("cube_r32", ModelPartBuilder.create().uv(48, 25).cuboid(-3.0F, -4.3481F, 0.933F, 6.0F, 5.0F, 2.0F, new Dilation(-0.15F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.0944F, 0.0F, 0.0F));

        ModelPartData cube_r33 = bike_front.addChild("cube_r33", ModelPartBuilder.create().uv(31, 49).cuboid(-3.0F, -1.9134F, -5.6194F, 6.0F, 1.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData body = wheeler.addChild("body", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData seat = body.addChild("seat", ModelPartBuilder.create().uv(0, 55).cuboid(-3.0F, -1.1911F, -0.7477F, 6.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.8089F, -3.2523F, 0f, 0f, 0f));

        ModelPartData cube_r34 = seat.addChild("cube_r34", ModelPartBuilder.create().uv(5, 41).cuboid(-3.0F, 1.0F, -1.0F, 6.0F, 0.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 0.5589F, 10.7523F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r35 = seat.addChild("cube_r35", ModelPartBuilder.create().uv(5, 50).cuboid(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -0.1911F, -2.4977F, 0.5236F, 0.0F, 0.0F));

        ModelPartData cube_r36 = seat.addChild("cube_r36", ModelPartBuilder.create().uv(31, 54).cuboid(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -0.6911F, -3.9977F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r37 = seat.addChild("cube_r37", ModelPartBuilder.create().uv(5, 45).cuboid(-3.0F, 0.0F, -1.0F, 6.0F, 1.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -0.6911F, 8.0023F, -0.3927F, 0.0F, 0.0F));

        ModelPartData engine = body.addChild("engine", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.2271F, -1.1656F, 0f, 0f, 0f));

        ModelPartData cube_r38 = engine.addChild("cube_r38", ModelPartBuilder.create().uv(12, 21).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 1.9771F, -2.5844F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r39 = engine.addChild("cube_r39", ModelPartBuilder.create().uv(11, 13).cuboid(-3.0F, -2.0F, -2.0F, 6.0F, 3.0F, 4.0F, new Dilation(-0.25F)), ModelTransform.of(0.0F, -0.0229F, -3.3344F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r40 = engine.addChild("cube_r40", ModelPartBuilder.create().uv(13, 0).cuboid(-2.0F, -3.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -2.0229F, -0.8344F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r41 = engine.addChild("cube_r41", ModelPartBuilder.create().uv(13, 7).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 3.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -0.0229F, -1.8344F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r42 = engine.addChild("cube_r42", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0229F, -2.8344F, 0.7854F, 0.0F, 0.0F));

        ModelPartData exhaust = body.addChild("exhaust", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.25F, -2.75F, 0f, 0f, 0f));

        ModelPartData cube_r43 = exhaust.addChild("cube_r43", ModelPartBuilder.create().uv(2, 23).cuboid(0.0F, -2.0F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(-0.1F))
                .uv(2, 23).cuboid(-6.0F, -2.0F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(2.0F, 2.5F, 10.7F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r44 = exhaust.addChild("cube_r44", ModelPartBuilder.create().uv(2, 16).cuboid(0.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(-0.25F))
                .uv(2, 16).cuboid(-6.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(-0.25F)), ModelTransform.of(2.0F, 2.5F, 7.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r45 = exhaust.addChild("cube_r45", ModelPartBuilder.create().uv(2, 6).cuboid(0.0F, -5.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(-0.15F))
                .uv(2, 6).cuboid(6.0F, -5.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(-0.15F)), ModelTransform.of(-4.0F, 2.0F, 4.0F, 1.309F, 0.0F, 0.0F));

        ModelPartData frame = body.addChild("frame", ModelPartBuilder.create(), ModelTransform.of(0.0F, -9.2859F, -9.2593F, 0f, 0f, 0f));

        ModelPartData cube_r46 = frame.addChild("cube_r46", ModelPartBuilder.create().uv(48, 7).cuboid(-3.0F, -3.0F, -1.0F, 6.0F, 5.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, -0.9641F, 0.0093F, 0.2182F, 0.0F, 0.0F));

        ModelPartData cube_r47 = frame.addChild("cube_r47", ModelPartBuilder.create().uv(48, 0).cuboid(-3.0F, -2.0F, -1.0F, 6.0F, 4.0F, 2.0F, new Dilation(-0.15F)), ModelTransform.of(0.0F, 1.7859F, 1.7593F, 0.6981F, 0.0F, 0.0F));

        ModelPartData handles = wheeler.addChild("handles", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0f, 0f, 0f));

        ModelPartData right_handle = handles.addChild("right_handle", ModelPartBuilder.create(), ModelTransform.of(3.0F, -12.1257F, -7.832F, 0f, 0f, 0f));

        ModelPartData cube_r48 = right_handle.addChild("cube_r48", ModelPartBuilder.create().uv(28, 43).cuboid(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(2.25F, -6.3743F, -1.168F, 0.0F, 0.0F, -0.6109F));

        ModelPartData cube_r49 = right_handle.addChild("cube_r49", ModelPartBuilder.create().uv(34, 26).cuboid(0.0F, -6.0F, 0.0F, 1.0F, 7.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-0.5F, 0.6257F, -0.668F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r50 = right_handle.addChild("cube_r50", ModelPartBuilder.create().uv(30, 26).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 2.6257F, 0.832F, 0.7854F, 0.0F, 0.0F));

        ModelPartData right_grip = handles.addChild("right_grip", ModelPartBuilder.create().uv(29, 40).cuboid(-1.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.5F, -17.25F, -9.5F, 0f, 0f, 0f));

        ModelPartData left_handle = handles.addChild("left_handle", ModelPartBuilder.create(), ModelTransform.of(-3.0F, -12.1257F, -7.832F, 0f, 0f, 0f));

        ModelPartData cube_r51 = left_handle.addChild("cube_r51", ModelPartBuilder.create().uv(40, 43).cuboid(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(-2.25F, -6.3743F, -1.168F, 0.0F, 0.0F, 0.6109F));

        ModelPartData cube_r52 = left_handle.addChild("cube_r52", ModelPartBuilder.create().uv(39, 26).cuboid(0.0F, -6.0F, 0.0F, 1.0F, 7.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-0.5F, 0.6257F, -0.668F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r53 = left_handle.addChild("cube_r53", ModelPartBuilder.create().uv(43, 26).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 2.6257F, 0.832F, 0.7854F, 0.0F, 0.0F));

        ModelPartData left_grip = handles.addChild("left_grip", ModelPartBuilder.create().uv(40, 40).cuboid(-2.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -17.25F, -9.5F, 0f, 0f, 0f));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(MotorcycleRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw);

        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
    }

    private void setHeadAngles(float headYaw) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);

        this.head.yaw = (float) (headYaw * (Math.PI / 180));
    }


}
