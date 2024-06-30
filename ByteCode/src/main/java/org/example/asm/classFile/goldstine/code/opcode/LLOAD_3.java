package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class LLOAD_3 extends Instruction implements LoadInstruction {

    public final int index = 3;

    public LLOAD_3() {
        super(OpcodeConst.LLOAD_3, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitLLOAD_3(this);
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
