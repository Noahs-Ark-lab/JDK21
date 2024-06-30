package org.example.asm.classFile.run;

import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.utils.FileUtils;
import org.example.asm.classFile.goldstine.utils.ReadUtils;
import org.example.asm.classFile.goldstine.vs.ClassFileRawVisitor;
import org.example.asm.classFile.goldstine.vs.ClassFileStandardVisitor;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class B_ClassFile_Raw {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "org/example/asm/classFile/ClassFileStructure.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        // 可以使用 ClassFileRawVisitor、ClassFileSimpleVisitor 或者 ClassFileStandardVisitor
        Visitor v = new ClassFileStandardVisitor();
        classfile.accept(v);
    }
}
