package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArithmeticInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class FSUB extends Instruction implements ArithmeticInstruction {

    public FSUB() {
        super(OpcodeConst.FSUB, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFSUB(this);
    }

}
