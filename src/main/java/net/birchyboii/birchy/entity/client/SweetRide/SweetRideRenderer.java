package net.birchyboii.birchy.entity.client.SweetRide;

import com.google.common.collect.Maps;
import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.client.BirchyBoy.BirchyBoyRenderState;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.birchyboii.birchy.entity.custom.SweetRideEntity;
import net.birchyboii.birchy.entity.custom.SweetRideVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class SweetRideRenderer extends MobEntityRenderer<SweetRideEntity, SweetRideRenderState, SweetRideModel> {
    private static final Map<SweetRideVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SweetRideVariant.class), map -> {
               map.put(SweetRideVariant.DEFAULT,
                       Identifier.of(BirchyMod.MOD_ID, "textures/entity/sweet_ride/sweet_ride.png"));
                map.put(SweetRideVariant.GOLDEN,
                        Identifier.of(BirchyMod.MOD_ID, "textures/entity/sweet_ride/sweet_ride_golden.png"));
            });

    public SweetRideRenderer(EntityRendererFactory.Context context) {
        super(context, new SweetRideModel(context.getPart(SweetRideModel.SWEET_RIDE)), 0.75f);
    }

    @Override
    public Identifier getTexture(SweetRideRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
    }

    @Override
    public void render(SweetRideRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public SweetRideRenderState createRenderState() {
        return new SweetRideRenderState();
    }

    @Override
    public void updateRenderState(SweetRideEntity livingEntity, SweetRideRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.variant = livingEntity.getVariant();
    }

}
