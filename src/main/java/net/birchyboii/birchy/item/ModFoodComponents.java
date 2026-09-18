package net.birchyboii.birchy.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BIRCHY_BALLS = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200), 0.15f)
            .build();



}
