package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.IfInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class IFLE extends Instruction implements IfInstruction {

    public int branch;

    public IFLE() {
        super(OpcodeConst.IFLE, 3);
    }

    public IFLE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFLE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
