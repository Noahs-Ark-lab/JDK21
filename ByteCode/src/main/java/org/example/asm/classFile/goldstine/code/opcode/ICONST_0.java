package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConstantPushInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ICONST_0 extends Instruction implements ConstantPushInstruction {

    public final int value = 0;

    public ICONST_0() {
        super(OpcodeConst.ICONST_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitICONST_0(this);
    }

    @Override
    public Number getValue() {
        return Integer.valueOf(value);
    }

}
