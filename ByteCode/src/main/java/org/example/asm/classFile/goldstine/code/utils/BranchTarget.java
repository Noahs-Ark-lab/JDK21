package org.example.asm.classFile.goldstine.code.utils;


import org.example.asm.classFile.goldstine.code.Instruction;

public class BranchTarget {
    public final Instruction target;
    public final int stackDepth;


    public BranchTarget(final Instruction target, final int stackDepth) {
        this.target = target;
        this.stackDepth = stackDepth;
    }
}
