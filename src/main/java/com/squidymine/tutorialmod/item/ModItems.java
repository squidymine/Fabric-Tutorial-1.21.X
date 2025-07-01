package com.squidymine.tutorialmod.item;

import com.squidymine.tutorialmod.TutorialMod;
import com.squidymine.tutorialmod.block.ModBlocks;
import com.squidymine.tutorialmod.entity.ModEntities;
import com.squidymine.tutorialmod.item.custom.ChiselItem;
import com.squidymine.tutorialmod.item.custom.HammerItem;
import com.squidymine.tutorialmod.item.custom.ModArmorItem;
import com.squidymine.tutorialmod.item.custom.TomahawkItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new);
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", Item::new);

    public static final Item CHISEL = registerItem("chisel", settings -> new ChiselItem(settings.maxDamage(32)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", settings -> new Item(settings.food(ModFoodComponents.CAULIFLOWER, ModFoodComponents.CAULIFLOWER_EFFECT)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", Item::new);

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            setting -> new SwordItem(ModToolMaterials.PINK_GARNET, 3, -2.4f, setting));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            setting -> new PickaxeItem(ModToolMaterials.PINK_GARNET, 1, -2.8f, setting));
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            setting -> new ShovelItem(ModToolMaterials.PINK_GARNET, 1.5f, -3.0f, setting));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            setting -> new AxeItem(ModToolMaterials.PINK_GARNET, 6, -3.2f, setting));
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            setting -> new HoeItem(ModToolMaterials.PINK_GARNET, 0, -3f, setting));

    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer",
            setting -> new HammerItem(ModToolMaterials.PINK_GARNET, 7, -3.4f, setting));
    // EquipmentType.HELMET.getMaxDamage(15)  is default helmet durability with a 15 times multi

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            settings -> new ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.HELMET, settings
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(15))));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15))));
    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(15))));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.BOOTS, settings
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(15))));

    // AliasedBlockItem allows us to use the item itself for the translation instead of the block
    public static final Item HONEY_BERRIES = registerItem("honey_berries",
            settings -> new BlockItem(ModBlocks.HONEY_BERRY_BUSH, settings.food(ModFoodComponents.HONEY_BERRIES)));

    public static final Item MANTIS_SPAWN_EGG = registerItem("mantis_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.MANTIS, 0x9dc783, 0xbfaf5f, settings));

    public static final Item TOMAHAWK = registerItem("tomahawk",
            settings -> new TomahawkItem(settings.maxCount(16)));

    public static final Item SPECTRE_STAFF = registerItem("spectre_staff",
            settings -> new Item(settings.maxCount(1)));



    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
