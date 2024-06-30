package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * ISHR - Arithmetic shift right int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class ISHR extends Instruction implements ArithmeticInstruction {

    public ISHR() {
        super(OpcodeConst.ISHR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISHR(this);
    }

}
