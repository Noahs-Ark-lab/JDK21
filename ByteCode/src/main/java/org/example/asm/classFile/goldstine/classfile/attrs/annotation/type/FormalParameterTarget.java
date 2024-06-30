package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class FormalParameterTarget {
    public final int formal_parameter_index;

    public FormalParameterTarget(ByteDashboard bd) {
        this.formal_parameter_index = bd.readUnsignedByte();
    }
}
