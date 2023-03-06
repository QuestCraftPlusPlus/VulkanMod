package net.vulkanmod.mixin.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.vulkanmod.gl.TextureMap;
import net.vulkanmod.vulkan.texture.VTextureSelector;
import net.vulkanmod.vulkan.texture.VulkanImage;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.List;

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
    public static void _pixelStore(int pname, int param) {}

    @Overwrite(remap = false)
    public static void _blendEquation(int i) {}

    @Overwrite(remap = false)
    public static void _glUniformMatrix4(int i, boolean bl, FloatBuffer floatBuffer) {}

    @Overwrite(remap = false)
    public static void _glUniform4(int i, IntBuffer intBuffer) {}

    @Overwrite(remap = false)
    public static void _glUniform4(int i, FloatBuffer floatBuffer) {}

    @Overwrite(remap = false)
    public static void _glUseProgram(int i) {}

    @Overwrite(remap = false)
    public static void _enableBlend() {}

    @Overwrite(remap = false)
    public static void _disableBlend() {}

    @Overwrite(remap = false)
    public static void _enableTexture() {}

    @Overwrite(remap = false)
    public static void _disableTexture() {}

    @Overwrite(remap = false)
    public static void _activeTexture(int i) {}

    @Overwrite(remap = false)
    public static void _clearDepth(double d) {}

    @Overwrite(remap = false)
    public static int glCreateShader(int i) {
        return 0;
    }

    @Overwrite(remap = false)
    public static int glGetProgrami(int i, int j) {
        return 0;
    }

    @Overwrite(remap = false)
    public static void glAttachShader(int i, int j) {}

    @Overwrite(remap = false)
    public static void glDeleteShader(int i) {}

    @Overwrite(remap = false)
    public static void glShaderSource(int i, List<String> list) {}

    @Overwrite(remap = false)
    public static void glCompileShader(int i) {}

    @Overwrite(remap = false)
    public static int glGetShaderi(int i, int j) {
        return 0;
    }

    @Overwrite(remap = false)
    public static int glCreateProgram() {
        return 0;
    }

    @Overwrite(remap = false)
    public static void glDeleteProgram(int i) {}

    @Overwrite(remap = false)
    public static void glLinkProgram(int i) {}

    @Overwrite(remap = false)
    public static int glGenFramebuffers() {
        return 0;
    }

    @Overwrite(remap = false)
    public static int glGenRenderbuffers() {
        return 0;
    }

    @Overwrite(remap = false)
    public static int glCheckFramebufferStatus(int i) {
        return 0;
    }

    @Overwrite(remap = false)
    public static void glActiveTexture(int i) {}

    @Overwrite(remap = false)
    public static void glBlendFuncSeparate(int i, int j, int k, int l) {}

    @Overwrite(remap = false)
    public static String glGetShaderInfoLog(int i, int j) {
        return "";
    }

    @Overwrite(remap = false)
    public static String glGetProgramInfoLog(int i, int j) {
        return "";
    }

    @Overwrite(remap = false)
    public static void _glBindFramebuffer(int i, int j) {}

}