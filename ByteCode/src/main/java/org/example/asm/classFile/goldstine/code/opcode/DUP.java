package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.PushInstruction;
import org.example.asm.classFile.goldstine.code.facet.StackInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DUP extends Instruction implements StackInstruction, PushInstruction {

    public DUP() {
        super(OpcodeConst.DUP, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP(this);
    }

}
