package net.birchyboii.birchy.util;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.DRY_WAND, Identifier.of(BirchyMod.MOD_ID, "held"),
                (stack, world, entity, seed) -> entity != null && entity.isHolding(ModItems.DRY_WAND) ? 1f : 0f);
        ModelPredicateProviderRegistry.register(ModItems.MOIST_WAND, Identifier.of(BirchyMod.MOD_ID, "held"),
                (stack, world, entity, seed) -> entity != null && entity.isHolding(ModItems.MOIST_WAND) ? 1f : 0f);
    }

    private static void registerCustomBow(Item item) {
        
    }
}
