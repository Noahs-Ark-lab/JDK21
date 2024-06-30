package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class TypeParameterTarget {
    public final int type_parameter_index;

    public TypeParameterTarget(ByteDashboard bd) {
        this.type_parameter_index = bd.readUnsignedByte();
    }
}
