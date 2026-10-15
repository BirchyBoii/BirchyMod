package net.birchyboii.birchy.entity.ai.goal;

import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class CustomRangeWanderAroundFarGoal extends WanderAroundFarGoal {
    public static final float CHANCE = 0.001F;
    protected final float probability;
    protected final int horizontalRange;
    protected final int verticalRange;

    public CustomRangeWanderAroundFarGoal(PathAwareEntity pathAwareEntity, double d, int horizontalRange, int verticalRange) {
        this(pathAwareEntity, d, 0.001F, horizontalRange, verticalRange);
    }

    public CustomRangeWanderAroundFarGoal(PathAwareEntity mob, double speed, float probability, int horizontalRange, int verticalRange) {
        super(mob, speed);
        this.probability = probability;
        this.horizontalRange = horizontalRange;
        this.verticalRange = verticalRange;
    }

    @Nullable
    @Override
    protected Vec3d getWanderTarget() {
        if (this.mob.isTouchingWater()) {
            Vec3d vec3d = FuzzyTargeting.find(this.mob, horizontalRange, verticalRange);
            return vec3d == null ? super.getWanderTarget() : vec3d;
        } else {
            return this.mob.getRandom().nextFloat() >= this.probability ? FuzzyTargeting.find(this.mob, horizontalRange-5, verticalRange) : super.getWanderTarget();
        }
    }

}
