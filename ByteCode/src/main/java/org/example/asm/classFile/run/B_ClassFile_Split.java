package org.example.asm.classFile.run;

import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.utils.FileUtils;
import org.example.asm.classFile.goldstine.utils.ReadUtils;
import org.example.asm.classFile.goldstine.vs.FileSplitVisitor;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class B_ClassFile_Split {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile class_file = ClassFile.parse(bytes);
        String dir_path = FileUtils.getFilePath("split/sample/");
        Visitor v = new FileSplitVisitor(dir_path);
        class_file.accept(v);
        System.out.println("file://" + dir_path);
    }
}
