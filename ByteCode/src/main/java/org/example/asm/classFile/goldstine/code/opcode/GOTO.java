package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.GotoInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class GOTO extends Instruction implements GotoInstruction {

    public int branch;

    public GOTO() {
        super(OpcodeConst.GOTO, 3);
    }

    public GOTO(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitGOTO(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }
}
