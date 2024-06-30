package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class OffsetTarget {
    public final int offset;

    public OffsetTarget(ByteDashboard bd) {
        this.offset = bd.readUnsignedShort();
    }
}
