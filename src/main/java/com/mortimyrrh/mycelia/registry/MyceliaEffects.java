package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.effects.MycelialDecayEffect;
import com.mortimyrrh.mycelia.effects.MycelialResistanceEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyceliaEffects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Mycelia.MOD_ID);

    public static final RegistryObject<Effect> MYCELIAL_DECAY_EFFECT = EFFECTS.register("mycelial_decay", () -> new MycelialDecayEffect());
    public static final RegistryObject<Effect> MYCELIAL_RESISTANCE_EFFECT = EFFECTS.register("mycelial_resistance", () -> new MycelialResistanceEffect());


    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Mycelia.MOD_ID);

    public static final RegistryObject<Potion> MYCELIAL_DECAY_POTION = POTIONS.register("mycelial_decay", () -> new Potion(new EffectInstance(MYCELIAL_DECAY_EFFECT.get(), 400, 1)));
    public static final RegistryObject<Potion> MYCELIAL_RESISTANCE_POTION = POTIONS.register("mycelial_resistance", () -> new Potion(new EffectInstance(MYCELIAL_RESISTANCE_EFFECT.get(), 200, 1)));
}