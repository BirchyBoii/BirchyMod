package net.birchyboii.birchy.item;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BIRCHY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BirchyMod.MOD_ID, "birchy_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BIRCHY_CHUNK))
                    .displayName(Text.translatable("itemgroup.birchy.birchy_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BIRCHY_SHEET);
                        entries.add(ModItems.BIRCHY_CHUNK);

                        entries.add(ModItems.DRY_WAND);
                        entries.add(ModItems.MOIST_WAND);

                        entries.add(ModItems.BIRCHY_BALLS);
                        entries.add(ModItems.BIRCHISIZED_COAL);

                    }).build());

        public static final ItemGroup BIRCHY_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(BirchyMod.MOD_ID, "birchy_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BIRCHY_BLOCK))
                        .displayName(Text.translatable("itemgroup.birchy.birchy_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BIRCHY_BLOCK);
                            entries.add(ModBlocks.BIRCHY_ORE);
                            entries.add(ModBlocks.BIRCHY_DEEPSLATE_ORE);

                        }).build());


    public static void registerItemGroups() {
        BirchyMod.LOGGER.info("Registering Item Groups for " + BirchyMod.MOD_ID);
    }
}
