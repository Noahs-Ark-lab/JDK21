package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class ThrowsTarget {
    public final int throws_type_index;

    public ThrowsTarget(ByteDashboard bd) {
        this.throws_type_index = bd.readUnsignedShort();
    }
}
