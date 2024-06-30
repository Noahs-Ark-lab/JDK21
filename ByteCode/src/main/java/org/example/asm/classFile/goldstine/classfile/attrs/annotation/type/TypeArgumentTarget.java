package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class TypeArgumentTarget {
    public final int offset;
    public final int type_argument_index;

    public TypeArgumentTarget(ByteDashboard bd) {
        this.offset = bd.readUnsignedShort();
        this.type_argument_index = bd.readUnsignedByte();
    }
}
