package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.StackInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DUP_X2 extends Instruction implements StackInstruction {

    public DUP_X2() {
        super(OpcodeConst.DUP_X2, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP_X2(this);
    }

}
