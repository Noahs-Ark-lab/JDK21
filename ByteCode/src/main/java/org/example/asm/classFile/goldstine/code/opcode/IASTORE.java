package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArrayInstruction;
import org.example.asm.classFile.goldstine.code.facet.StackConsumer;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class IASTORE extends Instruction implements ArrayInstruction, StackConsumer {

    public IASTORE() {
        super(OpcodeConst.IASTORE, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIASTORE(this);
    }

}
