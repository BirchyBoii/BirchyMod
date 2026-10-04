package net.birchyboii.birchy;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.effect.overlay.EffectOverlayManager;
import net.birchyboii.birchy.effect.ModEffects;
import net.birchyboii.birchy.entity.ModEntities;
import net.birchyboii.birchy.entity.client.BirchyBoyModel;
import net.birchyboii.birchy.entity.client.BirchyBoyRenderer;
import net.birchyboii.birchy.entity.client.SweetRideModel;
import net.birchyboii.birchy.entity.client.SweetRideRenderer;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

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
    }
}
