package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConversionInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class I2D extends Instruction implements ConversionInstruction {

    public I2D() {
        super(OpcodeConst.I2D, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitI2D(this);
    }

}
