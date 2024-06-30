package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.ConversionInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;


public class D2I extends Instruction implements ConversionInstruction {

    public D2I() {
        super(OpcodeConst.D2I, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitD2I(this);
    }

}
