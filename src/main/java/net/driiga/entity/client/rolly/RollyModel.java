package net.driiga.entity.client.rolly;

import net.driiga.DriigaCycles;
import net.driiga.entity.custom.RollyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class RollyModel<T extends RollyEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer ROLLY = new EntityModelLayer(Identifier.of(DriigaCycles.MOD_ID, "rolly"), "main");
// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
        private final ModelPart Rolly;
        public final ModelPart head;

        public RollyModel (ModelPart root) {
            this.Rolly = root.getChild("Rolly");
            this.head = this.Rolly.getChild("head");

        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData Rolly = modelPartData.addChild("Rolly", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            ModelPartData head = Rolly.addChild("head", ModelPartBuilder.create().uv(32, 31).cuboid(-4.0F, -2.0F, -2.0F, 8.0F, 4.0F, 2.0F, new Dilation(0.0F))
                    .uv(16, 44).cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 3.0F, 1.0F, new Dilation(0.0F))
                    .uv(58, 45).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(0, 44).cuboid(-3.0F, -3.0F, -2.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(72, 33).cuboid(-0.5F, -1.4F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F))
                    .uv(48, 58).cuboid(-2.0F, -5.0F, -2.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, -6.0F));

            ModelPartData H_eye_R_7_r1 = head.addChild("H_eye_R_7_r1", ModelPartBuilder.create().uv(52, 76).cuboid(-0.5F, -2.5F, -1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(78, 3).cuboid(0.5F, -2.2F, -1.4F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(68, 77).cuboid(1.5F, -1.7F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(76, 51).cuboid(2.5F, -1.1F, -1.2F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.3F, -0.5F, -2.1F, -0.2443F, 0.4363F, 0.0F));

            ModelPartData H_eye_R_6_r1 = head.addChild("H_eye_R_6_r1", ModelPartBuilder.create().uv(64, 76).cuboid(-0.5F, -1.0F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(76, 61).cuboid(0.5F, -0.6F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(78, 59).cuboid(1.5F, -0.1F, -1.3F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.3F, -0.5F, -2.1F, 0.0611F, 0.4363F, 0.0F));

            ModelPartData H_eye_L_7_r1 = head.addChild("H_eye_L_7_r1", ModelPartBuilder.create().uv(76, 45).cuboid(-0.5F, -2.5F, -1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(72, 77).cuboid(-1.5F, -2.2F, -1.4F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(32, 77).cuboid(-2.5F, -1.7F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(76, 54).cuboid(-3.5F, -1.1F, -1.2F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.3F, -0.5F, -2.1F, -0.2443F, -0.4363F, 0.0F));

            ModelPartData H_eye_L_6_r1 = head.addChild("H_eye_L_6_r1", ModelPartBuilder.create().uv(76, 48).cuboid(-0.5F, -1.0F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(56, 76).cuboid(-1.5F, -0.6F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(0, 79).cuboid(-2.5F, -0.1F, -1.3F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.3F, -0.5F, -2.1F, 0.0611F, -0.4363F, 0.0F));

            ModelPartData H_crown_R_6_r1 = head.addChild("H_crown_R_6_r1", ModelPartBuilder.create().uv(78, 6).cuboid(-1.2F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-2.0836F, -6.1914F, -1.1971F, -0.8247F, 0.4251F, -0.2759F));

            ModelPartData H_crown_R_5_r1 = head.addChild("H_crown_R_5_r1", ModelPartBuilder.create().uv(40, 74).cuboid(-0.8F, -1.3F, -0.1F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-2.0836F, -6.1914F, -1.1971F, -0.8901F, 0.1866F, -0.491F));

            ModelPartData H_crown_R_4_r1 = head.addChild("H_crown_R_4_r1", ModelPartBuilder.create().uv(48, 76).cuboid(0.7F, -3.3F, 1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F))
                    .uv(4, 77).cuboid(0.2F, -1.7F, 0.2F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F))
                    .uv(76, 70).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-1.0F, -2.0F, -4.6F, -0.3054F, 0.0F, -0.6981F));

            ModelPartData H_crown_R_3_r1 = head.addChild("H_crown_R_3_r1", ModelPartBuilder.create().uv(68, 74).cuboid(0.7F, -1.6F, 0.7F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-4.8803F, -4.3878F, -2.666F, -0.9363F, 0.2036F, -0.844F));

            ModelPartData H_crown_R_2_r1 = head.addChild("H_crown_R_2_r1", ModelPartBuilder.create().uv(74, 11).cuboid(0.4F, -2.5F, 0.3F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-2.3F, -3.1F, -4.0F, -0.4854F, -0.0548F, -0.9579F));

            ModelPartData H_crown_L_6_r1 = head.addChild("H_crown_L_6_r1", ModelPartBuilder.create().uv(78, 9).cuboid(0.2F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(2.0836F, -6.1914F, -1.1971F, -0.8247F, -0.4251F, 0.2759F));

            ModelPartData H_crown_L_5_r1 = head.addChild("H_crown_L_5_r1", ModelPartBuilder.create().uv(28, 73).cuboid(-0.2F, -1.3F, -0.1F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(2.0836F, -6.1914F, -1.1971F, -0.8901F, -0.1866F, 0.491F));

            ModelPartData H_crown_L_4_r1 = head.addChild("H_crown_L_4_r1", ModelPartBuilder.create().uv(76, 76).cuboid(-1.7F, -3.3F, 1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F))
                    .uv(76, 67).cuboid(-1.2F, -1.7F, 0.2F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F))
                    .uv(76, 39).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(1.0F, -2.0F, -4.6F, -0.3054F, 0.0F, 0.6981F));

            ModelPartData H_crown_L_3_r1 = head.addChild("H_crown_L_3_r1", ModelPartBuilder.create().uv(76, 0).cuboid(-1.7F, -1.6F, 0.7F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(4.8803F, -4.3878F, -2.666F, -0.9363F, -0.2036F, 0.844F));

            ModelPartData H_crown_L_2_r1 = head.addChild("H_crown_L_2_r1", ModelPartBuilder.create().uv(24, 73).cuboid(-1.4F, -2.5F, 0.3F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(2.3F, -3.1F, -4.0F, -0.4854F, 0.0548F, 0.9579F));

            ModelPartData H_eye_armour_R_7_r1 = head.addChild("H_eye_armour_R_7_r1", ModelPartBuilder.create().uv(76, 73).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-4.8803F, -4.3878F, -2.666F, -0.6325F, -0.1153F, -1.0744F));

            ModelPartData H_eye_armour_R_6_r1 = head.addChild("H_eye_armour_R_6_r1", ModelPartBuilder.create().uv(72, 37).cuboid(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-2.3F, -3.1F, -4.0F, -0.2835F, -0.1153F, -1.0744F));

            ModelPartData H_eye_armour_R_4_r1 = head.addChild("H_eye_armour_R_4_r1", ModelPartBuilder.create().uv(60, 76).cuboid(-0.7F, -1.0F, -0.9F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0207F, -2.5689F, -2.1088F, -0.2386F, 0.6385F, 0.218F));

            ModelPartData H_eye_armour_R_3_r1 = head.addChild("H_eye_armour_R_3_r1", ModelPartBuilder.create().uv(0, 76).cuboid(-0.7F, -1.8F, -1.7F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.3F, -0.5F, -2.1F, 0.1295F, 1.1105F, -0.012F));

            ModelPartData H_eye_armour_R_2_r1 = head.addChild("H_eye_armour_R_2_r1", ModelPartBuilder.create().uv(16, 73).cuboid(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-4.1913F, 0.7604F, -3.15F, -0.4297F, 0.233F, -1.4091F));

            ModelPartData H_eye_armour_R_1_r1 = head.addChild("H_eye_armour_R_1_r1", ModelPartBuilder.create().uv(72, 55).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-2.3F, 0.9F, -4.1F, -0.5236F, 0.0F, -1.8326F));

            ModelPartData H_eye_armour_L_7_r1 = head.addChild("H_eye_armour_L_7_r1", ModelPartBuilder.create().uv(76, 42).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(4.8803F, -4.3878F, -2.666F, -0.6325F, 0.1153F, 1.0744F));

            ModelPartData H_eye_armour_L_6_r1 = head.addChild("H_eye_armour_L_6_r1", ModelPartBuilder.create().uv(36, 72).cuboid(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(2.3F, -3.1F, -4.0F, -0.2835F, 0.1153F, 1.0744F));

            ModelPartData H_eye_armour_L_4_r1 = head.addChild("H_eye_armour_L_4_r1", ModelPartBuilder.create().uv(76, 64).cuboid(-0.3F, -1.0F, -0.9F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0207F, -2.5689F, -2.1088F, -0.2386F, -0.6385F, -0.218F));

            ModelPartData H_eye_armour_L_3_r1 = head.addChild("H_eye_armour_L_3_r1", ModelPartBuilder.create().uv(72, 74).cuboid(-0.3F, -1.8F, -1.7F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.3F, -0.5F, -2.1F, 0.1295F, -1.1105F, 0.012F));

            ModelPartData H_eye_armour_L_2_r1 = head.addChild("H_eye_armour_L_2_r1", ModelPartBuilder.create().uv(72, 51).cuboid(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(4.1913F, 0.7604F, -3.15F, -0.4297F, -0.233F, 1.4091F));

            ModelPartData H_eye_armour_L_1_r1 = head.addChild("H_eye_armour_L_1_r1", ModelPartBuilder.create().uv(72, 41).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(2.3F, 0.9F, -4.1F, -0.5236F, 0.0F, 1.8326F));

            ModelPartData H_armour_ridge_6_r1 = head.addChild("H_armour_ridge_6_r1", ModelPartBuilder.create().uv(44, 76).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 2.1F, -5.0F, 0.0F, 0.0F, 1.5708F));

            ModelPartData H_armour_ridge_5_r1 = head.addChild("H_armour_ridge_5_r1", ModelPartBuilder.create().uv(36, 76).cuboid(0.0F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0001F)), ModelTransform.of(-2.25F, 2.75F, -5.0F, 0.0F, 0.0F, 0.6109F));

            ModelPartData H_armour_ridge_4_r1 = head.addChild("H_armour_ridge_4_r1", ModelPartBuilder.create().uv(76, 33).cuboid(-1.0F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0001F)), ModelTransform.of(2.25F, 2.75F, -5.0F, 0.0F, 0.0F, -0.6109F));

            ModelPartData H_armour_ridge_3_r1 = head.addChild("H_armour_ridge_3_r1", ModelPartBuilder.create().uv(76, 36).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 2.1F, -5.0F, 0.0F, 0.0F, -1.5708F));

            ModelPartData H_armour_ridge_2_r1 = head.addChild("H_armour_ridge_2_r1", ModelPartBuilder.create().uv(20, 73).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, -2.9F, -3.5F, -0.5236F, 0.0F, 0.0F));

            ModelPartData H_armour_2_1_r1 = head.addChild("H_armour_2_1_r1", ModelPartBuilder.create().uv(58, 64).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -1.0F, -1.0F, 0.0F, 0.0F, -0.1309F));

            ModelPartData H_armour_2_2_r1 = head.addChild("H_armour_2_2_r1", ModelPartBuilder.create().uv(46, 64).cuboid(0.0F, -4.5F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -1.0F, -1.0F, 0.0F, 0.0F, -0.6109F));

            ModelPartData H_armour_1_2_r1 = head.addChild("H_armour_1_2_r1", ModelPartBuilder.create().uv(52, 64).cuboid(-1.0F, -4.5F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.6109F));

            ModelPartData H_armour_1_1_r1 = head.addChild("H_armour_1_1_r1", ModelPartBuilder.create().uv(40, 64).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.1309F));

            ModelPartData Whisker_R = head.addChild("Whisker_R", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.0F, 6.0F));

            ModelPartData Seg_1 = Whisker_R.addChild("Seg_1", ModelPartBuilder.create(), ModelTransform.pivot(-0.7742F, -5.5018F, -10.6567F));

            ModelPartData cube_r1 = Seg_1.addChild("cube_r1", ModelPartBuilder.create().uv(64, 30).cuboid(-0.5F, -0.5F, -2.7F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.2201F, -0.3744F, -0.1684F, 0.2454F, 0.7751F, -0.1038F));

            ModelPartData Seg_2 = Whisker_R.addChild("Seg_2", ModelPartBuilder.create(), ModelTransform.pivot(-5.3589F, -5.441F, -12.7664F));

            ModelPartData cube_r2 = Seg_2.addChild("cube_r2", ModelPartBuilder.create().uv(50, 40).cuboid(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.1559F, 0.1185F, 1.1372F, 0.0294F, 0.697F, 0.1032F));

            ModelPartData Seg_3 = Whisker_R.addChild("Seg_3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r3 = Seg_3.addChild("cube_r3", ModelPartBuilder.create().uv(32, 70).cuboid(-2.7F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.531F, -5.0908F, -12.5725F, 0.0233F, 0.2608F, 0.0903F));

            ModelPartData Whisker_L = head.addChild("Whisker_L", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.0F, 6.0F));

            ModelPartData Seg_4 = Whisker_L.addChild("Seg_4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r4 = Seg_4.addChild("cube_r4", ModelPartBuilder.create().uv(64, 34).cuboid(-0.5F, -0.5F, -2.7F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.9942F, -5.8762F, -10.8252F, 0.2454F, -0.7751F, 0.1038F));

            ModelPartData Seg_5 = Whisker_L.addChild("Seg_5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r5 = Seg_5.addChild("cube_r5", ModelPartBuilder.create().uv(64, 38).cuboid(-0.3F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.531F, -5.0908F, -12.5725F, 0.0233F, -0.2608F, -0.0903F));

            ModelPartData Seg_6 = Whisker_L.addChild("Seg_6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r6 = Seg_6.addChild("cube_r6", ModelPartBuilder.create().uv(62, 43).cuboid(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.5149F, -5.3226F, -11.6292F, 0.0294F, -0.697F, -0.1032F));

            ModelPartData body = Rolly.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

            ModelPartData meatandarmour = body.addChild("meatandarmour", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -7.0F, -6.0F, 12.0F, 2.0F, 14.0F, new Dilation(0.0F))
                    .uv(0, 16).cuboid(-5.0F, -10.0F, -6.0F, 10.0F, 3.0F, 12.0F, new Dilation(0.0F))
                    .uv(0, 31).cuboid(-2.0F, -11.0F, -6.0F, 4.0F, 1.0F, 12.0F, new Dilation(0.0F))
                    .uv(52, 34).cuboid(-2.0F, -12.0F, -6.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(40, 52).cuboid(-2.0F, -12.0F, -4.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(52, 52).cuboid(-2.0F, -12.0F, -2.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(0, 53).cuboid(-2.0F, -12.0F, 0.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(12, 54).cuboid(-2.0F, -12.0F, 2.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(24, 55).cuboid(-2.0F, -12.0F, 4.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.0F, 0.0F));

            ModelPartData armour_plate_1_r1 = meatandarmour.addChild("armour_plate_1_r1", ModelPartBuilder.create().uv(52, 0).cuboid(-3.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.25F, -8.5F, 5.75F, 0.0F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r2 = meatandarmour.addChild("armour_plate_1_r2", ModelPartBuilder.create().uv(12, 60).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.5F, 5.0F, 0.0F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r3 = meatandarmour.addChild("armour_plate_1_r3", ModelPartBuilder.create().uv(50, 37).cuboid(-2.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(44, 19).cuboid(-2.4F, -0.7F, -2.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.25F, -8.5F, -4.25F, 0.0F, -0.2618F, 1.0908F));

            ModelPartData armour_plate_1_r4 = meatandarmour.addChild("armour_plate_1_r4", ModelPartBuilder.create().uv(0, 50).cuboid(-2.6F, -0.7F, -2.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(42, 49).cuboid(-3.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.25F, -8.5F, -4.25F, 0.0F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r5 = meatandarmour.addChild("armour_plate_1_r5", ModelPartBuilder.create().uv(36, 58).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.5F, -5.0F, 0.0F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r6 = meatandarmour.addChild("armour_plate_1_r6", ModelPartBuilder.create().uv(0, 47).cuboid(-3.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.25F, -8.5F, 3.75F, 0.0F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r7 = meatandarmour.addChild("armour_plate_1_r7", ModelPartBuilder.create().uv(58, 21).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.5F, 3.0F, 0.0F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r8 = meatandarmour.addChild("armour_plate_1_r8", ModelPartBuilder.create().uv(30, 46).cuboid(-3.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.25F, -8.5F, 1.75F, 0.0F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r9 = meatandarmour.addChild("armour_plate_1_r9", ModelPartBuilder.create().uv(58, 15).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.5F, 1.0F, 0.0F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r10 = meatandarmour.addChild("armour_plate_1_r10", ModelPartBuilder.create().uv(44, 25).cuboid(-3.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.25F, -8.5F, -0.25F, 0.0F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r11 = meatandarmour.addChild("armour_plate_1_r11", ModelPartBuilder.create().uv(56, 49).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.5F, -1.0F, 0.0F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r12 = meatandarmour.addChild("armour_plate_1_r12", ModelPartBuilder.create().uv(48, 55).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.5F, -3.0F, 0.0F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r13 = meatandarmour.addChild("armour_plate_1_r13", ModelPartBuilder.create().uv(44, 16).cuboid(-3.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.25F, -8.5F, -2.25F, 0.0F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r14 = meatandarmour.addChild("armour_plate_1_r14", ModelPartBuilder.create().uv(58, 27).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -10.5F, 5.0F, 0.0F, -0.1309F, 0.3927F));

            ModelPartData armour_plate_1_r15 = meatandarmour.addChild("armour_plate_1_r15", ModelPartBuilder.create().uv(28, 49).cuboid(-2.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.25F, -8.5F, 5.75F, 0.0F, -0.2618F, 1.0908F));

            ModelPartData armour_plate_1_r16 = meatandarmour.addChild("armour_plate_1_r16", ModelPartBuilder.create().uv(24, 58).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -10.5F, 3.0F, 0.0F, -0.1309F, 0.3927F));

            ModelPartData armour_plate_1_r17 = meatandarmour.addChild("armour_plate_1_r17", ModelPartBuilder.create().uv(14, 48).cuboid(-2.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.25F, -8.5F, 3.75F, 0.0F, -0.2618F, 1.0908F));

            ModelPartData armour_plate_1_r18 = meatandarmour.addChild("armour_plate_1_r18", ModelPartBuilder.create().uv(58, 18).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -10.5F, 1.0F, 0.0F, -0.1309F, 0.3927F));

            ModelPartData armour_plate_1_r19 = meatandarmour.addChild("armour_plate_1_r19", ModelPartBuilder.create().uv(44, 46).cuboid(-2.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.25F, -8.5F, 1.75F, 0.0F, -0.2618F, 1.0908F));

            ModelPartData armour_plate_1_r20 = meatandarmour.addChild("armour_plate_1_r20", ModelPartBuilder.create().uv(12, 57).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -10.5F, -1.0F, 0.0F, -0.1309F, 0.3927F));

            ModelPartData armour_plate_1_r21 = meatandarmour.addChild("armour_plate_1_r21", ModelPartBuilder.create().uv(44, 28).cuboid(-2.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.25F, -8.5F, -0.25F, 0.0F, -0.2618F, 1.0908F));

            ModelPartData armour_plate_1_r22 = meatandarmour.addChild("armour_plate_1_r22", ModelPartBuilder.create().uv(0, 56).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -10.5F, -3.0F, 0.0F, -0.1309F, 0.3927F));

            ModelPartData armour_plate_1_r23 = meatandarmour.addChild("armour_plate_1_r23", ModelPartBuilder.create().uv(44, 22).cuboid(-2.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.25F, -8.5F, -2.25F, 0.0F, -0.2618F, 1.0908F));

            ModelPartData armour_plate_1_r24 = meatandarmour.addChild("armour_plate_1_r24", ModelPartBuilder.create().uv(36, 55).cuboid(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -10.5F, -5.0F, 0.0F, -0.1309F, 0.3927F));

            ModelPartData Left_flap_1 = body.addChild("Left_flap_1", ModelPartBuilder.create(), ModelTransform.pivot(6.2919F, 3.5922F, -3.248F));

            ModelPartData cube_r7 = Left_flap_1.addChild("cube_r7", ModelPartBuilder.create().uv(64, 52).cuboid(-1.7F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(76, 57).cuboid(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2919F, 0.4078F, -0.252F, 0.0F, -0.3491F, 0.6981F));

            ModelPartData Left_flap_2 = body.addChild("Left_flap_2", ModelPartBuilder.create(), ModelTransform.pivot(6.2919F, 3.5922F, -1.248F));

            ModelPartData cube_r8 = Left_flap_2.addChild("cube_r8", ModelPartBuilder.create().uv(24, 67).cuboid(-1.7F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(78, 14).cuboid(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2919F, 0.4078F, -0.252F, 0.0F, -0.3491F, 0.6981F));

            ModelPartData Left_flap_3 = body.addChild("Left_flap_3", ModelPartBuilder.create(), ModelTransform.pivot(6.2919F, 3.5922F, 0.752F));

            ModelPartData cube_r9 = Left_flap_3.addChild("cube_r9", ModelPartBuilder.create().uv(68, 48).cuboid(-1.7F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(78, 18).cuboid(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2919F, 0.4078F, -0.252F, 0.0F, -0.3491F, 0.6981F));

            ModelPartData Left_flap_4 = body.addChild("Left_flap_4", ModelPartBuilder.create(), ModelTransform.pivot(6.2919F, 3.5922F, 2.752F));

            ModelPartData cube_r10 = Left_flap_4.addChild("cube_r10", ModelPartBuilder.create().uv(70, 15).cuboid(-1.7F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(78, 22).cuboid(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2919F, 0.4078F, -0.252F, 0.0F, -0.3491F, 0.6981F));

            ModelPartData Left_flap_5 = body.addChild("Left_flap_5", ModelPartBuilder.create(), ModelTransform.pivot(6.2919F, 3.5922F, 4.752F));

            ModelPartData cube_r11 = Left_flap_5.addChild("cube_r11", ModelPartBuilder.create().uv(70, 18).cuboid(-1.7F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(78, 24).cuboid(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2919F, 0.4078F, -0.252F, 0.0F, -0.3491F, 0.6981F));

            ModelPartData Left_flap_6 = body.addChild("Left_flap_6", ModelPartBuilder.create(), ModelTransform.pivot(6.2919F, 3.5922F, 6.752F));

            ModelPartData cube_r12 = Left_flap_6.addChild("cube_r12", ModelPartBuilder.create().uv(70, 21).cuboid(-1.7F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(78, 26).cuboid(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2919F, 0.4078F, -0.252F, 0.0F, -0.3491F, 0.6981F));

            ModelPartData Right_flap_1 = body.addChild("Right_flap_1", ModelPartBuilder.create(), ModelTransform.pivot(-6.2919F, 3.5922F, -3.248F));

            ModelPartData cube_r13 = Right_flap_1.addChild("cube_r13", ModelPartBuilder.create().uv(78, 16).cuboid(-1.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(32, 67).cuboid(-0.3F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2919F, 0.4078F, -0.252F, 0.0F, 0.3491F, -0.6981F));

            ModelPartData Right_flap_2 = body.addChild("Right_flap_2", ModelPartBuilder.create(), ModelTransform.pivot(-6.2919F, 3.5922F, -1.248F));

            ModelPartData cube_r14 = Right_flap_2.addChild("cube_r14", ModelPartBuilder.create().uv(78, 20).cuboid(-1.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(68, 61).cuboid(-0.3F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2919F, 0.4078F, -0.252F, 0.0F, 0.3491F, -0.6981F));

            ModelPartData Right_flap_3 = body.addChild("Right_flap_3", ModelPartBuilder.create(), ModelTransform.pivot(-6.2919F, 3.5922F, 0.752F));

            ModelPartData cube_r15 = Right_flap_3.addChild("cube_r15", ModelPartBuilder.create().uv(66, 12).cuboid(-0.3F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(78, 12).cuboid(-1.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.2919F, 0.4078F, -0.252F, 0.0F, 0.3491F, -0.6981F));

            ModelPartData Right_flap_4 = body.addChild("Right_flap_4", ModelPartBuilder.create(), ModelTransform.pivot(-6.2919F, 3.5922F, 2.752F));

            ModelPartData cube_r16 = Right_flap_4.addChild("cube_r16", ModelPartBuilder.create().uv(78, 28).cuboid(-1.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(24, 70).cuboid(-0.3F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2919F, 0.4078F, -0.252F, 0.0F, 0.3491F, -0.6981F));

            ModelPartData Right_flap_5 = body.addChild("Right_flap_5", ModelPartBuilder.create(), ModelTransform.pivot(-6.2919F, 3.5922F, 4.752F));

            ModelPartData cube_r17 = Right_flap_5.addChild("cube_r17", ModelPartBuilder.create().uv(78, 30).cuboid(-1.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(70, 24).cuboid(-0.3F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2919F, 0.4078F, -0.252F, 0.0F, 0.3491F, -0.6981F));

            ModelPartData Right_flap_6 = body.addChild("Right_flap_6", ModelPartBuilder.create(), ModelTransform.pivot(-6.2919F, 3.5922F, 6.752F));

            ModelPartData cube_r18 = Right_flap_6.addChild("cube_r18", ModelPartBuilder.create().uv(40, 78).cuboid(-1.3F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(70, 27).cuboid(-0.3F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2919F, 0.4078F, -0.252F, 0.0F, 0.3491F, -0.6981F));

            ModelPartData tail = Rolly.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, 8.0F));

            ModelPartData cube_r19 = tail.addChild("cube_r19", ModelPartBuilder.create().uv(30, 64).cuboid(-1.5926F, -0.499F, -2.2525F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0227F, 3.7346F, 5.5696F, -0.3941F, -0.0399F, -0.0053F));

            ModelPartData armour_plate_6_r1 = tail.addChild("armour_plate_6_r1", ModelPartBuilder.create().uv(36, 61).cuboid(0.0F, 0.1814F, -1.3364F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.4F, 1.0F, -0.7777F, 0.1231F, 0.124F));

            ModelPartData cube_r20 = tail.addChild("cube_r20", ModelPartBuilder.create().uv(8, 80).cuboid(0.0F, -0.3F, -0.55F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(62, 74).cuboid(-1.0F, -0.3F, -1.55F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(20, 64).cuboid(-2.0F, -0.3F, -3.55F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.8535F, 4.0283F, 5.862F, -0.414F, -0.3533F, 0.016F));

            ModelPartData cube_r21 = tail.addChild("cube_r21", ModelPartBuilder.create().uv(4, 80).cuboid(0.5F, -0.5F, 1.1F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(56, 74).cuboid(-0.5F, -0.5F, 0.1F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(62, 40).cuboid(-1.5F, -0.5F, -1.9F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.3F, 3.5F, 3.0F, -0.4363F, -0.7418F, 0.0F));

            ModelPartData cube_r22 = tail.addChild("cube_r22", ModelPartBuilder.create().uv(76, 79).cuboid(-1.5F, -0.5F, 1.1F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(72, 59).cuboid(-1.5F, -0.5F, 0.1F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(48, 61).cuboid(-1.5F, -0.5F, -1.9F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.3F, 3.5F, 3.0F, -0.4363F, 0.7418F, 0.0F));

            ModelPartData cube_r23 = tail.addChild("cube_r23", ModelPartBuilder.create().uv(10, 63).cuboid(-1.4074F, -0.499F, -2.2525F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0227F, 3.7346F, 5.5696F, -0.3941F, 0.0399F, 0.0053F));

            ModelPartData cube_r24 = tail.addChild("cube_r24", ModelPartBuilder.create().uv(0, 62).cuboid(-1.0F, -0.3F, -3.55F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(50, 74).cuboid(-1.0F, -0.3F, -1.55F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(80, 0).cuboid(-1.0F, -0.3F, -0.55F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.8535F, 4.0283F, 5.862F, -0.414F, 0.3533F, -0.016F));

            ModelPartData armour_plate_6_r2 = tail.addChild("armour_plate_6_r2", ModelPartBuilder.create().uv(52, 12).cuboid(-2.5F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.3437F, 0.5578F, 1.3949F, -0.7777F, -0.1231F, -0.124F));

            ModelPartData armour_plate_6_r3 = tail.addChild("armour_plate_6_r3", ModelPartBuilder.create().uv(52, 6).cuboid(-2.5F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.3437F, 1.972F, 2.8091F, -0.5137F, -0.242F, -0.1575F));

            ModelPartData armour_plate_6_r4 = tail.addChild("armour_plate_6_r4", ModelPartBuilder.create().uv(24, 61).cuboid(-4.0F, 0.1814F, -1.3364F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.4F, 1.0F, -0.7777F, -0.1231F, -0.124F));

            ModelPartData armour_plate_6_r5 = tail.addChild("armour_plate_6_r5", ModelPartBuilder.create().uv(52, 9).cuboid(-2.5F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.3437F, 1.972F, 2.8091F, -0.5137F, 0.242F, 0.1575F));

            ModelPartData armour_plate_6_r6 = tail.addChild("armour_plate_6_r6", ModelPartBuilder.create().uv(52, 3).cuboid(-2.5F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.3437F, 0.5578F, 1.3949F, -0.7777F, 0.1231F, 0.124F));

            ModelPartData armour_plate_6_r7 = tail.addChild("armour_plate_6_r7", ModelPartBuilder.create().uv(60, 58).cuboid(-2.0F, -1.5F, 0.5F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -3.0F, -0.4712F, 0.0F, 0.0F));

            ModelPartData cube_r25 = tail.addChild("cube_r25", ModelPartBuilder.create().uv(32, 37).cuboid(-3.0F, -2.0F, 2.0F, 6.0F, 2.0F, 3.0F, new Dilation(0.0F))
                    .uv(32, 42).cuboid(-3.0F, -2.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.7F, -3.0F, -0.48F, 0.0F, 0.0F));

            ModelPartData armour_plate_1_r25 = tail.addChild("armour_plate_1_r25", ModelPartBuilder.create().uv(48, 42).cuboid(-3.0F, -0.8F, -1.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.65F, 1.0F, -0.05F, -0.5236F, 0.2618F, -1.0908F));

            ModelPartData armour_plate_1_r26 = tail.addChild("armour_plate_1_r26", ModelPartBuilder.create().uv(58, 24).cuboid(-2.0F, -1.0F, -1.7F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.4F, -1.0F, -0.8F, -0.4363F, 0.1309F, -0.3927F));

            ModelPartData armour_plate_1_r27 = tail.addChild("armour_plate_1_r27", ModelPartBuilder.create().uv(0, 59).cuboid(-2.0F, -1.0F, -1.7F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.4F, -1.0F, -0.8F, -0.4363F, -0.1309F, 0.3927F));

            ModelPartData armour_plate_1_r28 = tail.addChild("armour_plate_1_r28", ModelPartBuilder.create().uv(14, 51).cuboid(-2.0F, -0.8F, -1.5F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.65F, 1.0F, -0.05F, -0.5236F, -0.2618F, 1.0908F));

            ModelPartData legs = Rolly.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData L_1 = legs.addChild("L_1", ModelPartBuilder.create(), ModelTransform.of(2.8929F, -5.0252F, -5.0F, 0.0F, 0.0F, 0.0436F));

            ModelPartData S_1 = L_1.addChild("S_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r26 = S_1.addChild("cube_r26", ModelPartBuilder.create().uv(46, 70).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.2F))
                    .uv(8, 77).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.1071F, 2.0252F, -0.5F, 0.0F, 0.0F, -0.3491F));

            ModelPartData S_2 = L_1.addChild("S_2", ModelPartBuilder.create(), ModelTransform.pivot(1.9121F, 1.8494F, 0.0F));

            ModelPartData cube_r27 = S_2.addChild("cube_r27", ModelPartBuilder.create().uv(0, 65).cuboid(0.0F, -3.0F, 0.3F, 1.0F, 4.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(2.195F, 1.2758F, -1.3F, 0.0F, 0.0F, -1.1345F));

            ModelPartData cube_r28 = S_2.addChild("cube_r28", ModelPartBuilder.create().uv(0, 71).cuboid(0.0F, -3.0F, 0.4F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.195F, 1.8758F, -0.9F, 0.0F, 0.0F, -1.1345F));

            ModelPartData S_3 = L_1.addChild("S_3", ModelPartBuilder.create().uv(36, 79).cuboid(-0.2F, 0.5F, -0.6F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(70, 45).cuboid(-0.2F, -0.5F, -1.1F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.3071F, 3.8252F, 0.1F));

            ModelPartData L_2 = legs.addChild("L_2", ModelPartBuilder.create(), ModelTransform.pivot(2.8929F, -5.0252F, 0.2F));

            ModelPartData S_13 = L_2.addChild("S_13", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r29 = S_13.addChild("cube_r29", ModelPartBuilder.create().uv(52, 70).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.2F))
                    .uv(16, 77).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.1071F, 2.0252F, -0.5F, 0.0F, 0.0F, -0.3491F));

            ModelPartData S_14 = L_2.addChild("S_14", ModelPartBuilder.create(), ModelTransform.pivot(1.9121F, 1.8494F, 0.0F));

            ModelPartData cube_r30 = S_14.addChild("cube_r30", ModelPartBuilder.create().uv(66, 0).cuboid(0.0F, -3.0F, 0.3F, 1.0F, 4.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(2.195F, 1.2758F, -1.3F, 0.0F, 0.0F, -1.1345F));

            ModelPartData cube_r31 = S_14.addChild("cube_r31", ModelPartBuilder.create().uv(4, 72).cuboid(0.0F, -3.0F, 0.4F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.195F, 1.8758F, -0.9F, 0.0F, 0.0F, -1.1345F));

            ModelPartData S_15 = L_2.addChild("S_15", ModelPartBuilder.create().uv(72, 5).cuboid(-0.2F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(48, 79).cuboid(-0.2F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(5.3071F, 3.8252F, 0.0F));

            ModelPartData L_3 = legs.addChild("L_3", ModelPartBuilder.create(), ModelTransform.pivot(2.8929F, -5.0252F, 5.4333F));

            ModelPartData S_16 = L_3.addChild("S_16", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.0333F));

            ModelPartData cube_r32 = S_16.addChild("cube_r32", ModelPartBuilder.create().uv(64, 70).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.2F))
                    .uv(24, 77).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.1071F, 2.0252F, -0.5F, 0.0F, 0.0F, -0.3491F));

            ModelPartData S_17 = L_3.addChild("S_17", ModelPartBuilder.create(), ModelTransform.pivot(1.9121F, 1.8494F, -0.0333F));

            ModelPartData cube_r33 = S_17.addChild("cube_r33", ModelPartBuilder.create().uv(66, 6).cuboid(0.0F, -3.0F, 0.3F, 1.0F, 4.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(2.195F, 1.2758F, -1.3F, 0.0F, 0.0F, -1.1345F));

            ModelPartData cube_r34 = S_17.addChild("cube_r34", ModelPartBuilder.create().uv(12, 72).cuboid(0.0F, -3.0F, 0.4F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.195F, 1.8758F, -0.9F, 0.0F, 0.0F, -1.1345F));

            ModelPartData S_18 = L_3.addChild("S_18", ModelPartBuilder.create().uv(72, 30).cuboid(-0.2F, -0.5F, -1.1F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(56, 79).cuboid(-0.2F, 0.5F, -0.6F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(5.3071F, 3.8252F, 0.0667F));

            ModelPartData R_1 = legs.addChild("R_1", ModelPartBuilder.create(), ModelTransform.pivot(-2.8929F, -5.0252F, -5.0F));

            ModelPartData S_4 = R_1.addChild("S_4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r35 = S_4.addChild("cube_r35", ModelPartBuilder.create().uv(28, 77).cuboid(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(70, 64).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.2F)), ModelTransform.of(-1.1071F, 2.0252F, -0.5F, 0.0F, 0.0F, 0.3491F));

            ModelPartData S_5 = R_1.addChild("S_5", ModelPartBuilder.create(), ModelTransform.pivot(-1.9121F, 1.8494F, 0.0F));

            ModelPartData cube_r36 = S_5.addChild("cube_r36", ModelPartBuilder.create().uv(32, 72).cuboid(-1.0F, -3.0F, 0.4F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.195F, 1.8758F, -0.9F, 0.0F, 0.0F, 1.1345F));

            ModelPartData cube_r37 = S_5.addChild("cube_r37", ModelPartBuilder.create().uv(12, 66).cuboid(-1.0F, -3.0F, 0.3F, 1.0F, 4.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(-2.195F, 1.2758F, -1.3F, 0.0F, 0.0F, 1.1345F));

            ModelPartData S_6 = R_1.addChild("S_6", ModelPartBuilder.create().uv(60, 79).cuboid(-0.8F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(70, 68).cuboid(-0.8F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.3071F, 3.8252F, 0.0F));

            ModelPartData R_2 = legs.addChild("R_2", ModelPartBuilder.create(), ModelTransform.pivot(-2.8929F, -5.0252F, 0.2F));

            ModelPartData S_7 = R_2.addChild("S_7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r38 = S_7.addChild("cube_r38", ModelPartBuilder.create().uv(40, 70).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.2F))
                    .uv(12, 77).cuboid(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.1071F, 2.0252F, -0.5F, 0.0F, 0.0F, 0.3491F));

            ModelPartData S_8 = R_2.addChild("S_8", ModelPartBuilder.create(), ModelTransform.pivot(-1.9121F, 1.8494F, 0.0F));

            ModelPartData cube_r39 = S_8.addChild("cube_r39", ModelPartBuilder.create().uv(64, 64).cuboid(-1.0F, -3.0F, 0.3F, 1.0F, 4.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(-2.195F, 1.2758F, -1.3F, 0.0F, 0.0F, 1.1345F));

            ModelPartData cube_r40 = S_8.addChild("cube_r40", ModelPartBuilder.create().uv(72, 0).cuboid(-1.0F, -3.0F, 0.4F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.195F, 1.8758F, -0.9F, 0.0F, 0.0F, 1.1345F));

            ModelPartData S_9 = R_2.addChild("S_9", ModelPartBuilder.create().uv(70, 71).cuboid(-0.8F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(44, 79).cuboid(-0.8F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.3071F, 3.8252F, 0.0F));

            ModelPartData R_3 = legs.addChild("R_3", ModelPartBuilder.create(), ModelTransform.pivot(-2.8929F, -5.0252F, 5.4F));

            ModelPartData S_10 = R_3.addChild("S_10", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r41 = S_10.addChild("cube_r41", ModelPartBuilder.create().uv(20, 77).cuboid(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(58, 70).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.2F)), ModelTransform.of(-1.1071F, 2.0252F, -0.5F, 0.0F, 0.0F, 0.3491F));

            ModelPartData S_11 = R_3.addChild("S_11", ModelPartBuilder.create(), ModelTransform.pivot(-1.9121F, 1.8494F, 0.0F));

            ModelPartData cube_r42 = S_11.addChild("cube_r42", ModelPartBuilder.create().uv(8, 72).cuboid(-1.0F, -3.0F, 0.4F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.195F, 1.8758F, -0.9F, 0.0F, 0.0F, 1.1345F));

            ModelPartData cube_r43 = S_11.addChild("cube_r43", ModelPartBuilder.create().uv(6, 66).cuboid(-1.0F, -3.0F, 0.3F, 1.0F, 4.0F, 2.0F, new Dilation(0.1F)), ModelTransform.of(-2.195F, 1.2758F, -1.3F, 0.0F, 0.0F, 1.1345F));

            ModelPartData S_12 = R_3.addChild("S_12", ModelPartBuilder.create().uv(52, 79).cuboid(-0.8F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(72, 8).cuboid(-0.8F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.3071F, 3.8252F, 0.0F));
            return TexturedModelData.of(modelData, 128, 128);
        }
    @Override
    public void setAngles(RollyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(RollyAnimations.ANIM_ROLLY_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, RollyAnimations.ANIM_ROLLY_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -15.0F, 15.0F);
        headPitch = MathHelper.clamp(headPitch, -30.0F, 15.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            Rolly.render(matrices, vertexConsumer, light, overlay, color);
        }

    @Override
    public ModelPart getPart() {
        return Rolly;
    }
}

