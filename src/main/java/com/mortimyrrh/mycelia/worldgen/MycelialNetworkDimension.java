package com.mortimyrrh.mycelia.worldgen;

import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MycelialNetworkDimension {
    public static final RegistryKey<World> MN_WORLD_KEY = RegistryKey.create(Registry.DIMENSION_REGISTRY, Mycelia.MOD_DIMENSION_ID);

//    public static void setupDimension() {
//
////        MnChunkGenerator.registerChunkgenerator();
////        MnBiomeProvider.registerBiomeProvider();
//    }
}
