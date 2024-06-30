package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * JSR - Jump to subroutine
 */
public class JSR extends Instruction implements JsrInstruction, VariableLengthInstruction {

    public int branch;

    public JSR() {
        super(OpcodeConst.JSR, 3);
    }

    public JSR(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitJSR(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
