package net.birchyboii.birchy.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BIRCHY_BALLS = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 1, false, false, false), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0, false, false, false), 1f)
            .build();
    public static final FoodComponent BIRCHY_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f)
            .snack()
            .build();


}
