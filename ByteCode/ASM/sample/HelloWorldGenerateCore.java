package sample;

import org.objectweb.asm.*;
import lsieun.utils.FileUtils;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author liulei318
 * @version 1.0
 * @project learn-java-asm
 * @description
 * @date 2024/6/28 14:23:54
 */
public class HelloWorldGenerateCore {
    public static void main(String[] args) throws Exception {
        String relative_path="sample/HelloWorldNext.class";
        String filePath = FileUtils.getFilePath(relative_path);
        System.out.println(filePath);

        byte[] bytes = dump();

        FileUtils.writeBytes(filePath,bytes);

    }

    public static byte[] dump() throws Exception{
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_8,ACC_PUBLIC+ACC_SUPER,"sample/HelloWorldNext",null,"java/lang/Object",null);
        {
            MethodVisitor mv1 = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv1.visitCode();
            mv1.visitVarInsn(ALOAD,0);
            mv1.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>","()V",false);
            mv1.visitInsn(RETURN);
            mv1.visitMaxs(0,0);
            mv1.visitEnd();
        }
        {
            MethodVisitor mv2 = classWriter.visitMethod(ACC_PUBLIC, "test", "(I)V", null, null);
            Label elseLabel = new Label();
            Label returnLabel = new Label();

            mv2.visitCode();
            mv2.visitVarInsn(ILOAD,1);
            mv2.visitJumpInsn(IFNE,elseLabel);
            mv2.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv2.visitLdcInsn("value is 0");
            mv2.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv2.visitJumpInsn(GOTO, returnLabel);


            mv2.visitLabel(elseLabel);
            mv2.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv2.visitLdcInsn("value is not 0");
            mv2.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            // 第 3 段
            mv2.visitLabel(returnLabel);
            mv2.visitInsn(RETURN);
            mv2.visitMaxs(0, 0);
            mv2.visitEnd();
        }
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }
}
