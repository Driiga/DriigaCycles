package net.driiga.entity.custom;

import net.driiga.entity.ai.navigation.FlightNavigation;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomFlyingEntity extends PathAwareEntity {

    protected MoveControl moveControl;
    private boolean isFlightNavigation;
    protected CustomFlyingEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new MoveControl(this);
        //this.lookControl = new BirdLookControl(this, 85);
        //this.setNavigation(true);

    }

    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }
//    public void setNavigation(boolean isFlying) {
//        if (isFlying) {
//            this.navigation = this.getFlightNavigation();
//            this.isFlightNavigation = true;
//        } else {
//            //this.navigation = this.getLandNavigation();
//            this.isFlightNavigation = false;
//        }
//    }

    protected EntityNavigation createNavigation(World world) {
        FlightNavigation flightNavigation = new FlightNavigation(this, world);
        flightNavigation.setCanPathThroughDoors(false);
        flightNavigation.setCanSwim(true);
        flightNavigation.setCanEnterOpenDoors(true);
        return flightNavigation;
    }


//    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
//    }
//
//    public void travel(Vec3d movementInput) {
//        if (this.isLogicalSideForUpdatingMovement()) {
//            if (this.isTouchingWater()) {
//                this.updateVelocity(0.02F, movementInput);
//                this.move(MovementType.SELF, this.getVelocity());
//                this.setVelocity(this.getVelocity().multiply((double)0.8F));
//            } else if (this.isInLava()) {
//                this.updateVelocity(0.02F, movementInput);
//                this.move(MovementType.SELF, this.getVelocity());
//                this.setVelocity(this.getVelocity().multiply((double)0.5F));
//            } else {
//                float f = 0.91F;
//                if (this.isOnGround()) {
//                    f = this.getWorld().getBlockState(this.getVelocityAffectingPos()).getBlock().getSlipperiness() * 0.91F;
//                }
//
//                float g = 0.16277137F / (f * f * f);
//                f = 0.91F;
//                if (this.isOnGround()) {
//                    f = this.getWorld().getBlockState(this.getVelocityAffectingPos()).getBlock().getSlipperiness() * 0.91F;
//                }
//
//                this.updateVelocity(this.isOnGround() ? 0.1F * g : 0.02F, movementInput);
//                this.move(MovementType.SELF, this.getVelocity());
//                this.setVelocity(this.getVelocity().multiply((double) f));
//            }
//        }
//
//        this.updateLimbs(false);
//    }
//
//    public boolean isClimbing() {
//        return false;
//    }
}
