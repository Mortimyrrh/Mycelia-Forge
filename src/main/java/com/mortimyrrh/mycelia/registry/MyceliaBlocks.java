package com.mortimyrrh.mycelia.registry;

import com.mortimyrrh.mycelia.Mycelia;
import com.mortimyrrh.mycelia.items.MycelialStewItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MyceliaBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mycelia.MOD_ID);

    public static final RegistryObject<Block> A_BLOCK = BLOCKS.register("a", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.BONE_BLOCK))); // hardnessAndResistance(1.0F, 1.0F)));
}
