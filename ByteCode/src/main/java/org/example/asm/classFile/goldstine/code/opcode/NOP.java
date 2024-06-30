package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * NOP - Do nothing
 */
public class NOP extends Instruction {

    public NOP() {
        super(OpcodeConst.NOP, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitNOP(this);
    }

}
