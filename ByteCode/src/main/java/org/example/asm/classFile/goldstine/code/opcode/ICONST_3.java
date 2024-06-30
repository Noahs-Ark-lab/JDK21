package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConstantPushInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ICONST_3 extends Instruction implements ConstantPushInstruction {

    public final int value = 3;

    public ICONST_3() {
        super(OpcodeConst.ICONST_3, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitICONST_3(this);
    }

    @Override
    public Number getValue() {
        return Integer.valueOf(value);
    }

}
