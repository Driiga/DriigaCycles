package net.driiga.fluid;

import net.driiga.DriigaCycles;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.awt.dnd.DragGestureRecognizer;

public class ModFluids {
    public static FlowableFluid STILL_ABYSS_FLUID;
    public static FlowableFluid FLOWING_ABYSS_FLUID;
    public static Block ABYSS_FLUID_BLOCK;
    public static Item ABYSS_FLUID_BUCKET;

    public static void register() {
        STILL_ABYSS_FLUID = Registry.register(Registries.FLUID,
                Identifier.of(DriigaCycles.MOD_ID, "abyss_fluid"), new AbyssFluid.Still());
        FLOWING_ABYSS_FLUID = Registry.register(Registries.FLUID,
                Identifier.of(DriigaCycles.MOD_ID, "flowing_abyss_fluid"), new AbyssFluid.Flowing());

        ABYSS_FLUID_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(DriigaCycles.MOD_ID, "abyss_fluid_block"),
                new FluidBlock(ModFluids.STILL_ABYSS_FLUID, AbstractBlock.Settings.copy(Blocks.WATER)){ });
        ABYSS_FLUID_BUCKET = Registry.register(Registries.ITEM, Identifier.of(DriigaCycles.MOD_ID, "abyss_fluid_bucket"),
                new BucketItem(ModFluids.STILL_ABYSS_FLUID, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ABYSS_FLUID_BUCKET);
        });
    }
}
