package net.driiga.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


import java.util.EnumSet;

public class AbsolverEntity extends FlyingEntity implements Monster {
    private static final TrackedData<Boolean> SHOOTING;
    private int fireballStrength = 1;

    public AbsolverEntity(EntityType<? extends AbsolverEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
        this.moveControl = new AbsolverMoveControl(this);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new FlyRandomlyGoal(this));
        this.goalSelector.add(7, new LookAtTargetGoal(this));
        this.goalSelector.add(7, new ShootFireballGoal(this));
        //this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, 10, true, false, (entity) -> Math.abs(entity.getY() - this.getY()) <= (double)4.0F));
    }

    public boolean isShooting() {
        return (Boolean)this.dataTracker.get(SHOOTING);
    }

    public void setShooting(boolean shooting) {
        this.dataTracker.set(SHOOTING, shooting);
    }

    public int getFireballStrength() {
        return this.fireballStrength;
    }

    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    private static boolean isFireballFromPlayer(DamageSource damageSource) {
        return damageSource.getSource() instanceof FireballEntity && damageSource.getAttacker() instanceof PlayerEntity;
    }

    public boolean isInvulnerableTo(DamageSource damageSource) {
        return this.isInvulnerable() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) || !isFireballFromPlayer(damageSource) && super.isInvulnerableTo(damageSource);
    }

    public boolean damage(DamageSource source, float amount) {
        if (isFireballFromPlayer(source)) {
            super.damage(source, 1000.0F);
            return true;
        } else {
            return this.isInvulnerableTo(source) ? false : super.damage(source, amount);
        }
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SHOOTING, false);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, (double)10.0F).add(EntityAttributes.GENERIC_FOLLOW_RANGE, (double)100.0F);
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GHAST_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GHAST_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

    protected float getSoundVolume() {
        return 5.0F;
    }

    public static boolean canSpawn(EntityType<AbsolverEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getDifficulty() != Difficulty.PEACEFUL && random.nextInt(20) == 0 && canMobSpawn(type, world, spawnReason, pos, random);
    }

    public int getLimitPerChunk() {
        return 1;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("ExplosionPower", (byte)this.fireballStrength);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("ExplosionPower", 99)) {
            this.fireballStrength = nbt.getByte("ExplosionPower");
        }

    }

    static {
        SHOOTING = DataTracker.registerData(AbsolverEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

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

            for(int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.absolver.getWorld().isSpaceEmpty(this.absolver, box)) {
                    return false;
                }
            }

            return true;
        }
    }

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
                return g < (double)1.0F || g > (double)3600.0F;
            }
        }

        public boolean shouldContinue() {
            return false;
        }

        public void start() {
            Random random = this.absolver.getRandom();
            double d = this.absolver.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double e = this.absolver.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double f = this.absolver.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.absolver.getMoveControl().moveTo(d, e, f, (double)1.0F);
        }
    }

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
                this.absolver.setYaw(-((float)MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float)Math.PI));
                this.absolver.bodyYaw = this.absolver.getYaw();
            } else {
                LivingEntity livingEntity = this.absolver.getTarget();
                double d = (double)64.0F;
                if (livingEntity.squaredDistanceTo(this.absolver) < (double)4096.0F) {
                    double e = livingEntity.getX() - this.absolver.getX();
                    double f = livingEntity.getZ() - this.absolver.getZ();
                    this.absolver.setYaw(-((float)MathHelper.atan2(e, f)) * (180F / (float)Math.PI));
                    this.absolver.bodyYaw = this.absolver.getYaw();
                }
            }

        }
    }

    static class ShootFireballGoal extends Goal {
        private final AbsolverEntity absolver;
        public int cooldown;

        public ShootFireballGoal(AbsolverEntity absolver) {
            this.absolver = absolver;
        }

        public boolean canStart() {
            return this.absolver.getTarget() != null;
        }

        public void start() {
            this.cooldown = 0;
        }

        public void stop() {
            this.absolver.setShooting(false);
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingEntity = this.absolver.getTarget();
            if (livingEntity != null) {
                double d = (double)64.0F;
                if (livingEntity.squaredDistanceTo(this.absolver) < (double)4096.0F && this.absolver.canSee(livingEntity)) {
                    World world = this.absolver.getWorld();
                    ++this.cooldown;
                    if (this.cooldown == 10 && !this.absolver.isSilent()) {
                        world.syncWorldEvent((PlayerEntity)null, 1015, this.absolver.getBlockPos(), 0);
                    }

                    if (this.cooldown == 20) {
                        double e = (double)4.0F;
                        Vec3d vec3d = this.absolver.getRotationVec(1.0F);
                        double f = livingEntity.getX() - (this.absolver.getX() + vec3d.x * (double)4.0F);
                        double g = livingEntity.getBodyY((double)0.5F) - ((double)0.5F + this.absolver.getBodyY((double)0.5F));
                        double h = livingEntity.getZ() - (this.absolver.getZ() + vec3d.z * (double)4.0F);
                        Vec3d vec3d2 = new Vec3d(f, g, h);
                        if (!this.absolver.isSilent()) {
                            world.syncWorldEvent((PlayerEntity)null, 1016, this.absolver.getBlockPos(), 0);
                        }

                        FireballEntity fireballEntity = new FireballEntity(world, this.absolver, vec3d2.normalize(), this.absolver.getFireballStrength());
                        fireballEntity.setPosition(this.absolver.getX() + vec3d.x * (double)4.0F, this.absolver.getBodyY((double)0.5F) + (double)0.5F, fireballEntity.getZ() + vec3d.z * (double)4.0F);
                        world.spawnEntity(fireballEntity);
                        this.cooldown = -40;
                    }
                } else if (this.cooldown > 0) {
                    --this.cooldown;
                }

                this.absolver.setShooting(this.cooldown > 10);
            }
        }
    }
}
