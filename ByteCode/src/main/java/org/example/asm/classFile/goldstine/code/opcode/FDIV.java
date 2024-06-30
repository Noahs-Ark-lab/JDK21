package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArithmeticInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class FDIV extends Instruction implements ArithmeticInstruction {

    public FDIV() {
        super(OpcodeConst.FDIV, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFDIV(this);
    }

}
