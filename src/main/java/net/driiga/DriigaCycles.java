package net.driiga;

import net.driiga.block.ModBlocks;
import net.driiga.entity.ModEntities;
import net.driiga.entity.custom.RollyEntity;
import net.driiga.fluid.ModFluids;
import net.driiga.item.ModItems;
import net.driiga.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriigaCycles implements ModInitializer {
	public static final String MOD_ID = "driiga-cycles";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModFluids.register();

        ModEntities.registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.ROLLY, RollyEntity.createAttributes());

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.CONDENSED_MATTER_BLOCK)
                .lightWithFluid(ModFluids.STILL_ABYSS_FLUID)
                .destDimID(Identifier.of(DriigaCycles.MOD_ID, "abyssdim"))
                .tintColor(0x8f8f8f)
                .flatPortal()
                .registerPortal();

	}
}