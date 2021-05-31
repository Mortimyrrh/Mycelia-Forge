package com.mortimyrrh.mycelia.items.armour;


import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AncientMycelialMaterial implements IArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{3, 6, 8, 3};

    public int getDurability(EquipmentSlotType slotIn) {
        return 0;
    }

//    @Override
//    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
//        return 0;
//    }

    public int getEnchantability() {
        return 10;
    }

//    @Override
//    public SoundEvent getSoundEvent() {
//        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
//    }

//    @Override
//    public Ingredient getRepairMaterial() {
//        return Ingredient.fromItems(Items.SANDSTONE);
//    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return 0;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return "ancient_mycelial";
    }

    public float getToughness() {
        return 2.5F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0F;
    }
}