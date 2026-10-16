package net.birchyboii.birchy.datagen;

import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.block.custom.BirchyBerryBushBlock;
import net.birchyboii.birchy.block.custom.BirchyCropBlock;
import net.birchyboii.birchy.block.custom.BirchyLamp;
import net.birchyboii.birchy.item.ModArmorMaterials;
import net.birchyboii.birchy.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.SelectedProperty;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHY_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHY_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHY_END_ORE);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.BIRCHY_BLOCK, TextureMap.sideFrontTop(ModBlocks.BIRCHY_BLOCK));
        blockStateModelGenerator.createLogTexturePool(ModBlocks.BIRCHY_LOG).log(ModBlocks.BIRCHY_LOG).wood(ModBlocks.BIRCHY_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_BIRCHY_LOG).log(ModBlocks.STRIPPED_BIRCHY_LOG).wood(ModBlocks.STRIPPED_BIRCHY_WOOD);
        BlockStateModelGenerator.BlockTexturePool birchyPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BIRCHY_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.BIRCHY_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BIRCHY_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
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
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.BIRCHY_LAMP)
                .with(BlockStateModelGenerator.createBooleanModelMap(BirchyLamp.CLICKED,
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOnIdentifier)).build()),
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOffIdentifier)).build()))));

        blockStateModelGenerator.registerCrop(ModBlocks.BIRCHY_GRAINS_CROP, BirchyCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BIRCHY_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                BirchyBerryBushBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.CHAIR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BIRCHISIZER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BIRCHY_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIRCHY_SHEET, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BIRCHY_SAPLING.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_BALLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIRCHISIZED_COAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCHY_HAMMER, Models.HANDHELD);
        itemModelGenerator.upload(ModItems.BIRCHY_BOW, Models.BOW);
        itemModelGenerator.registerBow(ModItems.BIRCHY_BOW);

        itemModelGenerator.registerArmor(ModItems.BIRCHY_HELMET, ModArmorMaterials.BIRCHY_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.BIRCHY_CHESTPLATE, ModArmorMaterials.BIRCHY_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.BIRCHY_LEGGINGS, ModArmorMaterials.BIRCHY_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.BIRCHY_BOOTS, ModArmorMaterials.BIRCHY_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.register(ModItems.BIRCHY_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_FIBERS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.STAL_BIRCHY_COVER_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.BIRCHY_BOY_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.SWEET_RIDE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.MOTORCYCLE, Models.GENERATED);

        ItemModel.Unbaked unbakedDryWand = ItemModels.basic(itemModelGenerator.upload(ModItems.DRY_WAND, Models.GENERATED));
        ItemModel.Unbaked unbakedHeldDryWand = ItemModels.basic(itemModelGenerator.registerSubModel(ModItems.DRY_WAND, "_held", Models.GENERATED));
        itemModelGenerator.output.accept(ModItems.DRY_WAND,
                new ItemAsset(new ConditionItemModel.Unbaked(new SelectedProperty(),
                        unbakedHeldDryWand, unbakedDryWand),
                        new ItemAsset.Properties(false, false)).model());

        ItemModel.Unbaked unbakedMoistWand = ItemModels.basic(itemModelGenerator.upload(ModItems.MOIST_WAND, Models.GENERATED));
        ItemModel.Unbaked unbakedHeldMoistWand = ItemModels.basic(itemModelGenerator.registerSubModel(ModItems.MOIST_WAND, "_held", Models.GENERATED));
        itemModelGenerator.output.accept(ModItems.MOIST_WAND,
                new ItemAsset(new ConditionItemModel.Unbaked(new SelectedProperty(),
                        unbakedHeldMoistWand, unbakedMoistWand),
                        new ItemAsset.Properties(false, false)).model());
    }
}
