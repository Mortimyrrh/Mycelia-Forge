package com.mortimyrrh.mycelia.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

public class MycelialNetworkChunkGenerator extends ChunkGenerator {
    public MycelialNetworkChunkGenerator(BiomeProvider p_i231888_1_, DimensionStructuresSettings p_i231888_2_) {
        super(p_i231888_1_, p_i231888_2_);
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return null;
    }

    @Override
    public ChunkGenerator withSeed(long p_230349_1_) {
        return null;
    }

    @Override
    public void buildSurfaceAndBedrock(WorldGenRegion p_225551_1_, IChunk p_225551_2_) {

    }

    @Override
    public void fillFromNoise(IWorld p_230352_1_, StructureManager p_230352_2_, IChunk p_230352_3_) {

    }

    @Override
    public int getBaseHeight(int p_222529_1_, int p_222529_2_, Heightmap.Type p_222529_3_) {
        return 0;
    }

    @Override
    public IBlockReader getBaseColumn(int p_230348_1_, int p_230348_2_) {
        return null;
    }
}
