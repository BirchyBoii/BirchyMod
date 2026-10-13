package net.birchyboii.birchy.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.ArrayList;
import java.util.List;

public class ModFoodComponents {
    public static final FoodComponent BIRCHY_BALLS = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2f).build();
    public static final FoodComponent BIRCHY_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).build();

    public static final ConsumableComponent BIRCHY_BALLS_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                    new StatusEffectInstance(StatusEffects.SATURATION, 200, 1, false, false, false),
                    new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0, false, false, false)),
                    1f))
            .build();


}
