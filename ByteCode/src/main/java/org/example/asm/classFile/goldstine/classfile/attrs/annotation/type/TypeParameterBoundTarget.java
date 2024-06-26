package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class TypeParameterBoundTarget {
    public final int type_parameter_index;
    public final int bound_index;

    public TypeParameterBoundTarget(ByteDashboard bd) {
        this.type_parameter_index = bd.readUnsignedByte();
        this.bound_index = bd.readUnsignedByte();
    }
}
