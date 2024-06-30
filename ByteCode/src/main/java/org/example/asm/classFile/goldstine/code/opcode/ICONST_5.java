package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConstantPushInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ICONST_5 extends Instruction implements ConstantPushInstruction {

    public final int value = 5;

    public ICONST_5() {
        super(OpcodeConst.ICONST_5, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitICONST_5(this);
    }

    @Override
    public Number getValue() {
        return Integer.valueOf(value);
    }

}
