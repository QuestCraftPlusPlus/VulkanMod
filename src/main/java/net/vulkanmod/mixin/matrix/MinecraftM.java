package net.vulkanmod.mixin.matrix;

import net.minecraft.client.Minecraft;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public class MinecraftM {

    @Redirect(method = "renderFpsMeter", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;setOrtho(FFFFFF)Lorg/joml/Matrix4f;"))
    private Matrix4f setOrtho(Matrix4f instance, float left, float right, float bottom, float top, float zNear, float zFar) {

        return instance.setOrtho(left, right, bottom, top, zNear, zFar, true);
    }
}
