package com.mortimyrrh.mycelia.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mortimyrrh.mycelia.Mycelia;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NautilusRCTScreen extends G {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Mycelia.MOD_ID, "textures/guis/nautilus_gui.png");
    private static final int xSize =  248;
    private static final int ySize =  166;

    protected NautilusRCTScreen(ITextComponent textComponent) {
        super(textComponent);
    }

    @Override
    protected void renderBg(MatrixStack stack, float partialTicks, int x, int y) {
        this.renderBackground(stack);
        super.render(stack, x, y, partialTicks);


        int xStart = (this.width - this.xSize) / 2;
        int yStart = (this.height - this.ySize) / 2;

        // draw the background
        this.minecraft.getTextureManager().bind(GUI_TEXTURE);
        this.blit(stack, xStart, yStart, 0,0, this.xSize, this.ySize);
    }

//    @Override
//    protected void drawGuiContainerForegroundLayer(MatrixStack stack, int mouseX, int mouseY)
//    {
//        // positions and colors from ChestScreen
//        this.font.drawString(stack, this.title.getString(), 8.0F, 6.0F, 4210752);
//        this.font.drawString(stack, this.playerInventory.getDisplayName().getString(), 8.0F, this.ySize - 96 + 2, 4210752);
//    }

}
