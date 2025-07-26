package net.reconhalcyon.reconium.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.reconhalcyon.reconium.Reconium;
import org.jetbrains.annotations.NotNull;

public class FacetingStationScreen extends AbstractContainerScreen<FacetingStationMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reconium.MOD_ID, "textures/gui/faceting_station_gui.png");

    public FacetingStationScreen(FacetingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = (width - imageWidth) / 2;
        int j = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, i, j, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pGuiGraphics, i, j);
    }

    private void renderProgressArrow(@NotNull GuiGraphics pGuiGraphics, int i, int j) {
        if(menu.isCrafting()) {
            pGuiGraphics.blit(TEXTURE, i + 85, j + 30, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
