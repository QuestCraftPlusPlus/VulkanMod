package net.vulkanmod.mixin.matrix;

import net.minecraft.client.renderer.GameRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public class GameRendererM {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;setOrtho(FFFFFF)Lorg/joml/Matrix4f;"))
    private Matrix4f setOrtho(Matrix4f instance, float left, float right, float bottom, float top, float zNear, float zFar) {

        return instance.setOrtho(left, right, bottom, top, zNear, zFar, true);
    }

    @Redirect(method = "getProjectionMatrix", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;setPerspective(FFFF)Lorg/joml/Matrix4f;"))
    private Matrix4f setPerspective(Matrix4f instance, float fovy, float aspect, float zNear, float zFar) {

        return instance.setPerspective(fovy, aspect, zNear, zFar, true);
    }
}
