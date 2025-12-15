package net.driiga.entity.custom;

import com.google.common.collect.ImmutableList;
import net.driiga.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

import static net.driiga.DriigaCycles.MOD_ID;


public class AbsolverEntity extends FlyingEntity implements RangedAttackMob {
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;
//    private static final TrackedData<Integer> TRACKED_ENTITY_ID_1;
    private int blockBreakingCooldown;
//    private static final Predicate<LivingEntity> CAN_ATTACK_PREDICATE;
//    private static final TargetPredicate HEAD_TARGET_PREDICATE;

    //Lances
    private static final TrackedData<Integer> TRACKED_LANCE_ID_1;
    private static final TrackedData<Integer> TRACKED_LANCE_ID_2;
    private static final TrackedData<Integer> TRACKED_LANCE_ID_3;
    private static final TrackedData<Integer> TRACKED_LANCE_ID_4;
    private static final TrackedData<Integer> TRACKED_LANCE_ID_5;
    private static final List<TrackedData<Integer>> TRACKED_LANCES_IDS;
    private static final TrackedData<Boolean> HAS_LANCES;
    private static final TrackedData<Boolean> SHOOOTING;
    private int lancesSummonCooldown = 20;
    private int lancesShootCooldown = -60;

    /// создание моба

    public AbsolverEntity(EntityType<? extends AbsolverEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new AbsolverMoveControl(this);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, (double) 0.6F);
    }

    /// прочие настройки моба

    public static boolean canDestroy(BlockState block) {
        return !block.isAir() && !block.isIn(BlockTags.WITHER_IMMUNE);
    }

