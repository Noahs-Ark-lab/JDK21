package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConstantPushInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class FCONST_0 extends Instruction implements ConstantPushInstruction {

    public final float value = 0;

    public FCONST_0() {
        super(OpcodeConst.FCONST_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitFCONST_0(this);
    }

    @Override
    public Number getValue() {
        return Float.valueOf(value);
    }

}
