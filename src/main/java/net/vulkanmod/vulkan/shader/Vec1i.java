package net.vulkanmod.vulkan.shader;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Vec1i extends Field<Integer> {
    protected Vec1i(String name, AlignedStruct struct) {
        super(name, 1, 1, struct.getCurrentOffset());

        struct.setCurrentOffset(offset + size);
        setFunction();
    }

    void setFunction() {
        if (this.name.equals("EndPortalLayers")) this.set = () -> 15;
    }

    void update(ByteBuffer buffer) {

        int f = this.set.get();
        buffer.position(offset * 4);
        buffer.putInt(f);
    }
}
