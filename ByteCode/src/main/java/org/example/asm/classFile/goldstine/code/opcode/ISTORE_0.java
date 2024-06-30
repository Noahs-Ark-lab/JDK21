package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ISTORE_0 extends Instruction implements StoreInstruction {

    public final int index = 0;

    public ISTORE_0() {
        super(OpcodeConst.ISTORE_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitISTORE_0(this);
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
