package net.vulkanmod.vulkan.shader;

import com.mojang.blaze3d.systems.RenderSystem;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Vec1f extends Field<Float> {

    protected Vec1f(String name, AlignedStruct struct) {
        super(name, 1, 1, struct.getCurrentOffset());

        struct.setCurrentOffset(offset + size);
        setFunction();
    }

    void setFunction() {
        switch (this.name) {
            case "FogStart" -> this.set = RenderSystem::getShaderFogStart;
            case "FogEnd" -> this.set = RenderSystem::getShaderFogEnd;
            case "LineWidth" -> this.set = RenderSystem::getShaderLineWidth;
            case "GameTime" -> this.set = RenderSystem::getShaderGameTime;
        }
    }

    void update(ByteBuffer buffer) {
        //update(buffer.asFloatBuffer());

        float f = this.set.get();
        buffer.position(offset << 2);
        buffer.putFloat(f);
    }
}
