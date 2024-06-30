package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConversionInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class D2F extends Instruction implements ConversionInstruction {

    public D2F() {
        super(OpcodeConst.D2F, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitD2F(this);
    }

}
