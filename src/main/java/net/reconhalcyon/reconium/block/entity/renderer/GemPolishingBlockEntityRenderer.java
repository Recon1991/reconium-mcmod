package net.reconhalcyon.reconium.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.reconhalcyon.reconium.block.entity.GemPolishingStationBlockEntity;

public class GemPolishingBlockEntityRenderer implements BlockEntityRenderer<GemPolishingStationBlockEntity> {
    public GemPolishingBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        // Constructor logic if needed
    }


    @Override
    public void render(GemPolishingStationBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = blockEntity.getRenderStack();

        poseStack.pushPose();
        poseStack.translate(0.5f, 1.0f, 0.5f); // Center the item in the block entity
        poseStack.scale(0.35f, 0.35f, 0.35f); // Scale the item down for better visibility
        poseStack.mulPose(Axis.XP.rotationDegrees(270)); // Rotate the item to face the player

        itemRenderer.renderStatic(
                itemStack,
                ItemDisplayContext.FIXED,
                getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY,
                poseStack,
                buffer,
                blockEntity.getLevel(),
                1
        );
        poseStack.popPose();

    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
