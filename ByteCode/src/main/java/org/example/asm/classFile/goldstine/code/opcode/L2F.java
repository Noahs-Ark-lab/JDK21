package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * L2F - Convert long to float
 * <PRE>Stack: ..., value.word1, value.word2 -&gt; ..., result</PRE>
 */
public class L2F extends Instruction implements ConversionInstruction {

    public L2F() {
        super(OpcodeConst.L2F, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitL2F(this);
    }

}
