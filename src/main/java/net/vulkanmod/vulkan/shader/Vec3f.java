package net.vulkanmod.vulkan.shader;

import net.vulkanmod.vulkan.VRenderSystem;
import net.vulkanmod.vulkan.util.VUtil;
import org.lwjgl.system.MemoryUtil;
import sun.misc.Unsafe;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Vec3f extends Field<ByteBuffer> {

    protected Vec3f(String name, AlignedStruct ubo) {
        super(name, 3, 4, ubo.getCurrentOffset());

        ubo.setCurrentOffset(offset + size);
        setFunction();
    }

    void setFunction() {
        switch (this.name) {
            case "Light0_Direction" -> this.set = () -> VRenderSystem.lightDirection0;
            case "Light1_Direction" -> this.set = () -> VRenderSystem.lightDirection1;
            case "ChunkOffset" -> this.set = () -> VRenderSystem.ChunkOffset;
        }
    }

    void update(ByteBuffer buffer) {
        //update(buffer.asFloatBuffer());
        ByteBuffer src = set.get();
        buffer.position(offset << 2);

//        MemoryUtil.memCopy(src, buffer);

        FloatBuffer fb = src.asFloatBuffer();

        VUtil.UNSAFE.putFloat(MemoryUtil.memAddress(buffer), fb.get(0));
        VUtil.UNSAFE.putFloat(MemoryUtil.memAddress(buffer) + 4, fb.get(1));
        VUtil.UNSAFE.putFloat(MemoryUtil.memAddress(buffer) + 8, fb.get(2));
    }
}
