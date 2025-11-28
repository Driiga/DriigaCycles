package net.driiga.world.dimension;

import net.driiga.DriigaCycles;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> ABYSS_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(DriigaCycles.MOD_ID, "abyssdim"));
    public static final RegistryKey<World> ABYSS_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(DriigaCycles.MOD_ID, "abyssdim"));
    public static final RegistryKey<DimensionType> ABYSS_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(DriigaCycles.MOD_ID, "abyssdim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(ABYSS_DIM_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                false, // bedWorks
                true, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.THE_NETHER_ID, // effectsLocation

                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}