package com.mortimyrrh.mycelia.items;

import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class MyshroomItem extends Item {

    public MyshroomItem() {
        super(new Item.Properties()
                .rarity(Rarity.UNCOMMON)
                .stacksTo(32)
                .tab(Mycelia.myceliaCreativeTab));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.mycelia.myshroom.tooltip")
                .setStyle(Style.EMPTY
                        .applyFormat(TextFormatting.DARK_PURPLE)
                        .applyFormat(TextFormatting.ITALIC)));
    }
}
