package net.driiga.temporaryClass;

import com.google.common.collect.ImmutableSet;
import net.driiga.DriigaCycles;
import net.driiga.entity.ai.control.AbsolverMoveControl;
import net.driiga.entity.ai.navigation.FlightNavigation;

import net.driiga.entity.custom.CustomFlyingEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.EntityLookTarget;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.BirdPathNodeMaker;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.DebugInfoSender;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetPlayerLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.navigation.ExtendedNavigator;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;
import net.tslat.smartbrainlib.util.BrainUtils;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class StorageClass {

//    public class FlightNavigation extends EntityNavigation implements ExtendedNavigator {
//        private static final int NODE_DISTANCE = 4;
//        private static final float NODE_REACH_RADIUS = 0.5f;
//        private final CustomFlyingEntity flyingentity;
//
//        public FlightNavigation(CustomFlyingEntity flyingentity, World world) {
//            super(flyingentity, world);
//            this.flyingentity = flyingentity;
//        }
//
//        @Override
//        public MobEntity getMob() {
//            return this.flyingentity;
//        }
//
//
//        @Override
//        public @Nullable Path getCurrentPath() {
//            return super.getCurrentPath();
//        }
//
//
//        @Override
//        protected PathNodeNavigator createPathNodeNavigator(int range) {
//            this.nodeMaker = new BirdPathNodeMaker();
//            this.nodeMaker.setCanOpenDoors(true);
//
//            return this.createSmoothPathFinder(this.nodeMaker, range);
//        }
//
////    @Override
////    protected PathFinder createPathFinder(int maxVisitedNodes) {
////        this.nodeEvaluator = new FlyNodeEvaluator();
////        this.nodeEvaluator.setCanPassDoors(true);
////
////        return this.createSmoothPathFinder(this.nodeEvaluator, maxVisitedNodes);
////    }
//
//        @Nullable
//        @Override
//        public Path patchPath(@Nullable Path path) {
//            Path newPath = ExtendedNavigator.super.patchPath(path);
//            if(newPath == null) {
//                return null;
//            }
////        // noinspection ConstantConditions
////        Path.DebugNodeInfo debugNodeInfo = path.getDebugNodeInfos();
////        if(debugNodeInfo != null) {
////            newPath.setDebugInfo (debugNodeInfo.openSet(), debugNodeInfo.closedSet(), debugNodeInfo.targetNodes());
////        }
//            return newPath;
//        }
//
//        @Override
//        public boolean startMovingTo(double x, double y, double z, double speed) {
//            this.flyingentity.getMoveControl().moveTo(x, y, z, speed);
//            return true;
//        }
//
//        @Override
//        public boolean startMovingTo(Entity entity, double speed) {
//            this.flyingentity.getMoveControl().moveTo(entity.getX(), entity.getY(), entity.getZ(), speed);
//            return true;
//        }
//
//        @Override
//        protected boolean canPathDirectlyThrough(Vec3d origin, Vec3d target) {
//
//            return doesNotCollide(this.flyingentity, origin, target, true);
//        }
//
//        @Override
//        protected boolean isAtValidPosition() {
//            return this.canSwim() && this.flyingentity.isInFluid() || !this.flyingentity.hasVehicle();
//        }
//
//        @Override
//        protected Vec3d getPos() {
//            return this.getMob().getPos();
//        }
//
//        @Override
//        protected double adjustTargetY(Vec3d pos) {
//            return pos.y;
//        }
//
//        @Override
//        public Path findPathTo(BlockPos target, int distance) {
//            return this.findPathTo(ImmutableSet.of(target), distance);
//        }
//
////    @Override
////    public Path findPathTo(BlockPos target, int distance) {
////        return this.findPathTo(ImmutableSet.of(target), 16, false, distance, 64);
////    }
//
//        @Override
//        public void tick() {
//            ++this.tickCount;
//            if(this.inRecalculationCooldown) {
//                this.recalculatePath();
//            }
//
//            if(!this.isIdle()) {
//                if(this.isAtValidPosition()) {
//                    this.continueFollowingPath();
//                }
//                else if(this.currentPath != null && !this.currentPath.isFinished()) {
//                    Vec3d pos = this.getPos();
//                    Vec3d nodePos = this.currentPath.getNodePosition(this.flyingentity);
//                    if(pos.y > nodePos.y
//                            && !this.flyingentity.isOnGround()
//                            && MathHelper.floor(pos.x) == MathHelper.floor(nodePos.x)
//                            && MathHelper.floor(pos.z) == MathHelper.floor(nodePos.z)) {
//                        this.currentPath.next();
//                    }
//                }
////            if(this.currentPath != null
////                    && this.currentPath.isFinished()
////                    && this.getTargetPos() != null
////                    && this.flyingentity.getPos().isInRange(this.getTargetPos().toBottomCenterPos(), 2)
////                    //&& AbsolverEntity.shouldLandAtDestination(this.flyingentity, this.getTargetPos())
////            ) {
////                this.flyingentity.stopFlying();
////            }
//
//                DebugInfoSender.sendPathfindingData(this.world, this.getMob(), this.getCurrentPath(), 0.1f);
//                if(!this.isIdle()) {
//                    Vec3d vec3d = this.currentPath.getNodePosition(this.flyingentity);
//                    this.flyingentity.getMoveControl().moveTo(vec3d.x, vec3d.y, vec3d.z, this.speed);
//                }
//            }
//        }
//
//        @Override
//        public Vec3d getEntityPosAtNode(int nodeIndex) {
//            return Vec3d.ofBottomCenter(this.getCurrentPath().getNodePos(nodeIndex));
//        }
//
//        @Override
//        protected void continueFollowingPath() {
//            final Vec3d pos = this.getPos();
//            final int shortcutNodeIndex = this.getClosestVerticalTraversal(MathHelper.floor(pos.y));
//            this.nodeReachProximity = this.flyingentity.getWidth() > 0.75f ? this.flyingentity.getWidth() / 2f : 0.75f - this.flyingentity.getWidth() / 2f;
//
//            if(!this.attemptShortcut(shortcutNodeIndex, pos)) {
//                if(this.isCloseToNextNode(NODE_REACH_RADIUS)) {
//                    int nextNodeIndex = this.currentPath.getCurrentNodeIndex() + NODE_DISTANCE;
//                    if(this.currentPath.getCurrentNodeIndex() < this.currentPath.getLength() - 1 && nextNodeIndex >= this.currentPath.getLength()) {
//                        this.currentPath.setCurrentNodeIndex(this.currentPath.getLength() - 1);
//                    }
//                    else {
//                        this.currentPath.setCurrentNodeIndex(nextNodeIndex);
//                    }
//                }
//            }
//
//            this.checkTimeouts(pos);
//        }
//
//        @Override
//        public boolean isCloseToNextNode(float distance) {
//            final Vec3d nextNodePos = this.getEntityPosAtNode(this.getCurrentPath().getCurrentNodeIndex());
//
//            if(this.currentPath.getCurrentNodeIndex() + 1 >= this.currentPath.getLength()
//                //&& Birds.shouldLandAtDestination(this.flyingentity, this.getTargetPos())
//            ) {
//                return this.getPos().isInRange(nextNodePos, 0.5);
//            }
//            return this.getPos().isInRange(nextNodePos, distance);
//        }
//
//        protected int getClosestVerticalTraversal(int safeSurfaceHeight) {
//            final int nodesLength = this.currentPath.getLength();
//
//            for(int nodeIndex = this.currentPath.getCurrentNodeIndex(); nodeIndex < nodesLength; nodeIndex++) {
//                if(this.currentPath.getNode(nodeIndex).y != safeSurfaceHeight) {
//                    return nodeIndex;
//                }
//            }
//
//            return nodesLength;
//        }
//
//        @Override
//        public float getNodeReachProximity() {
//            return NODE_REACH_RADIUS;
//        }
//
//        @Override
//        public boolean isValidPosition(BlockPos pos) {
//            return true;
//        }
//    }

    //////////////////////////////////

//    public class AbsolverEntity extends PathAwareEntity implements SmartBrainOwner<net.driiga.entity.custom.AbsolverEntity> {
//        public final AnimationState idleAnimationState = new AnimationState();
//        private int idleAnimationTimeout = 0;
//
//        protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
//        }
//
//        protected EntityNavigation createNavigation(World world) {
//            FlightNavigation flightNavigation = new FlightNavigation(this, world);
//            flightNavigation.setCanPathThroughDoors(false);
//            flightNavigation.setCanSwim(true);
//            flightNavigation.setCanEnterOpenDoors(true);
//            return flightNavigation;
//        }
//
//        @Override
//        protected boolean isDisallowedInPeaceful() {
//            return false;
//        }
//
//        public AbsolverEntity(EntityType<? extends net.driiga.entity.custom.AbsolverEntity> entityType, World world) {
//            super(entityType, world);
//            this.moveControl = this.createMoveControl();
//        }
//
//        protected MoveControl createMoveControl() {
//            return new AbsolverMoveControl(this, 10,false);
//        }
//
//        public static boolean shouldLandAtDestination(net.driiga.entity.custom.AbsolverEntity absolver, BlockPos destination) {
//            World world = absolver.getWorld();
//            return !world.getBlockState(destination).isAir()
//                    || !world.getBlockState(destination.down()).isAir()
//                    || !world.getFluidState(destination).isEmpty()
//                    || !world.getFluidState(destination.down()).isEmpty();
//        }
//
//        protected Brain.Profile<net.driiga.entity.custom.AbsolverEntity> createBrainProfile() {
//            return new SmartBrainProvider<>(this);
//        }
//
//        public  Brain.Profile<?> brainProvider() {
//            return new SmartBrainProvider<>(this);
//        }
//
//        public static DefaultAttributeContainer.Builder createAttributes() {
//            return MobEntity.createMobAttributes()
//                    .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
//                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
//                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
//                    .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
//                    .add(EntityAttributes.GENERIC_FLYING_SPEED, (double)0.4F);
//        }
//
//        // brains below
//
//        @Override
//        protected final void initGoals() {}
////    // Let's make sure we're definitely not using any goals
//
//        // Add our sensors - these handle passively detecting and remembering nearby environmental factors
//        @Override
//        public List<? extends ExtendedSensor<? extends net.driiga.entity.custom.AbsolverEntity>> getSensors() {
//            return List.of(
//                    new NearbyPlayersSensor<net.driiga.entity.custom.AbsolverEntity>()
//                            .setRadius(20, 60)
//                            //this bit is needed to clear the Absolver's look target when the player leaves detection range
//                            //otherwise once the mob sees the player, it keeps staring down the player indefinetly no matter the distance
//                            .afterScanning(entity -> {
//                                PlayerEntity player = BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_PLAYER);
//                                Object target = BrainUtils.getMemory(entity, MemoryModuleType.LOOK_TARGET);
//                                if (target instanceof EntityLookTarget && ((EntityLookTarget) target).getEntity() instanceof PlayerEntity && player == null) {
//                                    BrainUtils.clearMemory(entity, MemoryModuleType.LOOK_TARGET);
//                                } else if (player != null) {
//                                    BrainUtils.setMemory(entity, MemoryModuleType.LOOK_TARGET, new EntityLookTarget(player, false));
//                                }
//                            })
//            );
//        }
//
//        // Add our core tasks - this group runs every tick regardless of any other activities the skeleton may be running
//        @Override
//        public BrainActivityGroup<? extends net.driiga.entity.custom.AbsolverEntity> getCoreTasks() {
//            return BrainActivityGroup.coreTasks(
//                    new LookAtTarget<>()
//                            .runFor(entity -> 10),
//                    new MoveToWalkTarget<>()
//                            .runFor(entity -> 100)// Move to the current walk target
//            );
//        }
//
//        // Add our idle tasks - this group runs automatically if no other activites are running (such as fighting)
//        @Override
//        public BrainActivityGroup<? extends net.driiga.entity.custom.AbsolverEntity> getIdleTasks() {
//            return BrainActivityGroup.idleTasks(
//                    new FirstApplicableBehaviour<net.driiga.entity.custom.AbsolverEntity>(
//                            new SetPlayerLookTarget<>(),
//                            new SetRandomLookTarget<>()
//                    ),
//                    new OneRandomBehaviour<>( // Run only one of the below behaviours, picked at random
//                            new SetRandomWalkTarget<>()
//                                    .setRadius(30, 30),// Set the walk target to a nearby random pathable location
//                            new Idle<>() // Don't do anything for a bit
//                                    .runFor(entity -> entity.getRandom().nextBetweenExclusive(10, 20))
//                    )
//            );
//        }
//
//        // Add our fight tasks - this group only runs when the skeleton has a target to attack, as dictated by TargetOrRetaliate
//        @Override
//        public BrainActivityGroup<? extends net.driiga.entity.custom.AbsolverEntity> getFightTasks() {
//            return BrainActivityGroup.fightTasks();
//        }
//
//        @Override
//        protected void mobTick() {
//            tickBrain(this);
//            DriigaCycles.LOGGER.info("Absolver's walk target is:");
//            super.mobTick();
//        }
//
//    }
//
////BrainUtils.getMemory(this, MemoryModuleType.WALK_TARGET

/// ////////////

//public class AbsolverEntity extends FlyingEntity {
//    public final AnimationState idleAnimationState = new AnimationState();
//    private int idleAnimationTimeout = 0;
//
//    public AbsolverEntity(EntityType<? extends AbsolverEntity> entityType, World world) {
//        super(entityType, world);
//        this.moveControl = this.createMoveControl();
//    }
//
//    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
//    }
//
//    @Override
//    protected boolean isDisallowedInPeaceful() {
//        return false;
//    }
//
//
//    protected MoveControl createMoveControl() {
//        return new AbsolverMoveControl(this, 10,false);
//    }
//
//    public static DefaultAttributeContainer.Builder createAttributes() {
//        return MobEntity.createMobAttributes()
//                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
//                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
//                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
//                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
//                .add(EntityAttributes.GENERIC_FLYING_SPEED, (double)0.4F);
//    }
//
//    // brains below
//
//    protected void initGoals() {
//        this.goalSelector.add(5, new FlyRandomlyGoal(this));
//        this.goalSelector.add(7, new LookAtTargetGoal(this));
//        //this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, 10, true, false, );
//    }
//
//    static class FlyRandomlyGoal extends Goal {
//        private final AbsolverEntity absolver;
//
//        public FlyRandomlyGoal(AbsolverEntity absolver) {
//            this.absolver = absolver;
//            this.setControls(EnumSet.of(Control.MOVE));
//        }
//
//        public boolean canStart() {
//            MoveControl moveControl = this.absolver.getMoveControl();
//            if (!moveControl.isMoving()) {
//                return true;
//            } else {
//                double d = moveControl.getTargetX() - this.absolver.getX();
//                double e = moveControl.getTargetY() - this.absolver.getY();
//                double f = moveControl.getTargetZ() - this.absolver.getZ();
//                double g = d * d + e * e + f * f;
//                return g < (double)1.0F || g > (double)3600.0F;
//            }
//        }
//
//        public boolean shouldContinue() {
//            return false;
//        }
//
//        public void start() {
//            Random random = this.absolver.getRandom();
//            double d = this.absolver.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
//            double e = this.absolver.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
//            double f = this.absolver.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
//            this.absolver.getMoveControl().moveTo(d, e, f, (double)1.0F);
//        }
//    }
//
//    static class LookAtTargetGoal extends Goal {
//        private final AbsolverEntity absolver;
//
//        public LookAtTargetGoal(AbsolverEntity absolver) {
//            this.absolver = absolver;
//            this.setControls(EnumSet.of(Control.LOOK));
//        }
//
//        public boolean canStart() {
//            return true;
//        }
//
//        public boolean shouldRunEveryTick() {
//            return true;
//        }
//
//        public void tick() {
//            if (this.absolver.getTarget() == null) {
//                Vec3d vec3d = this.absolver.getVelocity();
//                this.absolver.setYaw(-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float)Math.PI));
//                this.absolver.bodyYaw = this.absolver.getYaw();
//            } else {
//                LivingEntity livingEntity = this.absolver.getTarget();
//                double d = (double)64.0F;
//                if (livingEntity.squaredDistanceTo(this.absolver) < (double)4096.0F) {
//                    double e = livingEntity.getX() - this.absolver.getX();
//                    double f = livingEntity.getZ() - this.absolver.getZ();
//                    this.absolver.setYaw(-((float)MathHelper.atan2(e, f)) * (180F / (float)Math.PI));
//                    this.absolver.bodyYaw = this.absolver.getYaw();
//                }
//            }
//
//        }
//    }

}
