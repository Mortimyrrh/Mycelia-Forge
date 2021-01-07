package com.mortimyrrh.mycelia.effects;

import com.mortimyrrh.mycelia.registry.MyceliaDamageSources;
import com.mortimyrrh.mycelia.registry.MyceliaEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;


public class MycelialDecayEffect extends Effect {
    public MycelialDecayEffect() {
        super(EffectType.HARMFUL, 0x00FFFF); //#ccc ?
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn, amplifier);

        if (entityLivingBaseIn instanceof PlayerEntity) {
            if (!entityLivingBaseIn.isPotionActive(MyceliaEffects.MYCELIAL_RESISTANCE_EFFECT.get()))
            {
            entityLivingBaseIn.attackEntityFrom(MyceliaDamageSources.MYCELIAL_EXSPOSURE, (1 << amplifier));
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
