package org.example.asm.classFile.run;

import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.classfile.MethodInfo;
import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.utils.InstructionChain;
import org.example.asm.classFile.goldstine.code.visitors.BasicOpcodeVisitor;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeReadVisitor;
import org.example.asm.classFile.goldstine.utils.*;

public class J_Basic_Opcode {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "org/example/asm/classFile/ClassFileStructure.class";
        String name_and_type = "test:()V";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        process(classfile, name_and_type);
    }

    public static void process(ClassFile classfile, String name_and_type) {
        MethodInfo method_info = MethodUtils.findMethod(classfile, name_and_type);

        byte[] code_bytes = AttributeUtils.findCodeAttribute(method_info).code;
        System.out.println("=== === ===  === === ===  === === ===");
        System.out.println("HexCode:");
        System.out.println(HexUtils.format(code_bytes, HexFormat.FORMAT_FF_SPACE_FF_16));
        System.out.println("=== === ===  === === ===  === === ===");

        OpcodeReadVisitor rv = new OpcodeReadVisitor(code_bytes);
        InstructionChain chain = rv.getInstructionChain();

        BasicOpcodeVisitor v = new BasicOpcodeVisitor(code_bytes);
        Instruction current = chain.start;
        while(current != null) {
            current.accept(v);
            current = current.next;
        }
    }
}
