package com.github.lapapesse02.attackontitanfabric.tools;

import java.util.function.Supplier;

import com.github.lapapesse02.attackontitanfabric.AttackOnTitanMod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum CustomToolMaterial implements ToolMaterial {
    ULTRAHARD_STEEL(2, 300, 7F, 2F, 15, () -> {
        return Ingredient.ofItems(AttackOnTitanMod.UH_STEEL_BLADE);
    });
    
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeedMultiplyer;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;


    CustomToolMaterial(
        int miningLevel, int itemDurability, float miningSpeedMultiplyer,
        float attackDamage, int enchantability,
        Supplier<Ingredient> repairIngredient
            ) {

        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeedMultiplyer = miningSpeedMultiplyer;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);

    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplyer;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}