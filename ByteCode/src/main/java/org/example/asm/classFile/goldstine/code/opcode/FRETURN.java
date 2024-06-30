package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ReturnInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class FRETURN extends Instruction implements ReturnInstruction {

    public FRETURN() {
        super(OpcodeConst.FRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFRETURN(this);
    }

}
