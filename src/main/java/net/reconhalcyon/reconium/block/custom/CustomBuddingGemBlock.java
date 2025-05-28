package net.reconhalcyon.reconium.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.reconhalcyon.reconium.registry.ModGemRegistry;
import org.jetbrains.annotations.NotNull;

public class CustomBuddingGemBlock extends AmethystBlock {
    private final String gemId;
    private static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public CustomBuddingGemBlock(String gemId, BlockBehaviour.Properties properties) {
        super(properties);
        this.gemId = gemId;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
        if (random.nextInt(GROWTH_CHANCE) == 0) {
            Direction dir = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos targetPos = pos.relative(dir);
            BlockState targetState = level.getBlockState(targetPos);

            // ═══╬═══ Gem Registry Group Maps ═══╬═══
            Block small = ModGemRegistry.SMALL_BUDS.get(gemId).get();
            Block medium = ModGemRegistry.MEDIUM_BUDS.get(gemId).get();
            Block large = ModGemRegistry.LARGE_BUDS.get(gemId).get();
            Block cluster = ModGemRegistry.CLUSTERS.get(gemId).get();

            // ═══╬═══ Cluster Growing Logic ═══╬═══
            Block nextStage = null;
            if (canClusterGrowAtState(targetState)) {
                nextStage = small;
            } else if (targetState.is(small) && targetState.getValue(AmethystClusterBlock.FACING) == dir) {
                nextStage = medium;
            } else if (targetState.is(medium) && targetState.getValue(AmethystClusterBlock.FACING) == dir) {
                nextStage = large;
            } else if (targetState.is(large) && targetState.getValue(AmethystClusterBlock.FACING) == dir) {
                nextStage = cluster;
            }

            if (nextStage != null) {
                BlockState newState = nextStage.defaultBlockState()
                        .setValue(AmethystClusterBlock.FACING, dir)
                        .setValue(AmethystClusterBlock.WATERLOGGED,
                                targetState.getFluidState().getType() == Fluids.WATER);
                level.setBlockAndUpdate(targetPos, newState);
            }
        }
    }

    private static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || (state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8);
    }
}
