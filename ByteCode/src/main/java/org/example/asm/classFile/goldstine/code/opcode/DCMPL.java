package org.example.asm.classFile.goldstine.code.opcode;


import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.CompareInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class DCMPL extends Instruction implements CompareInstruction {

    public DCMPL() {
        super(OpcodeConst.DCMPL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDCMPL(this);
    }

}
