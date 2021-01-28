package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class MyceliaSounds
{

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Mycelia.MOD_ID);

    //public static final RegistryObject<SoundEvent> PORTAL_SOUND_EVENT =  SOUND_EVENTS.register("portal_sound_event", () -> new SoundEvent("sounds/portal1.oog"));
}
