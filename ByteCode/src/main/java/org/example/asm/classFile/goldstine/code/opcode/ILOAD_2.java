package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.LoadInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ILOAD_2 extends Instruction implements LoadInstruction {

    public final int index = 2;

    public ILOAD_2() {
        super(OpcodeConst.ILOAD_2, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitILOAD_2(this);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        throw new RuntimeException("index is final");
    }

}
