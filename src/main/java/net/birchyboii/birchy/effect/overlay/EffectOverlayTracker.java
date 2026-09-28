package net.birchyboii.birchy.effect.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class EffectOverlayTracker {
    private final RegistryEntry<StatusEffect> effect;
    private final Identifier texture;
    private final float fadeOutDurationSeconds;

    private int trackedMaxDuration = 1;
    private float currentAlpha = 0.0f;

    public EffectOverlayTracker(RegistryEntry<StatusEffect> effect, Identifier texture, float fadeOutDurationSeconds) {
        this.effect = effect;
        this.texture = texture;
        this.fadeOutDurationSeconds = fadeOutDurationSeconds;
    }

    public EffectOverlayTracker(RegistryEntry<StatusEffect> effect, Identifier texture) {
        this(effect, texture, 0.5f);
    }

    public void render(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;
        StatusEffectInstance activeEffect = client.player.getStatusEffect(this.effect);
        if (activeEffect != null) {
            int duration = activeEffect.getDuration();
            if (duration > this.trackedMaxDuration) {
                this.trackedMaxDuration = duration;
            }

            float progress = 1.0f - ((float) duration) / ((float) this.trackedMaxDuration);
            this.currentAlpha = Math.clamp(progress, 0.0f, 1.0f);
        } else {
            this.trackedMaxDuration = 1;
            if (this.currentAlpha > 0.0f) {
                float frameDurationInTicks = tickCounter.getLastFrameDuration();
                float totalFadeTicks = this.fadeOutDurationSeconds * 20.0f;

                this.currentAlpha -= (frameDurationInTicks / totalFadeTicks);
                if (this.currentAlpha < 0.0f) this.currentAlpha = 0.0f;
            }
        }

        if (this.currentAlpha > 0.0f) {
            int width = drawContext.getScaledWindowWidth();
            int height = drawContext.getScaledWindowHeight();

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, this.currentAlpha);

            drawContext.drawTexture(
                    this.texture,
                    0, 0,
                    0, 0,
                    width, height,
                    width, height
            );

            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            RenderSystem.disableBlend();
        }
    }
}
