package net.sabio.rpgcraft.mixin.client;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Camera.class, remap = false)
public class CameraMixin {
    @Shadow(remap = false)
    private Vec3 position;

    @Shadow(remap = false)
    protected void setRotation(float yRot, float xRot) {}

    @Shadow(remap = false)
    protected void setPosition(Vec3 position) {}

    @Inject(method = "update", at = @At("TAIL"), remap = false) // this is valid tf
    private void onUpdate(DeltaTracker deltaTracker, CallbackInfo ci) {
        setRotation(0.0f, 90.0f);
        setPosition(new Vec3(position.x, position.y + 10.0, position.z));
    }
}