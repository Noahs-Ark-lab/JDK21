package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * IOR - Bitwise OR int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class IOR extends Instruction implements ArithmeticInstruction {

    public IOR() {
        super(OpcodeConst.IOR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIOR(this);
    }

}
