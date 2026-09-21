package net.birchyboii.birchy;

import net.birchyboii.birchy.component.ModDataComponentTypes;
import net.birchyboii.birchy.item.ModItemGroups;
import net.birchyboii.birchy.item.ModItems;
import net.birchyboii.birchy.block.ModBlocks;
import net.birchyboii.birchy.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
		FuelRegistry.INSTANCE.add(ModItems.BIRCHISIZED_COAL, 4800);
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}
