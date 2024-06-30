package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArithmeticInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DDIV extends Instruction implements ArithmeticInstruction {

    public DDIV() {
        super(OpcodeConst.DDIV, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDDIV(this);
    }

}
