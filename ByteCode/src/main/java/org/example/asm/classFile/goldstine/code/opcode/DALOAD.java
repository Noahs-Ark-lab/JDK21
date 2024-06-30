package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArrayInstruction;
import org.example.asm.classFile.goldstine.code.facet.StackProducer;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public DALOAD() {
        super(OpcodeConst.DALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDALOAD(this);
    }

}