//    public int getTrackedEntityId() {
//        return (Integer) this.dataTracker.get(TRACKED_ENTITY_ID_1);
//    }
//
//    public void setTrackedEntityId(int id) {
//        this.dataTracker.set(TRACKED_ENTITY_ID_1, id);
//    }

    public int getTrackedLancesId(int lanceIndex) {
        return (Integer) this.dataTracker.get((TrackedData) TRACKED_LANCES_IDS.get(lanceIndex));
    }

    public void setTrackedLancesId(int lanceIndex, int id) {
        this.dataTracker.set((TrackedData) TRACKED_LANCES_IDS.get(lanceIndex), id);
    }

    public boolean getLanceStatus() {
        return (Boolean) this.dataTracker.get(HAS_LANCES);
    }

    public void setLanceStatus(boolean has_lances) {
        this.dataTracker.set(HAS_LANCES, has_lances);
    }

    public boolean getShootingStatus() {
        return (Boolean) this.dataTracker.get(SHOOOTING);
    }

    public void setShootingStatus(boolean is_shooting) {
        this.dataTracker.set(SHOOOTING, is_shooting);
    }

    private void summonHaloOfLances() {

        double X = this.getX();
        double Y = this.getY();
        double Z = this.getZ();

        Vec3d vec3d1 = new Vec3d(this.getFacing().getUnitVector().rotateY(-40)).multiply(2);
        Vec3d vec3d2 = new Vec3d(this.getFacing().getUnitVector().rotateY(-20)).multiply(2);
        Vec3d vec3d3 = new Vec3d(this.getFacing().getUnitVector().rotateY(0)).multiply(2);
        Vec3d vec3d4 = new Vec3d(this.getFacing().getUnitVector().rotateY(20)).multiply(2);
        Vec3d vec3d5 = new Vec3d(this.getFacing().getUnitVector().rotateY(40)).multiply(2);

        Vec3d[] vecArray = {vec3d1, vec3d2, vec3d3, vec3d4, vec3d5};

        for (int i = 0; i < 5; i++) {
            LightLanceProjectileEntity LightLanceProjectileEntity = new LightLanceProjectileEntity(this.getWorld(), this, new Vec3d(0, 0, 0));
            LightLanceProjectileEntity.setOwner(this);

            LightLanceProjectileEntity.setPos(X + vecArray[i].x, Y + vecArray[i].y + 6, Z + vecArray[i].z);
            this.getWorld().spawnEntity(LightLanceProjectileEntity);
            this.setTrackedLancesId(i, LightLanceProjectileEntity.getId());
        }
        this.setLanceStatus(true);
    }


    private void shootLancesAt(LivingEntity target) {
        this.shootLancesAt(target.getX(), (target.getY() + (double) target.getStandingEyeHeight() * (double) 0.5F), target.getZ());
    }

    private void shootLancesAt(double targetX, double targetY, double targetZ) {

        this.setLanceStatus(false);

        for (int i = 0; i < 5; i++) {

            Entity lance = this.getWorld().getEntityById(getTrackedLancesId(i));

            if (lance != null) {
                double X = lance.getX();
                double Y = lance.getY();
                double Z = lance.getZ();
                double tX = targetX - X - this.random.nextBetweenExclusive(0, 3);
                double tY = targetY - Y - this.random.nextBetweenExclusive(0, 1);
                double tZ = targetZ - Z - this.random.nextBetweenExclusive(0, 3);
                Vec3d vec3d = new Vec3d(tX, tY, tZ);


                getWorld().getEntityById(getTrackedLancesId(i)).setVelocity(vec3d.normalize());

            }
        }
    }

    public void shootAt(LivingEntity target, float pullProgress) {
        this.shootLancesAt(target);
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
//        builder.add(TRACKED_ENTITY_ID_1, 0);
        builder.add(HAS_LANCES, false);
        builder.add(SHOOOTING, false);
        builder.add(TRACKED_LANCE_ID_1, 0);
        builder.add(TRACKED_LANCE_ID_2, 0);
        builder.add(TRACKED_LANCE_ID_3, 0);
        builder.add(TRACKED_LANCE_ID_4, 0);
        builder.add(TRACKED_LANCE_ID_5, 0);
    }

    static {
//        TRACKED_ENTITY_ID_1 = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.INTEGER);
//        CAN_ATTACK_PREDICATE = (entity) -> !entity.getType().isIn(ModTags.Entity.ABSOLVER_FRIENDS) && entity.isMobOrPlayer();
////        CAN_ATTACK_PREDICATE = (entity) -> Math.abs(entity.getY() - this.getY()) <= (double)4.0F;
//        HEAD_TARGET_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance((double) 20F).setPredicate(CAN_ATTACK_PREDICATE);
        HAS_LANCES = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        SHOOOTING = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        TRACKED_LANCE_ID_1 = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.INTEGER);
        TRACKED_LANCE_ID_2 = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.INTEGER);
        TRACKED_LANCE_ID_3 = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.INTEGER);
        TRACKED_LANCE_ID_4 = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.INTEGER);
        TRACKED_LANCE_ID_5 = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.INTEGER);
        TRACKED_LANCES_IDS = ImmutableList.of(TRACKED_LANCE_ID_1, TRACKED_LANCE_ID_2, TRACKED_LANCE_ID_3, TRACKED_LANCE_ID_4, TRACKED_LANCE_ID_5);
    }

    /// поведение

    protected void initGoals() {
        this.goalSelector.add(5, new FlyRandomlyGoal(this));
        this.goalSelector.add(1, new LookAtTargetGoal(this));
        this.goalSelector.add(7, new LookAroundGoal(this));
//        this.goalSelector.add(4, new GuideLances(this));
//        this.goalSelector.add(3, new ShootLanceslGoal(this));
        this.targetSelector.add(3, new FindTargetGoal());
//        this.targetSelector.add(2, new ActiveTargetGoal(this, LivingEntity.class, 0, false, false, CAN_ATTACK_PREDICATE));
    }

    /// анимации

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0 && this.getLanceStatus()) {
            //this.attackAnimationState.stop();
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

//        if (this.getShootingStatus()) {
//            this.setShootingStatus(false);
//            this.idleAnimationState.stop();
//            this.attackAnimationTimeout = 20;
//            this.attackAnimationState.start(this.age);
//        } else {
//            --this.attackAnimationTimeout;
//        }
    }


    /// передвижение

    static class AbsolverMoveControl extends MoveControl {
        private final AbsolverEntity absolver;
        private int collisionCheckCooldown;

        public AbsolverMoveControl(AbsolverEntity absolver) {
            super(absolver);
            this.absolver = absolver;
        }

        public void tick() {
            if (this.state == State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.absolver.getRandom().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.targetX - this.absolver.getX(), this.targetY - this.absolver.getY(), this.targetZ - this.absolver.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                        this.absolver.setVelocity(this.absolver.getVelocity().add(vec3d.multiply(0.1)));
                    } else {
                        this.state = State.WAIT;
                    }
                }

            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.absolver.getBoundingBox();

            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.absolver.getWorld().isSpaceEmpty(this.absolver, box)) {
                    return false;
                }
            }

            return true;
        }
    }


    /// --------------------------------------- ///

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
        LOGGER.info("attack anim cd: " + this.attackAnimationTimeout);
        LOGGER.info("get shooting " + this.getShootingStatus());
    }

    public void mobTick() {
        super.mobTick();

        this.lancesShootCooldown++;
        this.lancesSummonCooldown++;
//        this.attackAnimationTimeout++;
//        if (this.attackAnimationTimeout >= 20) {
//            this.attackAnimationState.stop();
//            //this.idleAnimationState.start(this.age);
//        }
        //LOGGER.info(" ---- ");

        if (this.getLanceStatus() == false) {
            if (this.lancesSummonCooldown > 80) {
                this.lancesSummonCooldown = 0 + this.random.nextInt(10);
                this.summonHaloOfLances();

            }

        } else { //has Lances


            Vec3d vec3d1 = new Vec3d(this.getFacing().getUnitVector().rotateY(-40)).multiply(2);
            Vec3d vec3d2 = new Vec3d(this.getFacing().getUnitVector().rotateY(-20)).multiply(2);
            Vec3d vec3d3 = new Vec3d(this.getFacing().getUnitVector().rotateY(0)).multiply(2);
            Vec3d vec3d4 = new Vec3d(this.getFacing().getUnitVector().rotateY(20)).multiply(2);
            Vec3d vec3d5 = new Vec3d(this.getFacing().getUnitVector().rotateY(40)).multiply(2);

            Vec3d[] vecArray = {vec3d1, vec3d2, vec3d3, vec3d4, vec3d5};

            for (int i = 0; i < 5; i++) {
                Entity lance = this.getWorld().getEntityById(getTrackedLancesId(i));
                if (lance != null) {
                    Vec3d vec3d6 = new Vec3d(lance.getVelocity().toVector3f());
                    Vec3d vec3d7 = new Vec3d(this.getX() + vecArray[i].x - lance.getX(), this.getY() + 5 - lance.getY(), this.getZ() + vecArray[i].z - lance.getZ()).multiply(0.4);
                    Vec3d vec3d8 = new Vec3d(vec3d6.toVector3f().add(vec3d7.toVector3f()));
                    //Vec3d vec3d9 = new Vec3d(this.getX() + vecArray[i].x - lance.getX(), this.getY() + 5 - lance.getY(), this.getZ() + vecArray[i].z - lance.getZ());
                    lance.setVelocity(vec3d8.multiply(0.1));
                }

            }


            if (this.lancesShootCooldown > 40) {
//                int j = this.getTrackedEntityId();
                if (this.getTarget() != null) {
                    LivingEntity livingEntity = (LivingEntity) this.getTarget();
                    if (livingEntity != null && this.canTarget(livingEntity) && !(this.squaredDistanceTo(livingEntity) > (double) 900.0F) && this.canSee(livingEntity)) {
                        this.setLanceStatus(false);
                        //this.setShootingStatus(true);
//                        this.idleAnimationState.stop();
//                        this.attackAnimationState.start(this.age);
//                        this.attackAnimationTimeout = 0;
                        this.getWorld().playSound(this, this.getBlockPos(), ModSounds.ABSOLVER_SHRIEK, SoundCategory.HOSTILE, 30f, 1f);
                            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.NAUSEA, 200, 5);
                            List<ServerPlayerEntity> list = StatusEffectUtil.addEffectToPlayersWithinDistance((ServerWorld)this.getWorld(), this, this.getPos(), (double)50.0F, statusEffectInstance, 1200);
                            //list.forEach((serverPlayerEntity) -> serverPlayerEntity.networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.ELDER_GUARDIAN_EFFECT, this.isSilent() ? 0.0F : 1.0F)));

                        this.shootLancesAt(livingEntity);


//                        this.setGuideStatus(true);
                        this.lancesShootCooldown = 0 + this.random.nextInt(10);
                    } else {
//                        this.setTrackedEntityId(0);
                    }
                } else {
//                    List<LivingEntity> list = this.getWorld().getTargets(LivingEntity.class, HEAD_TARGET_PREDICATE, this, this.getBoundingBox().expand((double) 20.0F, (double) 8.0F, (double) 20.0F));
//                    if (!list.isEmpty()) {
//                        LivingEntity livingEntity2 = (LivingEntity) list.get(this.random.nextInt(list.size()));
//                        this.setTrackedEntityId(livingEntity2.getId());
//                        //this.setTarget(livingEntity2);
//                    }
                }
            }
        }


