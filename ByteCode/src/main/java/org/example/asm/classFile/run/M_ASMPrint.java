package org.example.asm.classFile.run;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.util.ASMifier;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import org.example.asm.classFile.goldstine.utils.FileUtils;
import org.example.asm.classFile.goldstine.utils.ReadUtils;

import java.io.PrintWriter;

public class M_ASMPrint {
    public static void main(String[] args) {
        String relative_path = "org/example/asm/classFile/ClassFileStructure.class";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);
        generate(bytes);
    }

    public static void generate(byte[] bytes) {
        ASMifier printer = new ASMifier();
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, printer, new PrintWriter(System.out));
        ClassReader cr = new ClassReader(bytes);
        cr.accept(traceClassVisitor, ClassReader.SKIP_FRAMES);
    }
}
