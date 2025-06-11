package com.squidymine.tutorialmod;

import com.squidymine.tutorialmod.block.ModBlocks;
import com.squidymine.tutorialmod.component.ModDataComponentTypes;
import com.squidymine.tutorialmod.item.ModItemGroups;
import com.squidymine.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		// Can create a custom class of all fuels that has a static register method that can be called here
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);
	}
}