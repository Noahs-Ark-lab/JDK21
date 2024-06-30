package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class SALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public SALOAD() {
        super(OpcodeConst.SALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitSALOAD(this);
    }

}
