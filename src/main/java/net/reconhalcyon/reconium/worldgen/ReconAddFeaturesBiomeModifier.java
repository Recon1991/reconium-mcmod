package net.reconhalcyon.reconium.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record ReconAddFeaturesBiomeModifier(
        TagKey<Biome> biomes,
        HolderSet<PlacedFeature> features,
        GenerationStep.Decoration step
) implements BiomeModifier {

    public static final Codec<ReconAddFeaturesBiomeModifier> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(net.minecraft.core.registries.Registries.BIOME).fieldOf("biomes").forGetter(ReconAddFeaturesBiomeModifier::biomes),
            PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(ReconAddFeaturesBiomeModifier::features),
            GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(ReconAddFeaturesBiomeModifier::step)
    ).apply(instance, ReconAddFeaturesBiomeModifier::new));


    @Override
    public void modify(Holder<Biome> holder, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {

    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return null;
    }
}
