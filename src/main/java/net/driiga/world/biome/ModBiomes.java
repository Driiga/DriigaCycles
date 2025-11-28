package net.driiga.world.biome;

import net.driiga.DriigaCycles;
import net.driiga.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes {

    public static final RegistryKey<Biome> ABYSS_LAND_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(DriigaCycles.MOD_ID, "abyss_land_biome"));

    public static final RegistryKey<Biome> ABYSS_SEA_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(DriigaCycles.MOD_ID, "abyss_sea_biome"));

    public static void boostrap(Registerable<Biome> context) {
        context.register(ABYSS_LAND_BIOME, abyssLandBiome(context));
        context.register(ABYSS_SEA_BIOME, abyssSeaBiome(context));
    }



    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {

        CustomBiomeFeatures.addLandOnlyCarvers(builder);
        //DefaultBiomeFeatures.addLandCarvers(builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE));
        //DefaultBiomeFeatures.addLandCarvers(builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND));
        //DefaultBiomeFeatures.addLandCarvers(builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CANYON));

        //DefaultBiomeFeatures.addAmethystGeodes(builder);
        //DefaultBiomeFeatures.addDungeons(builder);
        //DefaultBiomeFeatures.addMineables(builder);
        //DefaultBiomeFeatures.addSprings(builder);
        //DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome abyssSeaBiome(Registerable<Biome> context) {

        //mob spawns
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //specific mob spawns
        //spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.ABYSS_EEL, 2, 3, 5));
        // ADD LATER ^^

        //biome features
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);


        return new Biome.Builder()
                .precipitation(true)
                .downfall(1.4f)
                .temperature(0.0f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0d0d0d)
                        .waterFogColor(0x0d0d0d)
                        .skyColor(0x0d0d0d)
                        .grassColor(0x0d0d0d)
                        .foliageColor(0x0d0d0d)
                        .fogColor(0x0d0d0d)
                        .moodSound(BiomeMoodSound.CAVE).build())
                //.music(MusicType.createIngameMusic(RegistryEntry.of(Sounds.BAR_BRAWL))).build())
                .build();
    }


    public static Biome abyssLandBiome(Registerable<Biome> context) {


        //mob spawns
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        //DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        //specific mob spawns
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.ROLLY, 10, 3, 5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 8, 4, 4));


        //biome features
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        //DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);


        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        //DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        //DefaultBiomeFeatures.addLargeFerns(biomeBuilder);

        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(1.4f)
                .temperature(0.0f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x1c1c1c)
                        .waterFogColor(0x1c1c1c)
                        .skyColor(0x1c1c1c)
                        .grassColor(0x1c1c1c)
                        .foliageColor(0x1c1c1c)
                        .fogColor(0x1c1c1c)
                        .moodSound(BiomeMoodSound.CAVE).build())
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(Sounds.BAR_BRAWL))).build())
                .build();
    }
}

