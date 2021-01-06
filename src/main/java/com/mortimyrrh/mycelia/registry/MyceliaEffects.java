package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.effects.MycelialDecayEffect;
import com.mortimyrrh.mycelia.items.MycelialStewItem;
import com.mortimyrrh.mycelia.items.MyshroomItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyceliaEffects {

    private static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Mycelia.MOD_ID);
    //private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Mycelia.MOD_ID);

    public static final RegistryObject<Effect> MYCELIAL_DECAY_EFFECT = EFFECTS.register("mycelial_decay", MycelialDecayEffect::new);
    //public static final RegistryObject<Effect> MYCELIAL_D_EFFECT = EFFECTS.register("mycelial_decay", MycelialDecayEffect::new);

    //public static final RegistryObject<Potion> MYCELIAL_DECAY_POTION = POTIONS.register("mycelial_decay",
    //        () -> new Potion(new EffectInstance(MYCELIAL_DECAY_EFFECT.get(), 1200, 0)));



    public static void registerEffects() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}