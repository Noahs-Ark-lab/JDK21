package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class POP2 extends Instruction implements StackInstruction, PopInstruction {

    public POP2() {
        super(OpcodeConst.POP2, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitPOP2(this);
    }

}
