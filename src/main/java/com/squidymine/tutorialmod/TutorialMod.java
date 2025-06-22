package com.squidymine.tutorialmod;

import com.squidymine.tutorialmod.block.ModBlocks;
import com.squidymine.tutorialmod.component.ModDataComponentTypes;
import com.squidymine.tutorialmod.effect.ModEffects;
import com.squidymine.tutorialmod.enchantment.ModEnchantmentEffects;
import com.squidymine.tutorialmod.item.ModItemGroups;
import com.squidymine.tutorialmod.item.ModItems;
import com.squidymine.tutorialmod.sound.ModSounds;
import com.squidymine.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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
		ModSounds.registerSounds();

		ModEffects.registerEffects();

		ModEnchantmentEffects.registerEnchantmentEffects();

		// Can create a custom class of all fuels that has a static register method that can be called here
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient()) { // The message sends twice w/o server check, but normally you don't have to do that
				if (player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("The Player just hit the sheep with an end rod!! HOW DARE YOU!!"));
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 6));
				}

				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES, 0.15f);
	}
}