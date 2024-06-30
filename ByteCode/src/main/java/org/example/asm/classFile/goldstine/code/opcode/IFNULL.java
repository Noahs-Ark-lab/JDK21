package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.IfInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class IFNULL extends Instruction implements IfInstruction {

    public int branch;

    public IFNULL() {
        super(OpcodeConst.IFNULL, 3);
    }

    public IFNULL(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFNULL(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
