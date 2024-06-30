package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.TypedInstruction;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class ACONST_NULL extends Instruction implements TypedInstruction {

    public ACONST_NULL() {
        super(OpcodeConst.ACONST_NULL, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitACONST_NULL(this);
    }

}
