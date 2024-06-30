package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class LineNumber {
    public final int start_pc;
    public final int line_number;

    public LineNumber(ByteDashboard bd) {
        this.start_pc = bd.readUnsignedShort();
        this.line_number = bd.readUnsignedShort();
    }
}
