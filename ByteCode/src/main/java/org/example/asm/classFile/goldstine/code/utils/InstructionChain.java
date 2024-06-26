package org.example.asm.classFile.goldstine.code.utils;

import org.example.asm.classFile.goldstine.code.Instruction;

public class InstructionChain {
    public int count;
    public Instruction start;
    public Instruction end;

    public boolean isEmpty() {
        return start == null;
    }

    public void append(Instruction ins) {
        if (isEmpty()) {
            start = end = ins;
            ins.pre = null;
            ins.next = null;
        }
        else {
            end.next = ins;
            ins.pre = end;
            ins.next = null;
            end = ins;
        }
        count++;
    }

}
