package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.StoreInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class FSTORE_3 extends Instruction implements StoreInstruction {

    public final int index = 3;

    public FSTORE_3() {
        super(OpcodeConst.FSTORE_3, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitFSTORE_3(this);
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
