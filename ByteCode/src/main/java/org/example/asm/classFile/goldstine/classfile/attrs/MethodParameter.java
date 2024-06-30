package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class MethodParameter {
    public final int name_index;
    public final int access_flags;

    public MethodParameter(ByteDashboard bd) {
        this.name_index = bd.readUnsignedShort();
        this.access_flags = bd.readUnsignedShort();
    }
}
