package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

/**
 * ISTORE - Store int from f_stack into local variable
 * <PRE>Stack: ..., value -&gt; ... </PRE>
 */
public class ISTORE extends Instruction implements StoreInstruction {

    public int index;

    public ISTORE() {
        super(OpcodeConst.ISTORE, 2);
    }

    public ISTORE(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISTORE(this);
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
