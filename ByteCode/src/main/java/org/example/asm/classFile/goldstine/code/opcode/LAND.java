package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * LAND - Bitwise AND longs
 * <PRE>Stack: ..., value1.word1, value1.word2, value2.word1, value2.word2 -&gt;</PRE>
 * ..., result.word1, result.word2
 */
public class LAND extends Instruction implements ArithmeticInstruction {

    public LAND() {
        super(OpcodeConst.LAND, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLAND(this);
    }

}
