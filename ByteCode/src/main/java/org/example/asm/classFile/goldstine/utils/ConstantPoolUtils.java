package org.example.asm.classFile.goldstine.utils;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.vs.ClassFileStandardVisitor;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class ConstantPoolUtils {
    public static void print(ConstantPool cp) {
        print(cp, false);
    }

    public static void print(ConstantPool cp, boolean raw) {
        if (!raw) {
            cp.simplify();
        }

        Visitor v = new ClassFileStandardVisitor();
        cp.accept(v);
    }
}
