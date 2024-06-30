package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * IRETURN -  Return int from d_method
 * <PRE>Stack: ..., value -&gt; &lt;empty&gt;</PRE>
 */
public class IRETURN extends Instruction implements ReturnInstruction {

    public IRETURN() {
        super(OpcodeConst.IRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIRETURN(this);
    }

}
