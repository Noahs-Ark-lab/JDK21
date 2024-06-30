package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConversionInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class F2I extends Instruction implements ConversionInstruction {

    public F2I() {
        super(OpcodeConst.F2I, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitF2I(this);
    }

}
