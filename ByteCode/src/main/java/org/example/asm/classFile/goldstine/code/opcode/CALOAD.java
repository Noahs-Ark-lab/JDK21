package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArrayInstruction;
import org.example.asm.classFile.goldstine.code.facet.StackProducer;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class CALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public CALOAD() {
        super(OpcodeConst.CALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitCALOAD(this);
    }

}
