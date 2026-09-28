package net.birchyboii.birchy.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @ModifyConstant(
            method = "isBlocking()Z",
            constant = @Constant(intValue = 5)
    )
    private int RemoveShieldDelay(int original) {
        return 0;
    }
}
