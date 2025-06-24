package net.reconhalcyon.neoforge;

import net.neoforged.fml.common.Mod;

import net.reconhalcyon.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
