package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * POP - Pop top operand f_stack word
 *
 * <PRE>Stack: ..., word -&gt; ...</PRE>
 */
public class POP extends Instruction implements StackInstruction, PopInstruction {

    public POP() {
        super(OpcodeConst.POP, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitPOP(this);
    }

}
