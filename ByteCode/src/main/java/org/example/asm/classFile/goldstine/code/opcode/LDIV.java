package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class LDIV extends Instruction implements ArithmeticInstruction {

    public LDIV() {
        super(OpcodeConst.LDIV, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLDIV(this);
    }

}
