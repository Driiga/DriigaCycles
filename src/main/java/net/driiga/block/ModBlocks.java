package net.driiga.block;

import net.driiga.DriigaCycles;
import net.driiga.block.custom.DetritusBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final Block CONDENSED_MATTER_BLOCK = registerBlock("condensed_matter_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block DETRITUS_BLOCK = registerBlock("detritus_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block DETRITUS = registerBlock(
            "detritus",
            new DetritusBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.GRAY)
                            .replaceable()
                            .notSolid()
                            .ticksRandomly()
                            .strength(0.1F)
                            .requiresTool()
                            .sounds(BlockSoundGroup.SNOW)
                            .blockVision((state, world, pos) -> (Integer) state.get(DetritusBlock.LAYERS) >= 8)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block DETRITUS_1_BLOCK = registerBlock("detritus_1_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block DETRITUS_2_BLOCK = registerBlock("detritus_2_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block ENTROPIC_ORE_BLOCK = registerBlock("entropic_ore_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DriigaCycles.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DriigaCycles.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        DriigaCycles.LOGGER.info("registering mod blocks for " + DriigaCycles.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CONDENSED_MATTER_BLOCK);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.DETRITUS_BLOCK);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.DETRITUS);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.DETRITUS_1_BLOCK);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.DETRITUS_2_BLOCK);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ENTROPIC_ORE_BLOCK);});
    }

}
