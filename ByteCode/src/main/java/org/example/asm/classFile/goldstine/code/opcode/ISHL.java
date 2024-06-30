package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * ISHL - Arithmetic shift left int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class ISHL extends Instruction implements ArithmeticInstruction {

    public ISHL() {
        super(OpcodeConst.ISHL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISHL(this);
    }

}
