package net.vulkanmod.mixin.matrix;

import net.minecraft.client.renderer.CubeMap;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CubeMap.class)
public class CubeMapM {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;setPerspective(FFFF)Lorg/joml/Matrix4f;"))
    private Matrix4f setPerspective(Matrix4f instance, float fovy, float aspect, float zNear, float zFar) {

        return instance.setPerspective(fovy, aspect, zNear, zFar, true);
    }
}
