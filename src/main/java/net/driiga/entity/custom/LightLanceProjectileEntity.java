package net.driiga.entity.custom;

import net.driiga.entity.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.driiga.DriigaCycles.MOD_ID;

public class LightLanceProjectileEntity extends ExplosiveProjectileEntity {

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private static final TrackedData<Boolean> CHARGED;

    public LightLanceProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightLanceProjectileEntity(World world, LivingEntity owner, Vec3d velocity) {
        super(ModEntities.LIGHT_LANCE, owner, velocity, world);
    }

    protected float getDrag() {
        return this.isCharged() ? 0.73F : super.getDrag();
    }

    public boolean isOnFire() {
        return false;
    }

    public float getEffectiveExplosionResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState, float max) {
        return this.isCharged() && AbsolverEntity.canDestroy(blockState) ? Math.min(0.8F, max) : max;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        World var3 = this.getWorld();
        if (var3 instanceof ServerWorld serverWorld) {
            Entity var8 = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            boolean bl;
            if (entity2 instanceof LivingEntity livingEntity) {
                DamageSource damageSource = this.getDamageSources().mobProjectile(this, livingEntity);
                bl = var8.damage(damageSource, 8.0F);
                if (bl) {
                    if (var8.isAlive()) {
                        EnchantmentHelper.onTargetDamaged(serverWorld, var8, damageSource);
                    } else {
                        livingEntity.heal(5.0F);
                    }
                }
            } else {
                bl = var8.damage(this.getDamageSources().magic(), 5.0F);
            }

            if (bl && var8 instanceof LivingEntity livingEntity) {
                int i = 0;
                if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
                    i = 40;
                }

                if (i > 0) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * i, 1), this.getEffectCause());
                }
            }

        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.MOB);
            this.discard();
        }

    }

    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(CHARGED, false);
    }

    public boolean isCharged() {
        return (Boolean)this.dataTracker.get(CHARGED);
    }

    public void setCharged(boolean charged) {
        this.dataTracker.set(CHARGED, charged);
    }

    protected boolean isBurning() {
        return false;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("dangerous", this.isCharged());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setCharged(nbt.getBoolean("dangerous"));
    }

    static {
        CHARGED = DataTracker.registerData(LightLanceProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        //LOGGER.info(" my owner is " + this.getOwner());
        if (this.getOwner() == null)
        {
            //LOGGER.info(" discarding myself :< ");
            this.discard();
        }
//        else {
//
//            this.setVelocity(this.getOwner().getVelocity());
//        }



    }
}
