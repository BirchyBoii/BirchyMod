package net.birchyboii.birchy.util;

import net.birchyboii.birchy.BirchyMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BirchyMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BIRCHY_BLOCK_TRANSFORMABLE_ITEMS = createTag("birchy_block_transformable_items");
        public static final TagKey<Item> BIRCHY_LOGS = createTag("birchy_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BirchyMod.MOD_ID, name));
        }
    }
}
