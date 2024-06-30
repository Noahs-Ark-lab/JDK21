package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * L2I - Convert long to int
 * <PRE>Stack: ..., value.word1, value.word2 -&gt; ..., result</PRE>
 */
public class L2I extends Instruction implements ConversionInstruction {

    public L2I() {
        super(OpcodeConst.L2I, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitL2I(this);
    }

}
