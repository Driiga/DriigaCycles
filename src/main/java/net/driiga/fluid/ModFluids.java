package net.driiga.fluid;

import net.driiga.DriigaCycles;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.awt.dnd.DragGestureRecognizer;

public class ModFluids {
    public static FlowableFluid FLOWING_ABYSS_FLUID;
    public static FlowableFluid STILL_ABYSS_FLUID;

    public static Item ABYSS_FLUID_BUCKET;

    public static void register() {

       FLOWING_ABYSS_FLUID = (FlowableFluid) Registry.register(Registries.FLUID, Identifier.of(DriigaCycles.MOD_ID, "flowing_abyss_fluid"), new AbyssFluid.Flowing());
       STILL_ABYSS_FLUID = (FlowableFluid) Registry.register(Registries.FLUID, Identifier.of(DriigaCycles.MOD_ID,"still_abyss_fluid"), new AbyssFluid.Still());

        ABYSS_FLUID_BUCKET = Registry.register(Registries.ITEM, Identifier.of(DriigaCycles.MOD_ID, "abyss_fluid_bucket"),
                new BucketItem(ModFluids.STILL_ABYSS_FLUID, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ABYSS_FLUID_BUCKET);});

    }
}
