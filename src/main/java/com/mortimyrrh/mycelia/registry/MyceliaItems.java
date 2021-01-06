package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.items.MycelialStewItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyceliaItems
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mycelia.MOD_ID);

    public static final RegistryObject<Item> MYCELIAL_STEW_ITEM = ITEMS.register("mycelial_stew", () -> new MycelialStewItem());
    public static final RegistryObject<Item> MYCELIAL_TEST_ITEM = ITEMS.register("mycelial_test", () -> new Item(new Item.Properties().group(Mycelia.myceliaCreativeTab)));

    public static void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }
}