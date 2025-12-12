package net.driiga.item;

import net.driiga.DriigaCycles;
import net.driiga.entity.ModEntities;
import net.driiga.fluid.ModFluids;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {



    public static final Item RAW_ENTROPIC_METAL = registerItem("raw_entropic_metal", new Item(new Item.Settings()));
    public static final Item ENTROPIC_METAL_INGOT = registerItem("entropic_metal_ingot", new Item(new Item.Settings()));
    //public static final Item ABYSS_FLUID_BUCKET = registerItem("abyss_fluid_bucket", new BucketItem(ModFluids.STILL_ABYSS_FLUID, new Item.Settings()));

    public static final Item ROLLY_SPAWN_EGG = registerItem("rolly_spawn_egg", new SpawnEggItem(ModEntities.ROLLY, 0x8c8c8c, 0x8a816d, new Item.Settings()));
    public static final Item ABSOLVER_SPAWN_EGG = registerItem("absolver_spawn_egg", new SpawnEggItem(ModEntities.ABSOLVER, 0x000000, 0xc9c9c9, new Item.Settings()));

//    public static Item ABYSS_FLUID_BUCKET = registerItem("abyss_fluid_bucket",
//            new BucketItem(ModFluids.STILL_ABYSS_FLUID, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DriigaCycles.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DriigaCycles.LOGGER.info("Registering Mod Items for " + DriigaCycles.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(ROLLY_SPAWN_EGG);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(ABSOLVER_SPAWN_EGG);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_ENTROPIC_METAL);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ENTROPIC_METAL_INGOT);});

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
//            entries.add(ABYSS_FLUID_BUCKET);});

    }

}
