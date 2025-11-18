package net.driiga.world.biome;

import net.driiga.DriigaCycles;
import net.driiga.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {

        Regions.register(new ModOverworldRegion(Identifier.of(DriigaCycles.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, DriigaCycles.MOD_ID, ModMaterialRules.makeRules());

    }
}
