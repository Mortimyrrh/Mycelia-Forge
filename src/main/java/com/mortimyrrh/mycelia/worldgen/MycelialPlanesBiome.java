//package com.mortimyrrh.mycelia.worldgen;
//
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.BiomeGenerationSettings;
//import net.minecraft.world.biome.DefaultBiomeFeatures;
//import net.minecraftforge.common.world.MobSpawnInfoBuilder;
//
//public class MycelialPlanesBiome extends Biome {
//    public MycelialPlanesBiome() {
//        super(new Biome.Builder()
//                .withGenerationSettings(BiomeGenerationSettings.DEFAULT_SETTINGS)
//                .precipitation(RainType.RAIN) //spore rain? going up like twilight
//                .category(Category.MUSHROOM)
//                .downfall(0.7f)
//                .depth(0.125f)
//                .temperature(0.5f)
//                .scale(0.5f)
//                .build());
//
//        DefaultBiomeFeatures.withDefaultFlowers(this);
//        DefaultBiomeFeatures.withOverworldOres(this);
//    }
//}
