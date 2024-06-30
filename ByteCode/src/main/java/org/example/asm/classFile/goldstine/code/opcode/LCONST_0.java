package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class LCONST_0 extends Instruction implements ConstantPushInstruction {

    public final long value = 0;

    public LCONST_0() {
        super(OpcodeConst.LCONST_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitLCONST_0(this);
    }

    @Override
    public Number getValue() {
        return Long.valueOf(value);
    }

}
