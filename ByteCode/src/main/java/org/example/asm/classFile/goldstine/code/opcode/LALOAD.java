package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * LALOAD - Load long from array
 * <PRE>Stack: ..., arrayref, index -&gt; ..., value1, value2</PRE>
 */
public class LALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public LALOAD() {
        super(OpcodeConst.LALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLALOAD(this);
    }

}
