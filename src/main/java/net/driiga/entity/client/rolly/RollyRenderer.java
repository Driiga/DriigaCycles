package net.driiga.entity.client.rolly;

import net.driiga.DriigaCycles;
import net.driiga.entity.custom.RollyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RollyRenderer extends MobEntityRenderer<RollyEntity, RollyModel<RollyEntity>> {


    public RollyRenderer(EntityRendererFactory.Context context) {
        super(context, new RollyModel<>(context.getPart(RollyModel.ROLLY)), 0.5f);
    }

    @Override
    public Identifier getTexture(RollyEntity entity) {
        return Identifier.of(DriigaCycles.MOD_ID, "textures/entity/rolly/rolly.png");
    }

    @Override
    public void render(RollyEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.25f, 0.25f, 0.25f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
