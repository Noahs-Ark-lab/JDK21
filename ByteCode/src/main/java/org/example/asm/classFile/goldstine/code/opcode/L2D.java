package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * L2D - Convert long to double
 * <PRE>Stack: ..., value.word1, value.word2 -&gt; ..., result.word1, result.word2</PRE>
 */
public class L2D extends Instruction implements ConversionInstruction {

    public L2D() {
        super(OpcodeConst.L2D, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitL2D(this);
    }

}
