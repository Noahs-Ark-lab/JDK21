package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ReturnInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class ARETURN extends Instruction implements ReturnInstruction {

    public ARETURN() {
        super(OpcodeConst.ARETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitARETURN(this);
    }
}
