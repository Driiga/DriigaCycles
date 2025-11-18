package net.driiga.world.biome.surface;

import net.driiga.block.ModBlocks;
import net.driiga.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {

    private static final MaterialRules.MaterialRule DIRT = makeStateRule(ModBlocks.DETRITUS_BLOCK);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(ModBlocks.DETRITUS_BLOCK);
    private static final MaterialRules.MaterialRule CONDENSED_MATTER_BLOCK = makeStateRule(ModBlocks.CONDENSED_MATTER_BLOCK);
    private static final MaterialRules.MaterialRule DETRITUS_BLOCK = makeStateRule(ModBlocks.DETRITUS_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.ABYSS_LAND_BIOME),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, CONDENSED_MATTER_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, DETRITUS_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}


