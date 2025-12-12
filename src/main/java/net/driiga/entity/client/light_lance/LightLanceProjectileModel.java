package net.driiga.entity.client.light_lance;

import net.driiga.DriigaCycles;
import net.driiga.entity.client.rolly.RollyAnimations;
import net.driiga.entity.custom.LightLanceProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class LightLanceProjectileModel extends SinglePartEntityModel<LightLanceProjectileEntity> {
    public static final EntityModelLayer LIGHT_LANCE = new EntityModelLayer(Identifier.of(DriigaCycles.MOD_ID, "light_lance"), "main");
    // Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

        private final ModelPart body;
        private final ModelPart head;
        public LightLanceProjectileModel(ModelPart root) {
            this.body = root.getChild("body");
            this.head = this.body.getChild("head");
        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.9746F, -1.9355F));

            ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.9746F, -9.9355F, 2.0F, 2.0F, 30.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(18, 41).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1485F, 3.2115F, 0.5236F, 0.0F, 0.0F));

            ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(50, 57).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.6485F, -1.9546F, 0.3491F, 0.0F, 0.0F));

            ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(14, 59).cuboid(-1.0F, -2.2793F, -7.1492F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, -1.5892F, 0.1745F, 0.0F, -1.5708F));

            ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(50, 50).cuboid(-1.0F, -2.673F, -2.2799F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, -1.5892F, 0.3491F, 0.0F, -1.5708F));

            ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(18, 32).cuboid(-1.0F, -2.1914F, 2.7312F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, -1.5892F, 0.5236F, 0.0F, -1.5708F));

            ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(64, 0).cuboid(-1.0F, -2.2793F, -7.1492F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, -1.5892F, 0.1745F, 0.0F, 1.5708F));

            ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(64, 7).cuboid(-1.0F, -2.673F, -2.2799F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, -1.5892F, 0.3491F, 0.0F, 1.5708F));

            ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(36, 41).cuboid(-1.0F, -2.1914F, 2.7312F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, -1.5892F, 0.5236F, 0.0F, 1.5708F));

            ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(0, 59).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4515F, -6.3899F, 0.1745F, 0.0F, -3.1416F));

            ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(36, 50).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.6464F, -1.9546F, 0.3491F, 0.0F, -3.1416F));

            ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(0, 32).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.1464F, 3.2115F, 0.5236F, 0.0F, -3.1416F));

            ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(64, 14).cuboid(-1.0F, -2.2793F, -7.1492F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.1745F, 0.0F, -0.7418F));

            ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(64, 21).cuboid(-1.0F, -2.673F, -2.2799F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.3491F, 0.0F, -0.7418F));

            ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(0, 50).cuboid(-1.0F, -2.1914F, 2.7312F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.5236F, 0.0F, -0.7418F));

            ModelPartData cube_r15 = head.addChild("cube_r15", ModelPartBuilder.create().uv(28, 64).cuboid(-1.0F, -2.2793F, -7.1492F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.1745F, 0.0F, 2.3998F));

            ModelPartData cube_r16 = head.addChild("cube_r16", ModelPartBuilder.create().uv(54, 32).cuboid(-1.0F, -2.673F, -2.2799F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.3491F, 0.0F, 2.3998F));

            ModelPartData cube_r17 = head.addChild("cube_r17", ModelPartBuilder.create().uv(36, 32).cuboid(-1.0F, -2.1914F, 2.7312F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.5236F, 0.0F, 2.3998F));

            ModelPartData cube_r18 = head.addChild("cube_r18", ModelPartBuilder.create().uv(42, 64).cuboid(-1.0F, -2.2793F, -7.1492F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.1745F, 0.0F, -2.3126F));

            ModelPartData cube_r19 = head.addChild("cube_r19", ModelPartBuilder.create().uv(54, 39).cuboid(-1.0F, -2.673F, -2.2799F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.3491F, 0.0F, -2.3126F));

            ModelPartData cube_r20 = head.addChild("cube_r20", ModelPartBuilder.create().uv(0, 41).cuboid(-1.0F, -2.1914F, 2.7312F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.5236F, 0.0F, -2.3126F));

            ModelPartData cube_r21 = head.addChild("cube_r21", ModelPartBuilder.create().uv(64, 46).cuboid(-1.0F, -2.2793F, -7.1492F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.1745F, 0.0F, 0.829F));

            ModelPartData cube_r22 = head.addChild("cube_r22", ModelPartBuilder.create().uv(64, 53).cuboid(-1.0F, -2.673F, -2.2799F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.3491F, 0.0F, 0.829F));

            ModelPartData cube_r23 = head.addChild("cube_r23", ModelPartBuilder.create().uv(18, 50).cuboid(-1.0F, -2.1914F, 2.7312F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0011F, 1.4108F, 0.5236F, 0.0F, 0.829F));

            ModelPartData cube_r24 = head.addChild("cube_r24", ModelPartBuilder.create().uv(36, 57).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.4536F, -6.3899F, 0.1745F, 0.0F, 0.0F));
            return TexturedModelData.of(modelData, 128, 128);
        }

        @Override
        public void setAngles(LightLanceProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);

            this.animateMovement(LightLanceProjectileAnimations.FLYING_ATTACK, limbSwing, limbSwingAmount, 2f, 2.5f);
            this.updateAnimation(entity.idleAnimationState, LightLanceProjectileAnimations.FLYING_IDLE, ageInTicks, 1f);

        }

    @Override
    public void animateModel(LightLanceProjectileEntity entity, float limbAngle, float limbDistance, float tickDelta) {
        super.animateModel(entity, limbAngle, limbDistance, tickDelta);
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
            this.body.yaw = yaw * ((float)Math.PI / 180F);
            this.body.pitch = pitch * ((float)Math.PI / 180F);
        }


        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            body.render(matrices, vertexConsumer, light, overlay, color);
        }

    @Override
    public ModelPart getPart() {
        return body;
    }

}


