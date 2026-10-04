package net.birchyboii.birchy;

import net.birchyboii.birchy.component.ModDataComponentTypes;
import net.birchyboii.birchy.effect.ModEffects;
import net.birchyboii.birchy.enchantment.ModEnchantmentEffects;
import net.birchyboii.birchy.entity.ModEntities;
import net.birchyboii.birchy.entity.custom.BirchyBoyEntity;
import net.birchyboii.birchy.entity.custom.SweetRideEntity;
import net.birchyboii.birchy.item.ModItemGroups;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.potion.ModPotions;
import net.birchyboii.birchy.sounds.ModSounds;
import net.birchyboii.birchy.event.SunGazeHandler;
import net.birchyboii.birchy.util.HammerUsageEvent;
import net.birchyboii.birchy.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGen();

		FuelRegistry.INSTANCE.add(ModItems.BIRCHISIZED_COAL, 4800);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BIRCHY_GRAINS, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BIRCHY_BERRIES, 0.25f);

		StrippableBlockRegistry.register(ModBlocks.BIRCHY_LOG, ModBlocks.STRIPPED_BIRCHY_LOG);
		StrippableBlockRegistry.register(ModBlocks.BIRCHY_WOOD, ModBlocks.STRIPPED_BIRCHY_WOOD);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof SheepEntity sheepEntity && !world.isClient()) {
				if(player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal( player.getName().getString() + " just hit a sheep with an END ROD! YOU SICK FREAK!"));
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 500, 10));
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5000));
				}
			}

			return ActionResult.SUCCESS;
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});


		SunGazeHandler.register();

		FabricDefaultAttributeRegistry.register(ModEntities.BIRCHY_BOY, BirchyBoyEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SWEET_RIDE, SweetRideEntity.createAttributes());
	}
}
