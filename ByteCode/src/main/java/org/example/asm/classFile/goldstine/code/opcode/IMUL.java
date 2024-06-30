package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArithmeticInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * IMUL - Multiply ints
 * <PRE>Stack: ..., value1, value2 -&gt; result</PRE>
 */
public class IMUL extends Instruction implements ArithmeticInstruction {

    public IMUL() {
        super(OpcodeConst.IMUL,1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIMUL(this);
    }

}
