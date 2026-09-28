package net.birchyboii.birchy.effect;

import net.birchyboii.birchy.BirchyMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SLIMEY_EFFECT = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(BirchyMod.MOD_ID, "slimey"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> LOW_GRAVITY = registerStatusEffect("low_gravity",
            new LowGravityEffect(StatusEffectCategory.NEUTRAL, 0xd3dfe8)
                    .addAttributeModifier(EntityAttributes.GENERIC_GRAVITY,
                            Identifier.of(BirchyMod.MOD_ID, "low_gravity"), -0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_FALL_DAMAGE_MULTIPLIER,
                            Identifier.of(BirchyMod.MOD_ID, "low_gravity"), -0.6f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE,
                            Identifier.of(BirchyMod.MOD_ID, "low_gravity"), 2f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> SUN_STARE = registerStatusEffect("sun_stare",
            new SunStareEffect(StatusEffectCategory.HARMFUL, 0xad2e03));



    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BirchyMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        BirchyMod.LOGGER.info("Registering Mod Effects for " + BirchyMod.MOD_ID);
    }
}
