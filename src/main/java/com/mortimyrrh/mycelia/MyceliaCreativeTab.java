package com.mortimyrrh.mycelia;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.registry.MyceliaItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class MyceliaCreativeTab extends ItemGroup {
    public MyceliaCreativeTab() {
        super(Mycelia.MOD_ID + ".main");
    }
//    @Override
//    public ItemStack createIcon() {
//        return new ItemStack(MyceliaItems.MYCELIAL_STEW_ITEM.get());
//    }

    @Nonnull
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(MyceliaItems.MYCELIAL_STEW_ITEM.get());
    }
}
