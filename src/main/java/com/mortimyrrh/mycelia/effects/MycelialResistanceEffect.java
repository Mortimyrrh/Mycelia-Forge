package com.mortimyrrh.mycelia.effects;

import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class MycelialResistanceEffect extends Effect
{
    public MycelialResistanceEffect() {
        super(EffectType.BENEFICIAL, 0x55FFFF);
        //#ccc was 0x00FFFF?
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn, amplifier);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}