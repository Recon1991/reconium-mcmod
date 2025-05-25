package net.reconhalcyon.reconium.datagen;

import com.mojang.serialization.Codec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.reconhalcyon.reconium.Reconium;

public class DataProviderUtils {

    public static void writeConfiguredFeatureJson(PackOutput output, HolderLookup.Provider provider,
                                                  ResourceLocation id, ConfiguredFeature<?, ?> object, CachedOutput cache) {
        writeJson(output, provider, id, object, cache,
                net.minecraft.core.registries.Registries.CONFIGURED_FEATURE,
                ConfiguredFeature.DIRECT_CODEC);
    }

    public static void writePlacedFeatureJson(PackOutput output, HolderLookup.Provider provider,
                                              ResourceLocation id, PlacedFeature object, CachedOutput cache) {
        writeJson(output, provider, id, object, cache,
                net.minecraft.core.registries.Registries.PLACED_FEATURE,
                PlacedFeature.DIRECT_CODEC);
    }

    public static void writeBiomeModifierJson(PackOutput output, HolderLookup.Provider provider,
                                              ResourceLocation id, BiomeModifier object, CachedOutput cache) {
        writeJson(output, provider, id, object, cache,
                ForgeRegistries.Keys.BIOME_MODIFIERS,
                BiomeModifier.DIRECT_CODEC);
    }

    private static <T> void writeJson(PackOutput output, HolderLookup.Provider provider, ResourceLocation id,
                                      T object, CachedOutput cache,
                                      ResourceKey<Registry<T>> registry, Codec<T> codec) {
        JsonCodecProvider<T> generator = JsonCodecProvider.create(
                output, provider, Reconium.MOD_ID, registry, codec, java.util.Map.of(id, object)
        );
        generator.run(cache);
    }
}

