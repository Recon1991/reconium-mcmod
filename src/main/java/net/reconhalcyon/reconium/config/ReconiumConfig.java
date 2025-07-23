package net.reconhalcyon.reconium.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ReconiumConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ReconiumConfig INSTANCE;

    public final ForgeConfigSpec.ConfigValue<List<? extends String>> enabledGems;

    static {
        final Pair<ReconiumConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ReconiumConfig::new);
        INSTANCE = specPair.getLeft();
        SPEC = specPair.getRight();
    }

    private ReconiumConfig(ForgeConfigSpec.Builder builder) {
        builder.push("general");
        enabledGems = builder.comment(
                "List of enabled gems.",
                "Only gems listed here will be loaded.",
                "Leave empty to load all gems found in data packs."
        ).defineListAllowEmpty(
                List.of("enabledGems"),
                () -> List.of("moonstone"), // default list
                o -> o instanceof String
        );
        builder.pop();
    }
}
