package org.example.asm.classFile.goldstine.code.facet;

public interface SelectInstruction extends BranchInstruction, VariableLengthInstruction, StackConsumer, StackProducer {
    int[] getMatches();
    int[] getOffsets();
}
