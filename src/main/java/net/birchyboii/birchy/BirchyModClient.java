package net.birchyboii.birchy;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.effect.overlay.EffectOverlayManager;
import net.birchyboii.birchy.effect.ModEffects;
import net.birchyboii.birchy.entity.ModEntities;
import net.birchyboii.birchy.entity.client.BirchyBoy.BirchyBoyModel;
import net.birchyboii.birchy.entity.client.BirchyBoy.BirchyBoyRenderer;
import net.birchyboii.birchy.entity.client.Motorcycle.MotorcycleModel;
import net.birchyboii.birchy.entity.client.Motorcycle.MotorcycleRenderer;
import net.birchyboii.birchy.entity.client.Shuriken.ShurikenProjectileModel;
import net.birchyboii.birchy.entity.client.Shuriken.ShurikenProjectileRenderer;
import net.birchyboii.birchy.entity.client.SittableEntityRenderer;
import net.birchyboii.birchy.entity.client.SweetRide.SweetRideModel;
import net.birchyboii.birchy.entity.client.SweetRide.SweetRideRenderer;
import net.birchyboii.birchy.particle.BikeSmokeParticle;
import net.birchyboii.birchy.particle.ModParticles;
import net.birchyboii.birchy.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.render.RenderLayer;

public class BirchyModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new EffectOverlayManager());

        EffectOverlayManager.register(
                ModEffects.SUN_STARE,
                BirchyMod.MOD_ID, "eye_vein_outline",
                2.0f
        );


        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.BIRCHY_DOOR,
                ModBlocks.BIRCHY_TRAPDOOR,
                ModBlocks.BIRCHY_GRAINS_CROP,
                ModBlocks.BIRCHY_BERRY_BUSH,
                ModBlocks.BIRCHY_SAPLING);

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(BirchyBoyModel.BIRCHY_BOY, BirchyBoyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BIRCHY_BOY, BirchyBoyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SweetRideModel.SWEET_RIDE, SweetRideModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SWEET_RIDE, SweetRideRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShurikenProjectileModel.SHURIKEN, ShurikenProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SHURIKEN, ShurikenProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MotorcycleModel.MOTORCYCLE, MotorcycleModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MOTORCYCLE, MotorcycleRenderer::new);
        EntityRendererRegistry.register(ModEntities.SITTABLE_ENTITY, SittableEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.BIKE_SMOKE_PARTICLE, BikeSmokeParticle.Factory::new);
    }
}
