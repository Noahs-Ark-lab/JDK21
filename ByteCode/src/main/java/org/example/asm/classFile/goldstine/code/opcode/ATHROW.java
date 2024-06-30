package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.UnconditionalBranch;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class ATHROW extends Instruction implements UnconditionalBranch {

    public ATHROW() {
        super(OpcodeConst.ATHROW, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitATHROW(this);
    }
}
