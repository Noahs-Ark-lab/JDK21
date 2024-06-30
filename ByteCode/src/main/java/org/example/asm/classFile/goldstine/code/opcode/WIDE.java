package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class WIDE extends Instruction {

    public WIDE() {
        super(OpcodeConst.WIDE, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitWIDE(this);
    }

}
