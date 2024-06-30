package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.LoadInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class FLOAD extends Instruction implements LoadInstruction {

    public int index;

    public FLOAD() {
        super(OpcodeConst.FLOAD, 2);
    }

    public FLOAD(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFLOAD(this);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

}
