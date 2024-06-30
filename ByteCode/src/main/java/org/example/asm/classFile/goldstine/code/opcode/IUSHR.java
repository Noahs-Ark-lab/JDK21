package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * IUSHR - Logical shift right int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class IUSHR extends Instruction implements ArithmeticInstruction {

    public IUSHR() {
        super(OpcodeConst.IUSHR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIUSHR(this);
    }

}
