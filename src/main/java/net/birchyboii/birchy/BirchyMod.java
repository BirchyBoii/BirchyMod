package net.birchyboii.birchy;

import net.birchyboii.birchy.block.entity.ModBlockEntities;
import net.birchyboii.birchy.component.ModDataComponentTypes;
import net.birchyboii.birchy.effect.ModEffects;
import net.birchyboii.birchy.enchantment.ModEnchantmentEffects;
import net.birchyboii.birchy.entity.ModEntities;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.birchyboii.birchy.entity.custom.SweetRideEntity;
import net.birchyboii.birchy.item.ModItemGroups;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.particle.ModParticles;
import net.birchyboii.birchy.potion.ModPotions;
import net.birchyboii.birchy.recipe.ModRecipes;
import net.birchyboii.birchy.screen.ModScreenHandlers;
import net.birchyboii.birchy.sounds.ModSounds;
import net.birchyboii.birchy.event.SunGazeHandler;
import net.birchyboii.birchy.util.HammerUsageEvent;
import net.birchyboii.birchy.util.ModLootTableModifiers;
import net.birchyboii.birchy.villager.ModVillagers;
import net.birchyboii.birchy.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BirchyMod implements ModInitializer {
	public static final String MOD_ID = "birchy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModEntities.registerModEntities();
		ModVillagers.registerVillagers();
		ModLootTableModifiers.modifyLootTables();

		ModParticles.registerParticles();

		ModWorldGeneration.generateModWorldGen();

		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.BIRCHISIZED_COAL, 4800);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.BIRCHY_GRAINS, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BIRCHY_BERRIES, 0.25f);

		StrippableBlockRegistry.register(ModBlocks.BIRCHY_LOG, ModBlocks.STRIPPED_BIRCHY_LOG);
		StrippableBlockRegistry.register(ModBlocks.BIRCHY_WOOD, ModBlocks.STRIPPED_BIRCHY_WOOD);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && player.getMainHandStack().getItem() == Items.END_ROD) {
				if (!world.isClient()) {
					player.sendMessage(Text.literal(player.getName().getString() + " just hit a sheep with an END ROD! YOU SICK FREAK!"), false);
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 500, 10));
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5000));
				}

				return ActionResult.SUCCESS;
			}

			return ActionResult.PASS;
		});



		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});


		SunGazeHandler.register();

		FabricDefaultAttributeRegistry.register(ModEntities.BIRCHY_BOY, BirchyBoyEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SWEET_RIDE, SweetRideEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MOTORCYCLE, SweetRideEntity.createAttributes());

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.BIRCHY_GRAINS, 3), 7, 2, 0.04f
			));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 4),
					new ItemStack(ModItems.BIRCHY_BERRIES, 2), 6, 2, 0.04f
			));
		});
		TradeOfferHelper.registerVillagerOffers(ModVillagers.BIRCHER_KEY, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.BIRCHY_CHUNK, 3),
					new ItemStack(ModItems.BIRCHY_SHEET, 2), 10, 2, 0.04f
			));
		});
		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			factories.addAll(Identifier.of(BirchyMod.MOD_ID, "birchy_sapling_for_emeralds"), (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModBlocks.BIRCHY_SAPLING, 1), 4, 2, 0.04f
			));
		});
	}
}
