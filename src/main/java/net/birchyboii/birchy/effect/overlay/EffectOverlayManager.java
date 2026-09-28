package net.birchyboii.birchy.effect.overlay;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class EffectOverlayManager implements HudRenderCallback {
    private static final List<EffectOverlayTracker> OVERLAYS = new ArrayList<>();

    public static void register(RegistryEntry<StatusEffect> effect, Identifier texture) {
        OVERLAYS.add(new EffectOverlayTracker(effect, texture));}
    public static void register(RegistryEntry<StatusEffect> effect, Identifier texture, float fadeOutDurationSeconds) {
        OVERLAYS.add(new EffectOverlayTracker(effect, texture, fadeOutDurationSeconds));}

    public static void register(RegistryEntry<StatusEffect> effect, String modId, String textureName) {
        register(effect, Identifier.of(modId, "textures/gui/" + textureName + ".png"));}
    public static void register(RegistryEntry<StatusEffect> effect, String modId, String textureName, float fadeOutSpeed) {
        register(effect, Identifier.of(modId, "textures/gui/" + textureName + ".png"), fadeOutSpeed);}

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        for (EffectOverlayTracker overlay : OVERLAYS) {
            overlay.render(drawContext, tickCounter);
        }
    }
}
