package net.birchyboii.birchy.entity.client.SweetRide;

import net.birchyboii.birchy.entity.custom.SweetRideVariant;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class SweetRideRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public SweetRideVariant variant;
}
