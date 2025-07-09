package net.reconhalcyon.reconium;

import com.mojang.logging.LogUtils;
import net.reconhalcyon.reconium.block.ModBlocks;
import net.reconhalcyon.reconium.item.ModCreativeModTabs;
import net.reconhalcyon.reconium.item.ModItems;
import org.slf4j.Logger;

public final class Reconium {
    public static final String MOD_ID = "reconium";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Called from the platform-specific init hooks
    public static void initCommon() {
        ModCreativeModTabs.init();
        ModItems.init();
        ModBlocks.init();
    }
}
