package org.example.asm.classFile.run;

import org.example.asm.classFile.goldstine.classfile.Attributes;
import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.FieldInfo;
import org.example.asm.classFile.goldstine.utils.ConstantPoolUtils;
import org.example.asm.classFile.goldstine.utils.FieldUtils;
import org.example.asm.classFile.goldstine.utils.FileUtils;
import org.example.asm.classFile.goldstine.utils.ReadUtils;
import org.example.asm.classFile.goldstine.vs.AttributeStandardVisitor;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class I_Attributes_Field {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "org/example/asm/classFile/ClassFileStructure.class";
        String name_and_type = "intValue:I";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        FieldInfo field_info = FieldUtils.findField(classfile, name_and_type);

        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        Attributes attributes = field_info.attributes;
        Visitor v = new AttributeStandardVisitor(cp);
        attributes.accept(v);
    }
}

