package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class CatchTarget {
    public final int exception_table_index;

    public CatchTarget(ByteDashboard bd) {
        this.exception_table_index = bd.readUnsignedShort();
    }
}
