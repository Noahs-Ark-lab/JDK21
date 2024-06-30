package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class LRETURN extends Instruction implements ReturnInstruction {

    public LRETURN() {
        super(OpcodeConst.LRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLRETURN(this);
    }

}
