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
        poseStack.translate(0.55f, 0.6f, 0.65f);
        poseStack.scale(0.25f, 0.25f, 0.25f); // Scale the item down for better visibility
        poseStack.mulPose(Axis.XP.rotationDegrees(90)); // Rotate the item to face the player
        poseStack.mulPose(Axis.YN.rotationDegrees(22.5f)); // Rotate the item to align with the mast arm
        poseStack.mulPose(Axis.ZP.rotationDegrees(90)); // Slightly tilt the item to align with the angle of the mast arm

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




