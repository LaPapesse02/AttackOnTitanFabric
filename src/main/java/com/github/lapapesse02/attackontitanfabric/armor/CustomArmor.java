package com.github.lapapesse02.attackontitanfabric.armor;

// Java
import java.util.function.Supplier;
// Fabric
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
// Minecraft
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum CustomArmor implements ArmorMaterial{

    GARRISON("garrison", 15, new int[] {2, 5, 3, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.LEATHER);
    }),
    MILITARY_POLICE("military_police", 15, new int[] {2, 5, 3, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.LEATHER);
    }),
    SURVEY_CORPS("survey_corps", 15, new int[] {2, 5, 3, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.LEATHER);
    }),
    REINFORCED_LEATHER("reinforced_leather", 15, new int[] {2, 5, 3, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.LEATHER);
    });

    private static int[] baseDurability = {13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorValues;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;
 
    CustomArmor(
            String name, int durabilityMultiplier, int[] armorValueArr,
            int enchantability, SoundEvent soundEvent, float toughness,
            float knockbackResistance, Supplier<Ingredient> repairIngredient
    ) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorValues = armorValueArr;
        this.enchantability = enchantability;
        this.equipSound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDurability[slot.getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return armorValues[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    
    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}