package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.CompareInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DCMPG extends Instruction implements CompareInstruction {

    public DCMPG() {
        super(OpcodeConst.DCMPG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDCMPG(this);
    }

}
