package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * JSR_W - Jump to subroutine
 */
public class JSR_W extends Instruction implements JsrInstruction {

    public int branch;

    public JSR_W() {
        super(OpcodeConst.JSR_W, 5);
    }

    public JSR_W(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitJSR_W(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
