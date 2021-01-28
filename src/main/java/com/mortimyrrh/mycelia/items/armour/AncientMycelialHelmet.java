package com.mortimyrrh.mycelia.items.armour;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.client.event.ColorHandlerEvent;

public class AncientMycelialHelmet extends ArmorItem {
    public AncientMycelialHelmet(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }
    //Items.IRON_HELMET;

    //public static final Item IRON_HELMET = register("iron_helmet", new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));

}
