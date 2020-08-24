package com.github.lapapesse02.attackontitanfabric.items;

import com.github.lapapesse02.attackontitanfabric.AttackOnTitanMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Grip extends Item {

    public Grip(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.inventory.contains(new ItemStack(AttackOnTitanMod.UH_STEEL_BLADE))){
            user.playSound(SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 1.0F);
            int slot = user.inventory.getSlotWithStack(new ItemStack(AttackOnTitanMod.UH_STEEL_BLADE));

            user.inventory.removeStack(slot);
            user.setStackInHand(hand, new ItemStack(AttackOnTitanMod.UH_STEEL_SWORD));
        }

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
    
}