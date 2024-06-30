package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ArithmeticInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * INEG - Negate int
 * <PRE>Stack: ..., value -&gt; ..., result</PRE>
 */
public class INEG extends Instruction implements ArithmeticInstruction {

    public INEG() {
        super(OpcodeConst.INEG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitINEG(this);
    }

}
