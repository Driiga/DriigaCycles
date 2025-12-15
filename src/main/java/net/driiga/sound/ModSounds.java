package net.driiga.sound;

import net.driiga.DriigaCycles;
import net.driiga.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent ABSOLVER_SHRIEK = registerSoundEvent("absolver_shriek");

    private static SoundEvent registerSoundEvent(String name) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(DriigaCycles.MOD_ID, name),
                SoundEvent.of(Identifier.of(DriigaCycles.MOD_ID, name)));
    }

    public static void registerSounds() {
        DriigaCycles.LOGGER.info("Registering Mod Sounds for " + DriigaCycles.MOD_ID);

    }
}
