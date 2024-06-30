package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.CPInstruction;
import org.example.asm.classFile.goldstine.code.facet.LoadClass;
import org.example.asm.classFile.goldstine.code.facet.StackConsumer;
import org.example.asm.classFile.goldstine.code.facet.StackProducer;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class CHECKCAST extends Instruction
        implements CPInstruction, LoadClass, StackProducer, StackConsumer {

    public int index;

    public CHECKCAST() {
        super(OpcodeConst.CHECKCAST, 3);
    }

    public CHECKCAST(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitCHECKCAST(this);
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
