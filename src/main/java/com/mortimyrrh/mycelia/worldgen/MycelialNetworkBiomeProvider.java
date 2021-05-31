package com.mortimyrrh.mycelia.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class MycelialNetworkBiomeProvider extends BiomeProvider {

    protected MycelialNetworkBiomeProvider(Stream<Supplier<Biome>> p_i241937_1_) {
        super(p_i241937_1_);
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return null;
    }

    @Override
    public BiomeProvider withSeed(long p_230320_1_) {
        return null;
    }

    @Override
    public Biome getNoiseBiome(int p_225526_1_, int p_225526_2_, int p_225526_3_) {
        return null;
    }
}