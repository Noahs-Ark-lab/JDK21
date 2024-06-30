package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArrayInstruction;
import org.example.asm.classFile.goldstine.code.facet.StackProducer;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class BALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public BALOAD() {
        super(OpcodeConst.BALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitBALOAD(this);
    }
}
