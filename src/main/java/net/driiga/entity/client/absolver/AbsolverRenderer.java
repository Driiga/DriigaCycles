package net.driiga.entity.client.absolver;

import net.driiga.DriigaCycles;
import net.driiga.entity.custom.AbsolverEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AbsolverRenderer extends MobEntityRenderer<AbsolverEntity, AbsolverModel<AbsolverEntity>> {


    public AbsolverRenderer(EntityRendererFactory.Context context) {
        super(context, new AbsolverModel<>(context.getPart(AbsolverModel.ABSOLVER)), 0.5f);
    }


    @Override
    public Identifier getTexture(AbsolverEntity entity) {
        return Identifier.of(DriigaCycles.MOD_ID, "textures/entity/absolver/absolver.png");
    }

    @Override
    public void render(AbsolverEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

            matrixStack.scale(1f, 1f, 1f);


        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
