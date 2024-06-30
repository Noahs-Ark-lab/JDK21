package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * ISUB - Substract ints
 * <PRE>Stack: ..., value1, value2 -&gt; result</PRE>
 */
public class ISUB extends Instruction implements ArithmeticInstruction {

    public ISUB() {
        super(OpcodeConst.ISUB, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISUB(this);
    }

}
