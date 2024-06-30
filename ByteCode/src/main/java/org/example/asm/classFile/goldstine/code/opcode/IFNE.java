package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.IfInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class IFNE extends Instruction implements IfInstruction {

    public int branch;

    public IFNE() {
        super(OpcodeConst.IFNE, 3);
    }

    public IFNE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFNE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
