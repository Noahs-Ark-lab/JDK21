package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class LSTORE_2 extends Instruction implements StoreInstruction {

    public final int index = 2;

    public LSTORE_2() {
        super(OpcodeConst.LSTORE_2, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitLSTORE_2(this);
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
