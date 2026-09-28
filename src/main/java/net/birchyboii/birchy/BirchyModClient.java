package net.birchyboii.birchy;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.effect.overlay.EffectOverlayManager;
import net.birchyboii.birchy.effect.ModEffects;
import net.birchyboii.birchy.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
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
                ModBlocks.BIRCHY_TRAPDOOR);

        ModModelPredicates.registerModelPredicates();
    }
}
