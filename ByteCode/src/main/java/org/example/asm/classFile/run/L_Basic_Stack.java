package org.example.asm.classFile.run;

import org.example.asm.classFile.goldstine.classfile.ClassFile;
import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.MethodInfo;
import org.example.asm.classFile.goldstine.classfile.attrs.Code;
import org.example.asm.classFile.goldstine.code.Instruction;
import org.example.asm.classFile.goldstine.code.utils.InstructionChain;
import org.example.asm.classFile.goldstine.code.visitors.OpcodeReadVisitor;
import org.example.asm.classFile.goldstine.code.visitors.StandardOpcodeVisitor;
import org.example.asm.classFile.goldstine.code.visitors.stack.FrameVisitor;
import org.example.asm.classFile.goldstine.code.visitors.stack.State;
import org.example.asm.classFile.goldstine.utils.*;
import org.example.asm.classFile.goldstine.vs.HumanReadableVisitor;

public class L_Basic_Stack {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";
        String name_and_type = "test:()V";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        process(classfile, name_and_type);
    }

    public static void process(ClassFile classfile, String name_and_type) {
        // constant_pool
        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);
        System.out.println("=== === ===  === === ===  === === ===");

        // method_info
        MethodInfo method_info = MethodUtils.findMethod(classfile, name_and_type);
        MethodUtils.print(method_info, cp);
        System.out.println("=== === ===  === === ===  === === ===");

        // Code Attribute
        Code code_attr = AttributeUtils.findCodeAttribute(method_info);
        HumanReadableVisitor human_readable_visitor = new HumanReadableVisitor(cp);
        code_attr.accept(human_readable_visitor);
        System.out.println("=== === ===  === === ===  === === ===");

        // opcode
        byte[] code_bytes = code_attr.code;
        OpcodeReadVisitor rv = new OpcodeReadVisitor(code_bytes);
        InstructionChain chain = rv.getInstructionChain();

        StandardOpcodeVisitor v = new StandardOpcodeVisitor(cp, code_bytes);
        FrameVisitor frame_visitor = new FrameVisitor(classfile, name_and_type);
        Instruction current = chain.start;
        while (current != null) {
            frame_visitor.visitInstruction(current);
            current = current.next;
        }

        current = chain.start;
        while (current != null) {
            int pos = current.pos;

            if (frame_visitor.has_pre_state(pos)) {
                State pre_state = frame_visitor.get_pre_state(pos);
                System.out.println(pre_state);
            }

            current.accept(v);

            {
                State post_state = frame_visitor.get_post_state(pos);
                System.out.println(post_state.frame);
            }

            current = current.next;
        }
        System.out.println("=== === ===  === === ===  === === ===");
    }
}
