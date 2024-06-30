package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.FieldInstruction;
import org.example.asm.classFile.goldstine.code.facet.StackConsumer;
import org.example.asm.classFile.goldstine.code.facet.StackProducer;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class GETFIELD extends Instruction implements FieldInstruction, StackConsumer, StackProducer {

    public int index;

    public GETFIELD() {
        super(OpcodeConst.GETFIELD, 3);
    }

    public GETFIELD(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitGETFIELD(this);
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
