package net.vulkanmod.mixin.render;

import com.mojang.blaze3d.platform.GlStateManager;
import net.vulkanmod.gl.TextureMap;
import net.vulkanmod.vulkan.texture.VTextureSelector;
import net.vulkanmod.vulkan.texture.VulkanImage;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Mixin(GlStateManager.class)
public class GlStateManagerM {

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _bindTexture(int i) {
        VulkanImage texture = TextureMap.getTexture(i);
        if(texture != null) VTextureSelector.bindTexture(texture);
    }

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _disableScissorTest() {}

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _enableScissorTest() {}

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _scissorBox(int x, int y, int width, int height) {} //TODO: scissor

    //TODO
    /**
     * @author
     */
    @Overwrite(remap = false)
    public static int _getError() {
        return 0;
    }

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _texImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, @Nullable IntBuffer pixels) {
    }

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _texSubImage2D(int target, int level, int offsetX, int offsetY, int width, int height, int format, int type, long pixels) {

    }

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _texParameter(int i, int j, int k) {
        //TODO
    }

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _texParameter(int i, int j, float k) {
        //TODO
    }

    /**
     * @author
     */
    @Overwrite(remap = false)
    public static void _pixelStore(int pname, int param) {

    }

    @Overwrite(remap = false)
    public static void _blendEquation(int i) {

    }

    @Overwrite(remap = false)
    public static void _glUniformMatrix4(int i, boolean bl, FloatBuffer floatBuffer) {

    }

    @Overwrite(remap = false)
    public static void _glUniform4(int i, IntBuffer intBuffer) {

    }

    @Overwrite(remap = false)
    public static void _glUniform4(int i, FloatBuffer floatBuffer) {

    }

    @Overwrite(remap = false)
    public static void _glUseProgram(int i) {

    }

}
