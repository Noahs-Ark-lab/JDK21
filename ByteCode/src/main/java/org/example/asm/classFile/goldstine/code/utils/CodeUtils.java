package org.example.asm.classFile.goldstine.code.utils;

import org.example.asm.classFile.goldstine.classfile.ClassFile;

import java.util.function.BiConsumer;

public class CodeUtils {
    public static void process_opcode(ClassFile classfile, String name_and_type, BiConsumer<ClassFile, String> consumer) {
        consumer.accept(classfile, name_and_type);
    }
}
