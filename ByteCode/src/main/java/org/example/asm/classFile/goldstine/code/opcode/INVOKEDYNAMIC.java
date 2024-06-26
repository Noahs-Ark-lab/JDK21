package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * Class for INVOKEDYNAMIC. Not an instance of InvokeInstruction, since that class
 * expects to be able to get the class of the d_method. Ignores the bootstrap
 * mechanism entirely.
 */
public class INVOKEDYNAMIC extends Instruction implements InvokeInstruction {

    public int index;

    public INVOKEDYNAMIC() {
        super(OpcodeConst.INVOKEDYNAMIC, 5);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitINVOKEDYNAMIC(this);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

}
