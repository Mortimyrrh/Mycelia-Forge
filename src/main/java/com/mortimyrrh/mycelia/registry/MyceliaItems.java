package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.items.MycelialStewItem;
import com.mortimyrrh.mycelia.items.MyshroomItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyceliaItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mycelia.MOD_ID);

    //Food
    public static final RegistryObject<Item> MYCELIAL_STEW_ITEM = ITEMS.register("mycelial_stew", () -> new MycelialStewItem());

    //Mushrooms
    public static final RegistryObject<Item> MYSHROOM_ITEM = ITEMS.register("myshroom", () -> new MyshroomItem());
    //public static final RegistryObject<Item> MYRRHSHROOM_ITEM = ITEMS.register("myrrhshroom", () -> new MyshroomItem());
    //public static final RegistryObject<Item> MYCELIAL_TEST_ITEM = ITEMS.register("mycelial_test", () -> new Item(new Item.Properties().group(Mycelia.myceliaCreativeTab)));

    //Armour
    public static final RegistryObject<Item> ANCIENT_MYCELIAL_HELMET = ITEMS.register("ancient_mycelial_helmet", () -> new ArmorItem(Mycelia.ancientMycelialMaterial, EquipmentSlotType.HEAD, (new Item.Properties()).group(Mycelia.myceliaCreativeTab)));

}