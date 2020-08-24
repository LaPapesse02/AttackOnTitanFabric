package com.github.lapapesse02.attackontitanfabric.tools;

import java.util.function.Consumer;

import com.github.lapapesse02.attackontitanfabric.AttackOnTitanMod;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.ListTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UltraHardSteelSword extends SwordItem {

    public UltraHardSteelSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public void replaceSwordWithGrip(LivingEntity entity, ItemStack stack) {
        entity.setStackInHand(
            entity.getActiveHand(),  // Hand holding the destroyed sword
            new ItemStack(AttackOnTitanMod.SWORD_GRIP) // Replacement item
        );
        stack.increment(1);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0F) {
           stack.damage(2, (LivingEntity)miner, (Consumer<LivingEntity>)((e) -> {
              e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
           }));
        }
        if (stack.isEmpty()) {
            this.replaceSwordWithGrip(miner, stack);
            
        }
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, (LivingEntity)attacker, (Consumer<LivingEntity>)((e) -> {
           e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));
        if (stack.isEmpty()) {
            this.replaceSwordWithGrip(attacker, stack);
            stack.isEnchantable();
        }
        return true;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.inventory.contains(new ItemStack(AttackOnTitanMod.UH_STEEL_BLADE))){
            user.playSound(SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 1.0F);
            int slot = user.inventory.getSlotWithStack(new ItemStack(AttackOnTitanMod.UH_STEEL_BLADE));

            ListTag enchantments = user.getStackInHand(hand).getEnchantments();

            user.inventory.removeStack(slot);
            user.setStackInHand(hand, new ItemStack(AttackOnTitanMod.UH_STEEL_SWORD));

            EnchantmentHelper.set(
                EnchantmentHelper.fromTag(enchantments),
                user.getStackInHand(hand)
            );
            
            
        }

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

}