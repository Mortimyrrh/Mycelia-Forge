package com.mortimyrrh.mycelia.effects;

import net.minecraft.util.DamageSource;

public class MycelialExsposureDamage extends DamageSource {
    public MycelialExsposureDamage(String damageTypeIn) {
        super(damageTypeIn);
        this.setScalesWithDifficulty();
        this.setMagic();
        this.bypassArmor();
    }
}