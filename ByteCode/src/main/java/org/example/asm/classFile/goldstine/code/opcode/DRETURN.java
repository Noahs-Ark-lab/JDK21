package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ReturnInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DRETURN extends Instruction implements ReturnInstruction {

    public DRETURN() {
        super(OpcodeConst.DRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDRETURN(this);
    }

}
