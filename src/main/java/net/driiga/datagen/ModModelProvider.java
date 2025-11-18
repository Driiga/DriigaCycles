package net.driiga.datagen;

import net.driiga.block.ModBlocks;
import net.driiga.fluid.ModFluids;
import net.driiga.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_MATTER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DETRITUS_2_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DETRITUS_1_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENTROPIC_ORE_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.RAW_ENTROPIC_METAL, Models.GENERATED);
        itemModelGenerator.register(ModFluids.ABYSS_FLUID_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROLLY_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
