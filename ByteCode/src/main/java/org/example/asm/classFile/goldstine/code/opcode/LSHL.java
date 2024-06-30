package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class LSHL extends Instruction implements ArithmeticInstruction {

    public LSHL() {
        super(OpcodeConst.LSHL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLSHL(this);
    }

}
