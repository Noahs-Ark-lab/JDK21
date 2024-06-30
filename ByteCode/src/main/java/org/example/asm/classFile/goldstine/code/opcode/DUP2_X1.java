package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.StackInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DUP2_X1 extends Instruction implements StackInstruction {

    public DUP2_X1() {
        super(OpcodeConst.DUP2_X1, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP2_X1(this);
    }

}
