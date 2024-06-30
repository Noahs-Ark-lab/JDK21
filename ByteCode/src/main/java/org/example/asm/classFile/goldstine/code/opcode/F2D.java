package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConversionInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class F2D extends Instruction implements ConversionInstruction {

    public F2D() {
        super(OpcodeConst.F2D, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitF2D(this);
    }

}
