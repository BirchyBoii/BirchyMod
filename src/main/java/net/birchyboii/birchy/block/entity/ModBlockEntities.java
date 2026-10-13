package net.birchyboii.birchy.block.entity;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.block.entity.custom.BirchisizerBlockEntity;
import net.birchyboii.birchy.block.entity.custom.PedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BirchyMod.MOD_ID, "pedestal_be"),
                    FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));
    public static final BlockEntityType<BirchisizerBlockEntity> BIRCHISIZER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BirchyMod.MOD_ID, "birchisizer_be"),
                    FabricBlockEntityTypeBuilder.create(BirchisizerBlockEntity::new, ModBlocks.BIRCHISIZER).build(null));

    public static void registerBlockEntities() {
        BirchyMod.LOGGER.info("Registering Block Entities for " + BirchyMod.MOD_ID);
    }
}
