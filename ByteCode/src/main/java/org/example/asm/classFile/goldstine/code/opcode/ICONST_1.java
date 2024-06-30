package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConstantPushInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ICONST_1 extends Instruction implements ConstantPushInstruction {

    public final int value = 1;

    public ICONST_1() {
        super(OpcodeConst.ICONST_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitICONST_1(this);
    }

    @Override
    public Number getValue() {
        return Integer.valueOf(value);
    }

}