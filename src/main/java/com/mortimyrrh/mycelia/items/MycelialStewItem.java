package com.mortimyrrh.mycelia.items;

import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.w3c.dom.ranges.Range;

import javax.annotation.Nullable;
import javax.management.openmbean.SimpleType;
import java.util.List;

public class MycelialStewItem extends Item {

    public MycelialStewItem()
    {

        super(new Item.Properties()
                .rarity(Rarity.RARE)
                .maxStackSize(16)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(7)
                        .setAlwaysEdible()
                        //.statusEffect(new StatusEffectInstance(MyceliaEffects.MYCELIAL_RESISTANCE, (20 * 25)), 1.0f)
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
