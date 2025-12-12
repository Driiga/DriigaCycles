package net.driiga.entity.ai.control;

import net.driiga.entity.custom.AbsolverEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class AbsolverMoveControl extends MoveControl {

    private int collisionCheckCooldown;


    public AbsolverMoveControl(MobEntity entity) {
        super(entity);
    }

    public void tick() {
        if (this.state == State.MOVE_TO) {
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.entity.getRandom().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.targetX - this.entity.getX(), this.targetY - this.entity.getY(), this.targetZ - this.entity.getZ());
                double d = vec3d.length();
                vec3d = vec3d.normalize();
                if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                    this.entity.setVelocity(this.entity.getVelocity().add(vec3d.multiply(0.1)));
                } else {
                    this.state = State.WAIT;
                }
            }

        }
    }

    private boolean willCollide(Vec3d direction, int steps) {
        Box box = this.entity.getBoundingBox();

        for(int i = 1; i < steps; ++i) {
            box = box.offset(direction);
            if (!this.entity.getWorld().isSpaceEmpty(this.entity, box)) {
                return false;
            }
        }

        return true;
    }
        }


//    public void tick() {
//        if (this.state == MoveControl.State.MOVE_TO) {
//            //this.state = MoveControl.State.WAIT;
//            this.entity.setNoGravity(true);
//            double d = this.targetX - this.entity.getX();
//            double e = this.targetY - this.entity.getY();
//            double f = this.targetZ - this.entity.getZ();
//            double g = d * d + e * e + f * f;
//            if (g < (double) 2.5000003E-7F) {
//                this.entity.setUpwardSpeed(0.0F);
////                this.entity.setForwardSpeed(0.0F);
//                return;
//            }
//
//            float h = (float) (MathHelper.atan2(f, d) * (double) (180F / (float) Math.PI)) - 90.0F;
//            this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), h, 90.0F));
////            float i;
////            if (this.entity.isOnGround()) {
////                i = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
////            } else {
////                i = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED));
////            }
//
//            //this.entity.setMovementSpeed(i);
//
//            this.entity.setVelocity(this.entity.getVelocity().add(new Vec3d(d,e,f).multiply(0.1)));
////            double j = Math.sqrt(d * d + f * f);
////            if (Math.abs(e) > (double) 1.0E-5F || Math.abs(j) > (double) 1.0E-5F) {
////                float k = (float) (-(MathHelper.atan2(e, j) * (double) (180F / (float) Math.PI)));
////                this.entity.setPitch(this.wrapDegrees(this.entity.getPitch(), k, (float) this.maxPitchChange));
////                this.entity.setUpwardSpeed(e > (double) 0.0F ? i : -i);
////            }
//        } else {
//            if (!this.noGravity) {
//                this.entity.setNoGravity(false);
//            }
//
////            this.entity.setUpwardSpeed(0.0F);
////            this.entity.setForwardSpeed(0.0F);
//        }
//
//    }



//    public void tick () {
//        this.state = State.MOVE_TO;
//
//        // vector pointing to target
//        Vec3d distance = new Vec3d(this.targetX - entity.getX(), this.targetY - entity.getY(), this.targetZ - entity.getZ());
//        if(distance.lengthSquared() < 2.5000003E-7F) {
//            entity.setForwardSpeed(0.0F);
//            return;
//        }
//
//        // yaw
//        float yaw = (float) (MathHelper.atan2(distance.z, distance.x) * 180.0F / (float) Math.PI) - 90.0F;
//        entity.setYaw(this.wrapDegrees(entity.getYaw(), yaw, /*bird.getMaxYawChange()*/25));
//        entity.bodyYaw = entity.getYaw();
//        entity.headYaw = entity.getYaw();
//
//        // speed
//        float speed = (float) entity.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED) * entity.speed;
//        BlockPos destination;
//        // decelerate when landing
//        if((destination = entity.getNavigation().getTargetPos()) != null
//                && AbsolverEntity.shouldLandAtDestination(entity, destination)
//        ) {
//            double dist = entity.distanceToSqr(Vec3.atBottomCenterOf(destination));
//            if(dist < DECELERATE_DISTANCE * DECELERATE_DISTANCE) {
//                speed *= (float) decelerate(dist);
//            }
//        }
//        entity.setMovementSpeed(speed);
//        double lateralDistance = distance.horizontalLength();
//
//        // pitch
//        if(Math.abs(distance.length()) > 1.0E-5F) {
//            float pitch = -(float) (MathHelper.atan2(distance.y, lateralDistance) * 180.0F / Math.PI);
//            pitch = MathHelper.clamp(MathHelper.wrapDegrees(pitch), -entity.getMaxLookPitchChange(), entity.getMaxLookPitchChange());
//            entity.setPitch(this.wrapDegrees(entity.getPitch(), pitch, /*bird.getMaxPitchChange()*/25));
//        }
//
//        // pitch to movement
//        float x = MathHelper.cos(entity.getPitch() * (float) (Math.PI / 180.0));
//        float y = MathHelper.sin(entity.getPitch() * (float) (Math.PI / 180.0));
//        entity.forwardSpeed = x * speed;
//        entity.upwardSpeed = -y * speed;
//    }


