package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class SuperTypeTarget {
    public final int supertype_index;

    public SuperTypeTarget(ByteDashboard bd) {
        this.supertype_index = bd.readUnsignedShort();
    }
}
