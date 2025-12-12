package net.driiga.entity.client.light_lance;

import net.driiga.DriigaCycles;
import net.driiga.entity.client.rolly.RollyModel;
import net.driiga.entity.custom.LightLanceProjectileEntity;
import net.driiga.entity.custom.RollyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class LightLanceProjectileRenderer extends EntityRenderer<LightLanceProjectileEntity> {
    public static final Identifier TEXTURE = Identifier.of(DriigaCycles.MOD_ID, "textures/entity/light_lance/light_lance.png");
    protected LightLanceProjectileModel model;

    public LightLanceProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new LightLanceProjectileModel(ctx.getPart(LightLanceProjectileModel.LIGHT_LANCE));
    }

    @Override
    public void render(LightLanceProjectileEntity LightLanceProjectileEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(-1.0F, 1.0F, 1.0F);
        float h = MathHelper.lerpAngleDegrees(g, LightLanceProjectileEntity.prevYaw, LightLanceProjectileEntity.getYaw());
        float j = MathHelper.lerp(g, LightLanceProjectileEntity.prevPitch, LightLanceProjectileEntity.getPitch());
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(LightLanceProjectileEntity)));
        this.model.setHeadRotation(0.0F, h, j);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(LightLanceProjectileEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(LightLanceProjectileEntity entity) {
        return TEXTURE;
    }

}
