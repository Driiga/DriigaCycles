package net.driiga.world.biome.surface;

import net.driiga.block.ModBlocks;
import net.driiga.fluid.ModFluids;
import net.driiga.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.jetbrains.annotations.NotNull;

public class ModMaterialRules {

    //private static final MaterialRules.MaterialRule WATER = makeStateRule(Blocks.WATER);
    //private static final MaterialRules.MaterialRule ABYSS_FLUID_BLOCK = makeStateRule(ModBlocks.ABYSS_FLUID_BLOCK);
    private static final MaterialRules.MaterialRule CONDENSED_MATTER_BLOCK = makeStateRule(ModBlocks.CONDENSED_MATTER_BLOCK);
    private static final MaterialRules.MaterialRule DETRITUS_BLOCK = makeStateRule(ModBlocks.DETRITUS_BLOCK);
    private static final MaterialRules.MaterialRule DETRITUS_2_BLOCK = makeStateRule(ModBlocks.DETRITUS_2_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {

        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        //MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, DETRITUS_BLOCK), DETRITUS_2_BLOCK);



        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.ABYSS_LAND_BIOME), CONDENSED_MATTER_BLOCK))

               //MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.ABYSS_SEA_BIOME), ABYSS_FLUID_BLOCK))

        );
                // Default to a grass and dirt surface
                //MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)

    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
   }
}


