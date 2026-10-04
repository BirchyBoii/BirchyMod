package net.birchyboii.birchy.entity.client;

import com.google.common.collect.Maps;
import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.entity.custom.SweetRideEntity;
import net.birchyboii.birchy.entity.custom.SweetRideVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class SweetRideRenderer extends MobEntityRenderer<SweetRideEntity, SweetRideModel<SweetRideEntity>> {
    private static final Map<SweetRideVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SweetRideVariant.class), map -> {
               map.put(SweetRideVariant.DEFAULT,
                       Identifier.of(BirchyMod.MOD_ID, "textures/entity/sweet_ride/sweet_ride.png"));
                map.put(SweetRideVariant.GOLDEN,
                        Identifier.of(BirchyMod.MOD_ID, "textures/entity/sweet_ride/sweet_ride_golden.png"));
            });

    public SweetRideRenderer(EntityRendererFactory.Context context) {
        super(context, new SweetRideModel<>(context.getPart(SweetRideModel.SWEET_RIDE)), 0.75f);
    }

    @Override
    public Identifier getTexture(SweetRideEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }


}
