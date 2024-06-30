package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.StoreInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public final class DSTORE_2 extends Instruction implements StoreInstruction {

    public final int index = 2;

    public DSTORE_2() {
        super(OpcodeConst.DSTORE_2, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDSTORE_2(this);
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
