package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class LCONST_1 extends Instruction implements ConstantPushInstruction {

    public final long value = 1;

    public LCONST_1() {
        super(OpcodeConst.LCONST_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitLCONST_1(this);
    }

    @Override
    public Number getValue() {
        return Long.valueOf(value);
    }

}