package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.block.custom.BirchyLamp;
import net.birchyboii.birchy.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHY_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHY_ORE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.BIRCHY_BLOCK, TextureMap.sideFrontTop(ModBlocks.BIRCHY_BLOCK));
        blockStateModelGenerator.registerLog(ModBlocks.BIRCHY_LOG).log(ModBlocks.BIRCHY_LOG).wood(ModBlocks.BIRCHY_WOOD);
        BlockStateModelGenerator.BlockTexturePool birchyPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BIRCHY_PLANKS);
        birchyPlanksPool.stairs(ModBlocks.BIRCHY_STAIRS);
        birchyPlanksPool.slab(ModBlocks.BIRCHY_SLAB);
        birchyPlanksPool.button(ModBlocks.BIRCHY_BUTTON);
        birchyPlanksPool.pressurePlate(ModBlocks.BIRCHY_PRESSURE_PLATE);
        birchyPlanksPool.fence(ModBlocks.BIRCHY_FENCE);
        birchyPlanksPool.fenceGate(ModBlocks.BIRCHY_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.BIRCHY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BIRCHY_TRAPDOOR);
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.BIRCHY_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.BIRCHY_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BIRCHY_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(BirchyLamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BIRCHY_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIRCHY_SHEET, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_BALLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIRCHISIZED_COAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.DRY_WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOIST_WAND, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BIRCHY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BIRCHY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BIRCHY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BIRCHY_BOOTS));
        itemModelGenerator.register(ModItems.BIRCHY_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_SMITHING_TEMPLATE, Models.GENERATED);

    }
}
