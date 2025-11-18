package net.driiga.entity;

import net.driiga.DriigaCycles;

import net.driiga.entity.custom.RollyEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RollyEntity> ROLLY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DriigaCycles.MOD_ID, "rolly"),
            EntityType.Builder.create(RollyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f).build());


    public static void registerModEntities() {DriigaCycles.LOGGER.info("registring mod ent for" + DriigaCycles.MOD_ID);
    }
}
