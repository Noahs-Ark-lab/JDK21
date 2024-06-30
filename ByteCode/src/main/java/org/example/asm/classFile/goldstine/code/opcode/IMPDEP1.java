package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * IMPDEP1 - Implementation dependent
 */
public class IMPDEP1 extends Instruction {

    public IMPDEP1() {
        super(OpcodeConst.IMPDEP1, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIMPDEP1(this);
    }

}
