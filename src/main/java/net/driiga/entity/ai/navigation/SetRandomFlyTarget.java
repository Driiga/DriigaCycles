package net.driiga.entity.ai.navigation;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.object.SquareRadius;
import net.tslat.smartbrainlib.util.BrainUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SetRandomFlyTarget<E extends PathAwareEntity> extends ExtendedBehaviour<E> {
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(1).noMemory(MemoryModuleType.WALK_TARGET);

    protected BiFunction<E, Vec3d, Float> speedModifier = (entity, targetPos) -> 1f;
    protected Predicate<E> avoidWaterPredicate = entity -> true;
    protected SquareRadius radius = new SquareRadius(10, 7);
    protected BiPredicate<E, Vec3d> positionPredicate = (entity, pos) -> true;

    /**
     * Set the radius in which to look for walk positions.
     * @param radius The coordinate radius, in blocks
     * @return this
     */
    public SetRandomFlyTarget<E> setRadius(double radius) {
        return setRadius(radius, radius);
    }

    /**
     * Set the radius in which to look for walk positions.
     * @param xz The X/Z coordinate radius, in blocks
     * @param y The Y coordinate radius, in blocks
     * @return this
     */
    public SetRandomFlyTarget<E> setRadius(double xz, double y) {
        this.radius = new SquareRadius(xz, y);

        return this;
    }

    /**
     * Set the movespeed modifier for the path when chosen.
     * @param modifier The movespeed modifier/multiplier
     * @return this
     */
    public SetRandomFlyTarget<E> speedModifier(float modifier) {
        return speedModifier((entity, targetPos) -> modifier);
    }

    /**
     * Set the movespeed modifier for the path when chosen.
     * @param function The movespeed modifier/multiplier function
     * @return this
     */
    public SetRandomFlyTarget<E> speedModifier(BiFunction<E, Vec3d, Float> function) {
        this.speedModifier = function;

        return this;
    }

    /**
     * Sets a predicate to check whether the target movement position is valid or not
     * @param predicate The predicate
     * @return this
     */
    public SetRandomFlyTarget<E> walkTargetPredicate(BiPredicate<E, Vec3d> predicate) {
        this.positionPredicate = predicate;

        return this;
    }

    /**
     * Sets the behaviour to allow finding of positions that might be in water. <br>
     * Useful for hybrid or water-based entities.
     * @return this
     */
    public SetRandomFlyTarget<E> dontAvoidWater() {
        return avoidWaterWhen(entity -> false);
    }

    /**
     * Set the predicate to determine when the entity should avoid water walk targets;
     * @param predicate The predicate
     * @return this
     */
    public SetRandomFlyTarget<E> avoidWaterWhen(Predicate<E> predicate) {
        this.avoidWaterPredicate = predicate;

        return this;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryModuleState>> getMemoryRequirements() {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected void start(E entity) {
        Vec3d targetPos = getTargetPos(entity);

        if (!this.positionPredicate.test(entity, targetPos))
            targetPos = null;

        if (targetPos == null) {
            BrainUtils.clearMemory(entity, MemoryModuleType.WALK_TARGET);
        }
        else {
            BrainUtils.setMemory(entity, MemoryModuleType.WALK_TARGET, new WalkTarget(targetPos, this.speedModifier.apply(entity, targetPos), 0));
        }
    }

    @Nullable
    protected Vec3d getTargetPos(E entity) {
        if (this.avoidWaterPredicate.test(entity)) {
            return FuzzyTargeting.find(entity, (int)this.radius.xzRadius(), (int)this.radius.yRadius());
        }
        else {
            double a = entity.getX() + (double)((entity.getRandom().nextFloat() * 2.0F - 1.0F) * 16.0F);
            double b = entity.getY() + (double)((entity.getRandom().nextFloat() * 2.0F - 1.0F) * 16.0F);
            double c = entity.getZ() + (double)((entity.getRandom().nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3d(a,b,c);
        }
    }
}