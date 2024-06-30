package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.StoreInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class ASTORE_1 extends Instruction implements StoreInstruction {

    public final int index = 1;

    public ASTORE_1() {
        super(OpcodeConst.ASTORE_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitASTORE_1(this);
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
