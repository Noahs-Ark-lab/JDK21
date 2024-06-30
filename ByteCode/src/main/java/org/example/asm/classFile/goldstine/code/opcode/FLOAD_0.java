package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.LoadInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class FLOAD_0 extends Instruction implements LoadInstruction {

    public final int index = 0;

    public FLOAD_0() {
        super(OpcodeConst.FLOAD_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitFLOAD_0(this);
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
