package org.example.asm.classFile.run;


import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.Fields;
import org.example.asm.classFile.goldstine.utils.ConstantPoolUtils;
import org.example.asm.classFile.goldstine.utils.FileUtils;
import org.example.asm.classFile.goldstine.utils.ReadUtils;
import org.example.asm.classFile.goldstine.vs.ClassFileStandardVisitor;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class G_Fields {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        process(classfile);
    }

    public static void process(ClassFile classfile) {
        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        Fields fields = classfile.fields;
        // 可以使用 ClassFileSimpleVisitor 或者 ClassFileStandardVisitor
        Visitor v = new ClassFileStandardVisitor();
        fields.accept(v);
    }
}
