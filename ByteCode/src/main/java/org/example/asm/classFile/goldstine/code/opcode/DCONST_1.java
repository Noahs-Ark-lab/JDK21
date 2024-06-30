package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConstantPushInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class DCONST_1 extends Instruction implements ConstantPushInstruction {

    public double value = 1;

    public DCONST_1() {
        super(OpcodeConst.DCONST_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDCONST_1(this);
    }

    @Override
    public Number getValue() {
        return Double.valueOf(value);
    }

}
