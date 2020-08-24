package com.github.lapapesse02.attackontitanfabric;

// Fabric
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
// Minecraft
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
// Custom Items
import com.github.lapapesse02.attackontitanfabric.items.Hook;
import com.github.lapapesse02.attackontitanfabric.items.UltraHardSteel;
import com.github.lapapesse02.attackontitanfabric.items.Blade;
import com.github.lapapesse02.attackontitanfabric.items.Grip;
// Custom Armor
import com.github.lapapesse02.attackontitanfabric.armor.CustomArmor;
import com.github.lapapesse02.attackontitanfabric.tools.CustomToolMaterial;
// Custom Weapons
import com.github.lapapesse02.attackontitanfabric.tools.UltraHardSteelSword;


public class AttackOnTitanMod implements ModInitializer {

    public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.create(
        new Identifier("attackontitan", "attackontitan"))
        .icon(() -> new ItemStack(AttackOnTitanMod.SURVEY_CHESTPLATE))
        .appendItems(stacks -> {
            // Items
            stacks.add(new ItemStack(AttackOnTitanMod.HOOK));
            stacks.add(new ItemStack(AttackOnTitanMod.UH_STEEL));
            stacks.add(new ItemStack(AttackOnTitanMod.SWORD_GRIP));
            stacks.add(new ItemStack(AttackOnTitanMod.UH_STEEL_BLADE));
            // Armor
            stacks.add(new ItemStack(AttackOnTitanMod.SURVEY_CHESTPLATE));
            stacks.add(new ItemStack(AttackOnTitanMod.POLICE_CHESTPLATE));
            stacks.add(new ItemStack(AttackOnTitanMod.GARRISON_CHESTPLATE));
            stacks.add(new ItemStack(AttackOnTitanMod.LEGGINGS));
            stacks.add(new ItemStack(AttackOnTitanMod.BOOTS));
            stacks.add(new ItemStack(AttackOnTitanMod.UH_STEEL_SWORD));
        })
        .build();	

    // Items
    public static final Hook HOOK = new Hook(new Hook.Settings().group(MOD_GROUP));
    public static final UltraHardSteel UH_STEEL = new UltraHardSteel(new UltraHardSteel.Settings().group(MOD_GROUP));
    public static final Blade UH_STEEL_BLADE = new Blade(new Blade.Settings().group(MOD_GROUP).maxCount(1));
    public static final Grip SWORD_GRIP = new Grip(new Grip.Settings().group(MOD_GROUP).maxCount(1));
    // Armor
    public static final Item SURVEY_CHESTPLATE = new ArmorItem(CustomArmor.SURVEY_CORPS, EquipmentSlot.CHEST, (new Item.Settings().group(MOD_GROUP).maxCount(1)));
    public static final Item GARRISON_CHESTPLATE = new ArmorItem(CustomArmor.GARRISON, EquipmentSlot.CHEST, (new Item.Settings().group(MOD_GROUP).maxCount(1)));
    public static final Item POLICE_CHESTPLATE = new ArmorItem(CustomArmor.MILITARY_POLICE, EquipmentSlot.CHEST, (new Item.Settings().group(MOD_GROUP).maxCount(1)));
    public static final Item LEGGINGS = new ArmorItem(CustomArmor.REINFORCED_LEATHER, EquipmentSlot.LEGS, (new Item.Settings().group(MOD_GROUP).maxCount(1)));
    public static final Item BOOTS = new ArmorItem(CustomArmor.REINFORCED_LEATHER, EquipmentSlot.FEET, (new Item.Settings().group(MOD_GROUP).maxCount(1)));
    // Weapons
    public static final ToolItem UH_STEEL_SWORD = new UltraHardSteelSword(
        CustomToolMaterial.ULTRAHARD_STEEL, 6, 1.7F, 
        new Item.Settings().group(MOD_GROUP)
    );

    @Override
    public void onInitialize() {
        System.out.println("AttackOnTitan mod initialized!");

        // Items
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "hook"), HOOK);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "ultrahard_steel"), UH_STEEL);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "ultrahard_steel_blade"), UH_STEEL_BLADE);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "sword_grip"), SWORD_GRIP);
        // Armor
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "survey_corps_jacket"), SURVEY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "garrison_jacket"), GARRISON_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "military_police_jacket"), POLICE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "reinforced_leggings"), LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "reinforced_boots"), BOOTS);
        // Weapons
        Registry.register(Registry.ITEM, new Identifier("attackontitan", "ultrahard_steel_sword"), UH_STEEL_SWORD);

    }
}