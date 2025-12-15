package net.driiga.entity.client.absolver;

import net.driiga.DriigaCycles;
import net.driiga.entity.client.rolly.RollyAnimations;
import net.driiga.entity.custom.AbsolverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class AbsolverModel<T extends AbsolverEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer ABSOLVER = new EntityModelLayer(Identifier.of(DriigaCycles.MOD_ID, "absolver"), "main");

    // Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
        private final ModelPart absolver;
        private final ModelPart head;
        private final ModelPart upper_jaw;
        private final ModelPart lower_jaw;
        private final ModelPart neck;
        private final ModelPart v_1;
        private final ModelPart v_2;
        private final ModelPart body;
        private final ModelPart tail;
        private final ModelPart bone;
        private final ModelPart bone2;
        private final ModelPart bone3;
        private final ModelPart bone4;
        private final ModelPart scythe;
        private final ModelPart wings;
        private final ModelPart left_wing;
        private final ModelPart bone5;
        private final ModelPart bone6;
        private final ModelPart bone7;
        private final ModelPart right_wing;
        private final ModelPart bone8;
        private final ModelPart bone9;
        private final ModelPart bone10;

        public AbsolverModel(ModelPart root) {
            this.absolver = root.getChild("absolver");
            this.head = this.absolver.getChild("head");
            this.upper_jaw = this.head.getChild("upper_jaw");
            this.lower_jaw = this.head.getChild("lower_jaw");
            this.neck = this.head.getChild("neck");
            this.v_1 = this.neck.getChild("v_1");
            this.v_2 = this.neck.getChild("v_2");
            this.body = this.absolver.getChild("body");
            this.tail = this.absolver.getChild("tail");
            this.bone = this.tail.getChild("bone");
            this.bone2 = this.bone.getChild("bone2");
            this.bone3 = this.bone2.getChild("bone3");
            this.bone4 = this.bone3.getChild("bone4");
            this.scythe = this.bone4.getChild("scythe");
            this.wings = this.absolver.getChild("wings");
            this.left_wing = this.wings.getChild("left_wing");
            this.bone5 = this.left_wing.getChild("bone5");
            this.bone6 = this.bone5.getChild("bone6");
            this.bone7 = this.bone6.getChild("bone7");
            this.right_wing = this.wings.getChild("right_wing");
            this.bone8 = this.right_wing.getChild("bone8");
            this.bone9 = this.bone8.getChild("bone9");
            this.bone10 = this.bone9.getChild("bone10");

        }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData absolver = modelPartData.addChild("absolver", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = absolver.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -38.3121F, -3.3424F));

        ModelPartData upper_jaw = head.addChild("upper_jaw", ModelPartBuilder.create().uv(24, 67).cuboid(-2.5F, -1.0F, -4.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.1866F, -0.8187F));

        ModelPartData cube_r1 = upper_jaw.addChild("cube_r1", ModelPartBuilder.create().uv(64, 70).cuboid(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.2F, -0.5F, -3.1F, 0.0F, 0.4363F, 0.0F));

        ModelPartData cube_r2 = upper_jaw.addChild("cube_r2", ModelPartBuilder.create().uv(0, 36).cuboid(-0.7F, -0.5F, -0.2F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0987F, -5.3F, -2.8389F, 0.0F, -0.9163F, -1.5708F));

        ModelPartData cube_r3 = upper_jaw.addChild("cube_r3", ModelPartBuilder.create().uv(70, 70).cuboid(-2.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0987F, -5.3F, -2.8389F, 0.0F, -0.4363F, -1.5708F));

        ModelPartData cube_r4 = upper_jaw.addChild("cube_r4", ModelPartBuilder.create().uv(36, 67).cuboid(-2.2F, -1.1013F, -1.3389F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.7F, -0.4F, -3.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r5 = upper_jaw.addChild("cube_r5", ModelPartBuilder.create().uv(34, 69).cuboid(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.5F, -0.5F, -2.05F, 0.0F, -0.9163F, 0.0F));

        ModelPartData cube_r6 = upper_jaw.addChild("cube_r6", ModelPartBuilder.create().uv(6, 70).cuboid(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.2F, -0.5F, -3.1F, 0.0F, -0.4363F, 0.0F));

        ModelPartData cube_r7 = upper_jaw.addChild("cube_r7", ModelPartBuilder.create().uv(26, 69).cuboid(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -0.5F, -2.05F, 0.0F, 0.9163F, 0.0F));

        ModelPartData cube_r8 = upper_jaw.addChild("cube_r8", ModelPartBuilder.create().uv(32, 58).cuboid(-3.2716F, -4.0F, -1.0F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.2716F, 2.4987F, -0.0816F, 0.6109F, 0.0F, 0.0F));

        ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.1866F, 0.8187F));

        ModelPartData cube_r9 = lower_jaw.addChild("cube_r9", ModelPartBuilder.create().uv(64, 60).cuboid(-1.0F, -4.25F, -2.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.1255F, 1.5237F, 0.6109F, 0.0F, 0.0F));

        ModelPartData neck = head.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0988F, 3.4997F));

        ModelPartData v_1 = neck.addChild("v_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.9012F, 0.5003F));

        ModelPartData cube_r10 = v_1.addChild("cube_r10", ModelPartBuilder.create().uv(12, 69).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData v_2 = neck.addChild("v_2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0988F, 0.4997F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r11 = v_2.addChild("cube_r11", ModelPartBuilder.create().uv(20, 69).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.2248F, -0.7071F, 0.1745F, 0.0F, 0.0F));

        ModelPartData body = absolver.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -32.0F, 0.0F));

        ModelPartData cube_r12 = body.addChild("cube_r12", ModelPartBuilder.create().uv(16, 42).cuboid(-1.0F, -3.0F, -1.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r13 = body.addChild("cube_r13", ModelPartBuilder.create().uv(0, 42).cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

        ModelPartData cube_r14 = body.addChild("cube_r14", ModelPartBuilder.create().uv(34, 38).cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

        ModelPartData tail = absolver.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bone = tail.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -20.56F, 2.8434F));

        ModelPartData cube_r15 = bone.addChild("cube_r15", ModelPartBuilder.create().uv(60, 4).cuboid(0.0F, -3.0F, 0.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.56F, -1.6434F, 0.5299F, -0.7119F, -0.3655F));

        ModelPartData bone2 = bone.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.366F, 2.1095F));

        ModelPartData cube_r16 = bone2.addChild("cube_r16", ModelPartBuilder.create().uv(0, 62).cuboid(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5352F, 1.8597F, 0.8262F, -0.5956F, -0.5468F));

        ModelPartData bone3 = bone2.addChild("bone3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.4648F, 3.6403F));

        ModelPartData cube_r17 = bone3.addChild("cube_r17", ModelPartBuilder.create().uv(64, 24).cuboid(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.3372F, 1.5633F, 1.0737F, -0.445F, -0.6707F));

        ModelPartData bone4 = bone3.addChild("bone4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.6628F, 4.4367F));

        ModelPartData cube_r18 = bone4.addChild("cube_r18", ModelPartBuilder.create().uv(64, 32).cuboid(-1.8007F, -0.1512F, -1.8007F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.1787F, -0.6254F, 1.2181F, -0.3326F, -0.7256F));

        ModelPartData scythe = bone4.addChild("scythe", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.1787F, 2.6254F));

        ModelPartData cube_r19 = scythe.addChild("cube_r19", ModelPartBuilder.create().uv(0, 70).cuboid(-0.5F, 0.3F, -1.2F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.9237F, 1.3598F, 2.1307F, 0.2967F, 0.48F, 1.5708F));

        ModelPartData cube_r20 = scythe.addChild("cube_r20", ModelPartBuilder.create().uv(56, 67).cuboid(0.0F, -0.2F, -1.4F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -0.09F, 0.4285F, 0.9599F, 0.48F, 1.5708F));

        ModelPartData cube_r21 = scythe.addChild("cube_r21", ModelPartBuilder.create().uv(16, 60).cuboid(-0.5F, 0.1F, -1.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.6557F, 2.2185F, 3.7802F, -0.3142F, 0.48F, 1.5708F));

        ModelPartData cube_r22 = scythe.addChild("cube_r22", ModelPartBuilder.create().uv(50, 60).cuboid(-0.5F, 0.1F, -1.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.6557F, 2.2185F, 3.7802F, -0.3142F, -0.48F, -1.5708F));

        ModelPartData cube_r23 = scythe.addChild("cube_r23", ModelPartBuilder.create().uv(42, 69).cuboid(-0.5F, 0.3F, -1.2F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.9237F, 1.3598F, 2.1307F, 0.2967F, -0.48F, -1.5708F));

        ModelPartData cube_r24 = scythe.addChild("cube_r24", ModelPartBuilder.create().uv(48, 67).cuboid(-1.0F, -0.2F, -1.4F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -0.09F, 0.4285F, 0.9599F, -0.48F, -1.5708F));

        ModelPartData cube_r25 = scythe.addChild("cube_r25", ModelPartBuilder.create().uv(64, 65).cuboid(-0.5F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0279F, 0.4102F, 1.5708F, -0.48F, -1.5708F));

        ModelPartData wings = absolver.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.0F, 2.0F));

        ModelPartData left_wing = wings.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -2.5565F, 0.0F));

        ModelPartData bone5 = left_wing.addChild("bone5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData cube_r26 = bone5.addChild("cube_r26", ModelPartBuilder.create().uv(50, 47).cuboid(-5.5F, -1.0F, 2.5F, 11.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(50, 56).cuboid(-5.5F, -3.0F, 2.0F, 11.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, -0.4435F, 0.0F, 0.2605F, -0.4595F, -0.5412F));

        ModelPartData bone6 = bone5.addChild("bone6", ModelPartBuilder.create(), ModelTransform.pivot(9.0F, -4.8435F, 4.6F));

        ModelPartData cube_r27 = bone6.addChild("cube_r27", ModelPartBuilder.create().uv(30, 13).cuboid(-2.75F, 1.0F, -1.5F, 15.0F, 13.0F, 0.0F, new Dilation(0.0F))
                .uv(30, 26).cuboid(-2.75F, -1.0F, -2.0F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.3456F, -1.068F, 1.0844F, 0.2337F, -0.0784F, -0.4422F));

        ModelPartData bone7 = bone6.addChild("bone7", ModelPartBuilder.create(), ModelTransform.pivot(12.4827F, -6.2505F, 1.0892F));

        ModelPartData cube_r28 = bone7.addChild("cube_r28", ModelPartBuilder.create().uv(60, 20).cuboid(-3.5F, 0.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(14.9445F, -2.847F, -5.7383F, 0.4607F, -0.0772F, 0.811F));

        ModelPartData cube_r29 = bone7.addChild("cube_r29", ModelPartBuilder.create().uv(0, 18).cuboid(-3.9F, 1.0F, -2.2F, 15.0F, 18.0F, 0.0F, new Dilation(0.0F))
                .uv(30, 34).cuboid(-3.9F, -1.0F, -2.7F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.4026F, -1.445F, 0.2748F, 0.253F, 0.3964F, -0.324F));

        ModelPartData right_wing = wings.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -2.5565F, 0.0F));

        ModelPartData bone8 = right_wing.addChild("bone8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData cube_r30 = bone8.addChild("cube_r30", ModelPartBuilder.create().uv(50, 38).cuboid(-5.5F, -1.0F, 2.5F, 11.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(60, 0).cuboid(-5.5F, -3.0F, 2.0F, 11.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-6.5F, -0.4435F, 0.0F, 0.2605F, 0.4595F, 0.5412F));

        ModelPartData bone9 = bone8.addChild("bone9", ModelPartBuilder.create(), ModelTransform.pivot(-9.0F, -4.8435F, 4.6F));

        ModelPartData cube_r31 = bone9.addChild("cube_r31", ModelPartBuilder.create().uv(30, 0).cuboid(-12.25F, 1.0F, -1.5F, 15.0F, 13.0F, 0.0F, new Dilation(0.0F))
                .uv(30, 30).cuboid(-12.25F, -1.0F, -2.0F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.3456F, -1.068F, 1.0844F, 0.2337F, 0.0784F, 0.4422F));

        ModelPartData bone10 = bone9.addChild("bone10", ModelPartBuilder.create(), ModelTransform.pivot(-12.4827F, -6.2505F, 1.0892F));

        ModelPartData cube_r32 = bone10.addChild("cube_r32", ModelPartBuilder.create().uv(0, 0).cuboid(-11.1F, 1.0F, -2.2F, 15.0F, 18.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 38).cuboid(-11.1F, -1.0F, -2.7F, 15.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.4025F, -1.4451F, 0.2747F, 0.253F, -0.3964F, 0.324F));

        ModelPartData cube_r33 = bone10.addChild("cube_r33", ModelPartBuilder.create().uv(60, 16).cuboid(-3.5F, 0.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-14.9445F, -2.847F, -5.7383F, 0.4607F, 0.0772F, -0.811F));
        return TexturedModelData.of(modelData, 128, 128);
    }

        @Override
        public void setAngles(AbsolverEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);
            this.setHeadAngles(netHeadYaw, headPitch);

//             this.animateMovement(AbsolverAnimations.ANIM_ABSOLVER_IDLE, 1, 1, 1f, 1f);
             //this.animate(AbsolverAnimations.ANIM_ABSOLVER_IDLE);
            this.updateAnimation(entity.idleAnimationState, AbsolverAnimations.ANIM_ABSOLVER_IDLE, ageInTicks, 1f);
            this.updateAnimation(entity.attackAnimationState, AbsolverAnimations.ANIM_ABSOLVER_SHRIEK, ageInTicks, 1f);
            //this.updateAnimation(entity.idleAnimationState, RollyAnimations.ANIM_ROLLY_IDLE, ageInTicks, 1f);
        }

        private void setHeadAngles(float headYaw, float headPitch) {
            headYaw = MathHelper.clamp(headYaw, -15.0F, 15.0F);
            headPitch = MathHelper.clamp(headPitch, -30.0F, 15.0F);

            this.head.yaw = headYaw * 0.017453292F;
            this.head.pitch = headPitch * 0.017453292F;
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            absolver.render(matrices, vertexConsumer, light, overlay, color);
        }

        @Override
        public ModelPart getPart() {
            return absolver;
        }
    }
