package net.birchyboii.birchy.enchantment;

import com.mojang.serialization.MapCodec;
import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.enchantment.custom.ExplodingStrikeEnchantmentEffect;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEffectEntry;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> EXPLODING_STRIKE =
            registerEntityEffect("exploding_strike", ExplodingStrikeEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(BirchyMod.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        BirchyMod.LOGGER.info("Registering Mod Enchantment Effects for " + BirchyMod.MOD_ID);
    }
}
