package com.mortimyrrh.mycelia.items;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.effects.MycelialResistanceEffect;
import com.mortimyrrh.mycelia.registry.MyceliaEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class MycelialStewItem extends Item {

    public MycelialStewItem()
    {
        super(new Item.Properties()
                .rarity(Rarity.RARE)
                .maxStackSize(1)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(7)
                        .setAlwaysEdible()
                        //.effect(MycelialResFromStew, 1.0F)
                        //.effect(new EffectInstance(MyceliaEffects.MYCELIAL_RESISTANCE_EFFECT.get(), 1200), 1.0F)
                        //.effect(new EffectInstance(MyceliaEffects.MYCELIAL_RESISTANCE_EFFECT.get(), 200, 1), 1.0F)
                        //.effect(new EffectInstance(Effects.ABSORPTION, 2400, 3), 1.0F)
                        .fastToEat()
                        .build())
                .group(Mycelia.myceliaCreativeTab));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.mycelia.mycelial_stew.tooltip")
                .setStyle(Style.EMPTY
                        .applyFormatting(TextFormatting.DARK_PURPLE)
                        .applyFormatting(TextFormatting.ITALIC)));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.addPotionEffect(new EffectInstance(MyceliaEffects.MYCELIAL_RESISTANCE_EFFECT.get(), 200, 0));
        //entityLiving.playSound(MyceliaSounds.PORTAL_SOUND_EVENT, 1.0F, 1.0F);
        return this.isFood() ? entityLiving.onFoodEaten(worldIn, stack) : stack;
    }




    //    private BlockPos getSafeTeleportPosNearEntity (LivingEntity entity)
        //    {
        //        BlockPos blockPos = getNewTeleportPosNearEntity(entity);
        //
        ////        if (!Objects.requireNonNull(entity.world.getBlockEntity(blockPos))
        ////                .getCachedState().isAir() &&
        ////            !Objects.requireNonNull(entity.world.getBlockEntity(blockPos.add(0, 1, 0)))
        ////                .getCachedState().isAir()
        ////            )
        //        if (true)
        //        {
        //            // safe to teleport
        //            return blockPos;
        //        } else {
        //            // couldn't find safe block to teleport to.
        //            return entity.getBlockPos();
        //        }
        //    }
        //
        //
        //    private BlockPos getNewTeleportPosNearEntity (LivingEntity entity)
        //    {
        //        BlockPos blockPos = new BlockPos( // MEMORY LEAK!!!!!! (never call delete)
        //                entity.getX() + (Math.random() * 30) - 15,
        //                entity.getY() + (Math.random() * 5) + 2,
        //                entity.getZ() + (Math.random() * 30) - 15
        //        );
        //            return blockPos;
        //    }
        //
        //    @Override
        //    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity)
        //    {
        //        entity.playSound(MyceliaSounds.PORTAL_SOUND_EVENT, 1.0F, 1.0F);
        //
        //        if(!entity.world.getDimension().equals(DimensionType.THE_NETHER_ID))
        //        {
        //            BlockPos blockPos = getSafeTeleportPosNearEntity(entity);
        //
        //            ((PlayerEntity) entity).teleport(
        //                    blockPos.getX(),
        //                    blockPos.getY(),
        //                    blockPos.getZ()
        //            );
        //        }
        //
        //        return this.isFood() ? entity.eatFood(world, stack) : stack;
        //    }
}