//        if (this.getTarget() != null) {
//            this.setTrackedEntityId(this.getTarget().getId());
//        } else {
//            this.setTrackedEntityId(0);
//        }

        if (this.blockBreakingCooldown > 0) {
            --this.blockBreakingCooldown;
            if (this.blockBreakingCooldown == 0 && this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                boolean bl = false;
                int j = MathHelper.floor(this.getWidth() / 2.0F + 1.0F);
                int k = MathHelper.floor(this.getHeight());

                for (BlockPos blockPos : BlockPos.iterate(this.getBlockX() - j, this.getBlockY(), this.getBlockZ() - j, this.getBlockX() + j, this.getBlockY() + k, this.getBlockZ() + j)) {
                    BlockState blockState = this.getWorld().getBlockState(blockPos);
                    if (canDestroy(blockState)) {
                        bl = this.getWorld().breakBlock(blockPos, true, this) || bl;
                    }
                }

                if (bl) {
                    this.getWorld().syncWorldEvent((PlayerEntity) null, 1022, this.getBlockPos(), 0);
                }
            }
        }
    }

    /// --------------------------------------- ///

    static class FlyRandomlyGoal extends Goal {
        private final AbsolverEntity absolver;

        public FlyRandomlyGoal(AbsolverEntity absolver) {
            this.absolver = absolver;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            MoveControl moveControl = this.absolver.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            } else {
                double d = moveControl.getTargetX() - this.absolver.getX();
                double e = moveControl.getTargetY() - this.absolver.getY();
                double f = moveControl.getTargetZ() - this.absolver.getZ();
                double g = d * d + e * e + f * f;
                return g < (double) 1.0F || g > (double) 3600.0F;
            }
        }

        public boolean shouldContinue() {
            return false;
        }

        public void start() {
            if (this.absolver.getTarget() == null) {
                Random random = this.absolver.getRandom();
                double d = this.absolver.getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double e = this.absolver.getY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 14.0F);
                double f = this.absolver.getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.absolver.getMoveControl().moveTo(d, e, f, (double) 1.0F);
            } else {
                Random random = this.absolver.getRandom();
                double d = this.absolver.getTarget().getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double e = this.absolver.getTarget().getY() + (double) ((random.nextBetween(5, 10)));
                double f = this.absolver.getTarget().getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.absolver.getMoveControl().moveTo(d, e, f, (double) 1.0F);
            }
        }
    }

    /// --------------------------------------- ///

    static class LookAtTargetGoal extends Goal {
        private final AbsolverEntity absolver;

        public LookAtTargetGoal(AbsolverEntity absolver) {
            this.absolver = absolver;
            this.setControls(EnumSet.of(Control.LOOK));
        }

        public boolean canStart() {
            return true;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            if (this.absolver.getTarget() == null) {
                Vec3d vec3d = this.absolver.getVelocity();
                this.absolver.setYaw(-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float) Math.PI));
                this.absolver.bodyYaw = this.absolver.getYaw();
            } else {
                LivingEntity livingEntity = this.absolver.getTarget();
                double d = (double) 64.0F;
                if (livingEntity.squaredDistanceTo(this.absolver) < (double) 4096.0F) {
                    double e = livingEntity.getX() - this.absolver.getX();
                    double f = livingEntity.getZ() - this.absolver.getZ();
                    this.absolver.setYaw(-((float) MathHelper.atan2(e, f)) * (180F / (float) Math.PI));
                    this.absolver.bodyYaw = this.absolver.getYaw();
                }
            }

        }

    }

    /// --------------------------------------- ///

        class FindTargetGoal extends Goal {
            private final TargetPredicate PLAYERS_IN_RANGE_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance((double)100.0F);
            private int delay = toGoalTicks(20);

            public boolean canStart() {
                if (this.delay > 0) {
                    --this.delay;
                    return false;
                } else {
                    this.delay = toGoalTicks(60);
                    List<PlayerEntity> list = AbsolverEntity.this.getWorld().getPlayers(this.PLAYERS_IN_RANGE_PREDICATE, AbsolverEntity.this, AbsolverEntity.this.getBoundingBox().expand((double)30.0F, (double)100.0F, (double)30.0F));
                    if (!list.isEmpty()) {
                        list.sort(Comparator.comparing(Entity::getY).reversed());

                        for(PlayerEntity playerEntity : list) {
                            if (AbsolverEntity.this.isTarget(playerEntity, TargetPredicate.DEFAULT)) {
                                AbsolverEntity.this.setTarget(playerEntity);
                                return true;
                            }
                        }
                    }

                    return false;
                }
            }

            public boolean shouldContinue() {
                LivingEntity livingEntity = AbsolverEntity.this.getTarget();
                return livingEntity != null ? AbsolverEntity.this.isTarget(livingEntity, TargetPredicate.DEFAULT) : false;
            }
        }

    /// --------------------------------------- ///

    }













