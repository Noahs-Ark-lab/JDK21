package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ISTORE_1 extends Instruction implements StoreInstruction {

    public final int index = 1;

    public ISTORE_1() {
        super(OpcodeConst.ISTORE_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitISTORE_1(this);
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
