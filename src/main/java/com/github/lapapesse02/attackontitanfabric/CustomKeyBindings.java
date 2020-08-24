package com.github.lapapesse02.attackontitanfabric;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class CustomKeyBindings implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBinding gas = KeyBindingHelper.registerKeyBinding( new KeyBinding(
            "key.attackontitan.gas",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_C,
            "key.movement.attackontitan"
        ));
        KeyBinding launchHook = KeyBindingHelper.registerKeyBinding( new KeyBinding(
            "key.attackontitan.launchhook",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_V,
            "key.movement.attackontitan"
        ));

    }
    
}