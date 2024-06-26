package org.example.asm.classFile.goldstine.code.opcode;

import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.facet.*;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeVisitor;
import org.example.asm.classFile.goldstine.cst.OpcodeConst;

public class MULTIANEWARRAY extends Instruction
        implements CPInstruction, LoadClass, AllocationInstruction {

    public int index;
    public int dimensions;

    public MULTIANEWARRAY() {
        super(OpcodeConst.MULTIANEWARRAY, 4);
    }

    public MULTIANEWARRAY(final int index, final short dimensions) {
        this();

        if (dimensions < 1) {
            throw new RuntimeException("Invalid dimensions value: " + dimensions);
        }

        this.index = index;
        this.dimensions = dimensions;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitMULTIANEWARRAY(this);
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
