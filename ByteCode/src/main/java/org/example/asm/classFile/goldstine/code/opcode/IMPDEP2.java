package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * IMPDEP2 - Implementation dependent
 */
public class IMPDEP2 extends Instruction {

    public IMPDEP2() {
        super(OpcodeConst.IMPDEP2, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIMPDEP2(this);
    }

}
