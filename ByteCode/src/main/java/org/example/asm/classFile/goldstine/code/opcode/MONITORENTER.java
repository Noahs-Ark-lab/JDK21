package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class MONITORENTER extends Instruction implements StackConsumer {

    public MONITORENTER() {
        super(OpcodeConst.MONITORENTER, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitMONITORENTER(this);
    }

}
