package com.github.lapapesse02.attackontitanfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class AttackOnTitanMod implements ModInitializer {

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.create(
		new Identifier("attackontitan", "attackontitan"))
		.icon(() -> new ItemStack(AttackOnTitanMod.HOOK))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(AttackOnTitanMod.HOOK));
		}
		)
		.build();	

	public static final Hook HOOK = new Hook(new Hook.Settings().group(MOD_GROUP).maxCount(1));

	@Override
	public void onInitialize() {
		System.out.println("AttackOnTitan mod initialized!");

		Registry.register(Registry.ITEM, new Identifier("attackontitan", "hook"), HOOK);
	}
}
