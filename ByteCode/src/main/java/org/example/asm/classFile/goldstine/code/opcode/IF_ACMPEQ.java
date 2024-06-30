package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.IfInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class IF_ACMPEQ extends Instruction implements IfInstruction {

    public int branch;

    public IF_ACMPEQ() {
        super(OpcodeConst.IF_ACMPEQ, 3);
    }

    public IF_ACMPEQ(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ACMPEQ(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
