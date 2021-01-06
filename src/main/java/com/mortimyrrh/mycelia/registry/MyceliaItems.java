package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.items.MycelialStewItem;
import com.mortimyrrh.mycelia.items.MyshroomItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyceliaItems
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mycelia.MOD_ID);

    public static final RegistryObject<Item> MYCELIAL_STEW_ITEM = ITEMS.register("mycelial_stew", () -> new MycelialStewItem());
    public static final RegistryObject<Item> MYSHROOM_ITEM = ITEMS.register("myshroom", () -> new MyshroomItem());
    //public static final RegistryObject<Item> MYRRHSHROOM_ITEM = ITEMS.register("myrrhshroom", () -> new MyshroomItem());

    //public static final RegistryObject<Item> MYCELIAL_TEST_ITEM = ITEMS.register("mycelial_test", () -> new Item(new Item.Properties().group(Mycelia.myceliaCreativeTab)));

    public static void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }
}