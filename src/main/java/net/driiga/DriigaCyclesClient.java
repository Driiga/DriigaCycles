package net.driiga;

import net.driiga.entity.ModEntities;
import net.driiga.entity.client.RollyModel;
import net.driiga.entity.client.RollyRenderer;
import net.driiga.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class DriigaCyclesClient implements ClientModInitializer {

    public static Identifier WATER_STILL = Identifier.ofVanilla("block/water_still");

    @Override
    public void onInitializeClient() {


        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ABYSS_FLUID, ModFluids.FLOWING_ABYSS_FLUID,
                new SimpleFluidRenderHandler(
                        Identifier.of("minecraft", "block/water_still"),
                        Identifier.of("minecraft","block/water_flow"),
                        Identifier.of("minecraft","block/water_overlay"),
                        0xA1151515
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_ABYSS_FLUID, ModFluids.FLOWING_ABYSS_FLUID);


        EntityModelLayerRegistry.registerModelLayer(RollyModel.ROLLY, RollyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ROLLY, RollyRenderer::new);
    }
}
