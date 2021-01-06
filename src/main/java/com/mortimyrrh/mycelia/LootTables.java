package com.mortimyrrh.mycelia;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class LootTables extends LootModifier {
    private final int numSeedsToConvert;
    private final Item itemToCheck;
    private final Item itemReward;

    public LootTables(ILootCondition[] conditionsIn, int numSeeds, Item itemCheck, Item reward) {
        super(conditionsIn);
        numSeedsToConvert = numSeeds;
        itemToCheck = itemCheck;
        itemReward = reward;
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        //
        // Additional conditions can be checked, though as much as possible should be parameterized via JSON data.
        // It is better to write a new ILootCondition implementation than to do things here.
        //
        int numSeeds = 0;
        for(ItemStack stack : generatedLoot) {
            if(stack.getItem() == itemToCheck)
                numSeeds+=stack.getCount();
        }
        if(numSeeds >= numSeedsToConvert) {
            generatedLoot.removeIf(x -> x.getItem() == itemToCheck);
            generatedLoot.add(new ItemStack(itemReward, (numSeeds/numSeedsToConvert)));
            numSeeds = numSeeds%numSeedsToConvert;
            if(numSeeds > 0)
                generatedLoot.add(new ItemStack(itemToCheck, numSeeds));
        }
        return generatedLoot;
    }

    private static class Serializer extends GlobalLootModifierSerializer<LootTables> {

        @Override
        public LootTables read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            int numSeeds = JSONUtils.getInt(object, "numSeeds");
            Item seed = ForgeRegistries.ITEMS.getValue(new ResourceLocation((JSONUtils.getString(object, "seedItem"))));
            Item wheat = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "replacement")));
            return new LootTables(conditionsIn, numSeeds, seed, wheat);
        }

        @Override
        public JsonObject write(LootTables instance) {
            return null;
        }
    }
}