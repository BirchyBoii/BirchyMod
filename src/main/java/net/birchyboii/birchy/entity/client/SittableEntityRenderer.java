package net.birchyboii.birchy.entity.client;

import net.birchyboii.birchy.entity.custom.SittableEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class SittableEntityRenderer extends EntityRenderer<SittableEntity> {
    public SittableEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(SittableEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(SittableEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}
