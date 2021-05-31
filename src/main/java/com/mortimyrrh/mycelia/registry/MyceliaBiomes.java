//package com.mortimyrrh.mycelia.registry;
//
//import com.mortimyrrh.mycelia.Mycelia;
//import javafx.scene.media.MediaException;
//import net.minecraft.world.biome.Biome;
//import net.minecraftforge.common.BiomeDictionary;
//import net.minecraftforge.common.BiomeManager;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class MyceliaBiomes {
//    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<Biome>(ForgeRegistries.BIOMES, Mycelia.MOD_ID);
//
//    public static final RegistryObject<Biome> MYCEILAL_PLANES = BIOMES.register("mycelial_planes", () -> new MycelialPlanesBiome());
//
//    public static void registerBiomes() {
//        registerBiome(MYCEILAL_PLANES.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY);
//    }
//
//    public static void registerBiome(Biome biome, BiomeDictionary.Type... type) {
//        BiomeDictionary.addTypes(biome, type);
//        BiomeManager.addBiome(type, biome);
//    }
//}
