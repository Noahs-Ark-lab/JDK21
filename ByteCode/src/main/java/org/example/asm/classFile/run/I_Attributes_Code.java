package org.example.asm.classFile.run;

import org.example.asm.classFile.goldstine.classfile.Attributes;
import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.MethodInfo;
import org.example.asm.classFile.goldstine.classfile.attrs.Code;
import org.example.asm.classFile.goldstine.utils.*;
import org.example.asm.classFile.goldstine.vs.AttributeStandardVisitor;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class I_Attributes_Code {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";
        String name_and_type = "test:()V";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        MethodInfo methodInfo = MethodUtils.findMethod(classfile, name_and_type);
        Code code_attr = AttributeUtils.findCodeAttribute(methodInfo);

        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        System.out.println("=== === ===  === === ===  === === ===");
        Attributes attributes = code_attr.attributes;
        Visitor v = new AttributeStandardVisitor(cp);
        attributes.accept(v);
    }
}