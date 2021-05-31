package com.mortimyrrh.mycelia.items;

import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class NautilusRCTItem extends Item{

    public NautilusRCTItem() {
        super(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(1)
                .tab(Mycelia.myceliaCreativeTab));
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.mycelia.nautilus_rct.tooltip")
                .setStyle(Style.EMPTY
                        .applyFormat(TextFormatting.DARK_PURPLE)
                        .applyFormat(TextFormatting.ITALIC)));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (playerEntity.getCommandSenderWorld().isClientSide())
            return ActionResult.pass(playerEntity.getItemInHand(hand));

        if (world.equals((playerEntity.getServer().getLevel(World.OVERWORLD))))
            teleportPlayerRelative(playerEntity, World.END);
        else
            teleportPlayerRelative(playerEntity, World.OVERWORLD);

        return ActionResult.pass(playerEntity.getItemInHand(hand));
    }

    public static void teleportPlayerRelative(PlayerEntity player, RegistryKey<World> worldRegistryKey) {
        teleportPlayer(player, worldRegistryKey, getSafeSpawn(player.position()));
    }

    public static Vector3d getSafeSpawn(Vector3d targetPos)
    {
        Vector3d safePos;
        safePos = targetPos; // Not very safe yet
        return safePos;
    }

    public static void teleportPlayer(PlayerEntity player, RegistryKey<World> worldRegistryKey, Vector3d pos) {
        if (player.getCommandSenderWorld().isClientSide()) return;

        ServerWorld world = player.getServer().getLevel(worldRegistryKey);

        if (pos == null || world == null) return;

        ((ServerPlayerEntity) player).teleportTo(world, pos.x(), pos.y(), pos.z(), player.yRot, player.xRot);

        player.getCommandSenderWorld().playSound(player, pos.x(), pos.y(), pos.z(),
                SoundEvents.ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }
}
