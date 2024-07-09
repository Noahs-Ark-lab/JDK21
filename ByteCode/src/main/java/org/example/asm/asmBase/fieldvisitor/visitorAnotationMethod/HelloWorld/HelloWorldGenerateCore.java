package org.example.asm.asmBase.fieldvisitor.visitorAnotationMethod.HelloWorld;

import org.example.asm.classFile.goldstine.utils.FileUtils;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;

import static org.objectweb.asm.Opcodes.*;

public class HelloWorldGenerateCore {
    public static void main(String[] args) throws Exception {
        String relative_path = "sample/HelloWorld.class";
        String filepath = FileUtils.getFilePath(relative_path);

        // (1) 生成 byte[] 内容
        byte[] bytes = dump();

        // (2) 保存 byte[] 到文件
        FileUtils.writeBytes(filepath, bytes);
    }

    public static byte[] dump() throws Exception {
        // (1) 创建 ClassWriter 对象
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        // (2) 调用 visitXxx() 方法
        cw.visit(V1_8, ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE, "sample/HelloWorld", null, "java/lang/Object", null);

        {
            FieldVisitor fv1 = cw.visitField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "intValue", "I", null, 100);

            {
                AnnotationVisitor anno = fv1.visitAnnotation("Lsample/MyTag;", false);
                anno.visit("name", "tomcat");
                anno.visit("age", 10);
                anno.visitEnd();
            }

            fv1.visitEnd();
        }

        cw.visitEnd();

        // (3) 调用 toByteArray() 方法
        return cw.toByteArray();
    }
}
