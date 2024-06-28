# ASM概述

ASM is an open source java library for manipulating java byte code

## ASM Core API
### 第一章 ASM 介绍
+ 1、ASM介绍
ASM是一个操作Java字节码的类库，为了更好的理解ASM,需要搞清楚两个问题，
第一个问题就是，ASM的操作对象是什么，ASM的操作对象是字节码数据ByteCode
一个.java文件经过Java编译器编译之后会生成一个.class文件，在.class文件中，存储的是字节码数据，字节码的具体表现形式就是.class文件
第二个问题就是：ASM如何处理字节码数据
 ASM处理字节码的方式是“拆分-修改-合并”
第一步，将.class文件拆分成多个部分，第二步，对某一个部分的信息进行修改，第三步：将多个部分重新组织成一个新的.class文件
ASM provides a simple API for decomposing,modifing ,and recomposing binary java classes (from Wikipedia)

ASM 并不是一些单词的首字母缩写，the ASM name does not mean anything :it is just a reference to the asm keyword in C ,which allows some functions
to be implemented in assembly language

ASM版本的发展
Java语言在不断地发展，ASM版本也需要不断地发展来跟上Java的发展
Java8 需要使用ASM5.0版本 Java11需要使用ASM7.0版本 尽可能使用更高的版本

![ASM can do: Analysis   generation transformation](./../../images/[1]ASMcando.png)



+ 2、ASM组成部分
+ 3、ASM与ClassFile
+ 4、ClassFile快速参考
 Java ClassFile
对于一个具体的.class而言，它遵循ClassFile结构，这个数据结构位于[Java Virtual Machine Specification](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html) 的[The class File format](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html)部分
```
ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
```
其中：
+ u1:表示占用1个字节
+ u2:表示占用2个字节
+ u4:表示占用4个字节
+ u8:表示占用8个字节
cp_info、field_info、method_info、attribute_info表示较为复杂的结构，但是他们也是由u1、u2、u4和u8组成的
相应的，在.class文件当中，定义的字段，要遵循field_info结构



+ 5、如何编写ASM代码

### 第二章 生成新的类 从0到1 从无到有 生成
+ 1、ClassVisitor介绍
+ 2、ClassWriter介绍
+ 3、ClassWriter代码示例
+ 4、FieldVisitor介绍
+ 5、FieldWriter介绍
+ 6、MethodVisitor介绍
+ 7、MethodWriter介绍
+ 8、方法的初始Frame
  JVM Architecture由 Class Loader SubSystem,Runtime Data Areas和 Execution Engine三个部分组成 ，其中Runtime Data Areas包括Method Area 、Heap Area 、stack area 、PC Register和Native Method Stack等部分
在程序运行的过程中，每个线程Thread 都对应都对应一个属于自己的JVM Stack当一个新线程开始的时候，就会在内存上分配一个属于自己的JVM Stack；当该线程执行结束的时候，相应JVM Stack内存空间也就被回收了
在JVM Stack 当中，存储的是stack frame,当调用一个新方法的时候，就会在JVM Stack上分配一个frame空间，入栈操作，当方法退出时，相应frame空间也会JVM Stack上进行清除，出栈操作
在Stack Frame内存空间中，有两个重要的结构，即Local Variables 和operand stack，都会有一个开始状态和结束状态

operand stack是一个栈结构
local variables是一个数组
对于每一个方法来说，都是在自己的stack frame上来运行的
在编译的时候(compile time),local variables和 operand stack的空间大小就确定下来了，比如，一个.java文件经过编译之后，得到一个.class文件，对于其中的某一个方法来说，它的local variable占用10个slot空间 operand stack占用4个slot空间

在运行的时候，在local variables和operand stack上存放的数据会随着方法的执行不断发生变化

方法的初始化栈帧 ，operand stack是空的，不需要存储任何数据，而local variables的初始状态，则需要考虑两个因素
 是否需要存储this,通过判断方法是否为static,如果方法是static，则不需要存储this，如果当前方法是non-static的，则需要在local variables索引为0的位置存在一个this变量
 当前方法是和否接受参数，方法接收的参数，会按照声明的顺序放到local variables中，如果方法参数不是long double类型，那么它在local variable当中占用1个位置
 如果当前方法的参数是long double类型 那么它在local variable当中占用2个位置
  
+ 9、MethodVisitor代码示例
+ 10、label介绍

程序设计中，有三种基本控制结构：顺序 选择 和循环，在bytecode层面，只存在两种 顺序（sequence）和跳转（jump）两种指令执行顺序 instruction
  那么ASM中的label类的作用是什么？MethodVisitor类是用于生成方法体的代码，如果没有label类的参与，那么MethodVisitor类只能生成顺序结构的代码，如果有label类的参与，那么MethodVisitor类就能生成选择和循环结构的代码
  
+ 11、Label代码示例
 通过ASM生成.class文件  
通过ASM生成HelloWorldNext.java对应的字节码，其中目标.class如下所示。HelloWorldNext.java---->HelloWorldNext.class  

首先对FileUtils使用，在target/classes目录下生成.class文件  

定义相对路径，比如文件夹samples下生成HelloWorldNext.class   String relative_path="samples/HelloWorldNext.class"  

获取编译之后的绝对路径。 String filePath = FileUtils.getFilePath(relative_path);  

获取 asm生成的字节码文件 byte[] 通过FileUtils.writeBytes(filePath,bytes);将byte[]数组写入对应的路径 
[filePath](/Users/liulei318/Documents/goldstine_workspace/coding/Github/learn-java-asm/target/classes/sample/HelloWorldNext.class)
[写入byte数组](file:///Users/liulei318/Documents/goldstine_workspace/coding/Github/learn-java-asm/target/classes/sample/HelloWorldNext.class)
 
```
public static byte[] dump() throws Exception{
  //获取字节码输出asm ClassWriter
  ClassWriter classWriter=new ClassWriter(ClassWriter.COMPUTE_FRAMES);
  //定义classWriter对应的属性，classFile版本 访问标志accessFlag 等
  classWriter.visit(V1_8,ACC_PUBLIC+ACC_SUPER,"sample/HelloWorldNext",null,"java/lang/Object",null);
  {
    // 获取MethodVisitor对象，首先获取构造方法的字节码
    MethodVisitor mv1 = classWriter.visitMethod(ACC_PUBLIC,"<init>","()V",null,null);
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
            mv2.visitMaxs(0, 0);       // 其中 visitCode()  visitMaxs()   visitEnd()仅执行一次，标志着方法字节码访问的开始和结束
            mv2.visitEnd();
  }
 classWriter.visitEnd();
        return classWriter.toByteArray();
}
```
常用api：
visitFieldLnsn:访问 某个成员变量的指令，支持GETSTATIC,PUTSTATIC,GETFIELD,PUTFIELD
visitFrame: 访问当前局部变量表和操作数栈中元素的状态，参数就是局部变量表和操作数栈的内容
visitlinclnsn: 访问自增指令
visitVarLnsn:访问局部变量指令，就是取局部变量变的值放入操作数栈
visitMethodlnsn:访问方法指令，就是调用某个方法，支持INVOKEVIRTUAL,INVOKESPECIAL INVOKESTATIC INVOKEINTERFACE
visitlnsn:访问无操作数的指令，例如 nop duo等等
visitTypelnsn:访问type指令，即将一个类的全限定名作为参数然后new一个对象压入操作数栈中

参考：
[ASM指南｜计算机技术实践](https://mwping.github.io/android/asm.html)
[ASM code](https://github.com/AndroidAdvanceWithGeektime/Chapter-ASM/blob/master/asm-gradle-plugin/src/main/java/com/geektime/asm/ASMCode.java)
[ASM使用](https://www.cnblogs.com/tr1ple/p/12800859.html)
[局部变量表和操作数栈](https://juejin.cn/post/6844903693553238023)
[ASM](https://blog.csdn.net/it_freshman/article/details/81156106)

+ 12、frame介绍
+ 13、Opcodes介绍
+


### 第三章 转换已有的类 class文件增强
+ 1、ClassReader介绍
+ 2、ClassReader代码示例
+ 3、Class Transformation的原理
+ 4、Type介绍
+ 5、修改已有的方法（添加-进入和退出）
+ 6、修改已有的方法（添加-进入和退出-打印方法参数和返回值）
+ 7、修改已有的方法（添加-进入和退出-方法计时）
+ 8、修改已有的方法（删除-移除Instruction）
+ 9、修改已有的方法（删除-清空方法体）
+ 10、修改已有的方法（修改-替换方法调用）
+ 11、查找已有的方法（查找-方法调用）
+ 12、修改已有的方法（优化-删除-去掉没有必要的Instruction)



### 工具类和常用类
+ 1、asm-util和asm-commons   
  在asm-util中，主要介绍CheckClassAdapter和TraceClassVisitor类，在TraceClassVisitor类当中，会涉及到Printer，ASMifier和Textifier类
｜asm-util｜CheckClassAdapter
          ｜TraceClassVisitor|printer:ASMifier、Textifier
            PrinterWriter
 其中，CheckClassAdapter类，主要负责检查(Check)生成的.class文件内容是否正确
其中，TraceClassVisitor类，主要负责将.class文件的内容打印成文字输出，根据输出的文字信息，可以探索或追踪（Trace）.class文件内部的信息

在ams-commons.jar中，包括的类比较多，主要可以分为两组ClassVisitor的子类，另一组是MethodVisitor的子类
+ 其中，ClassVisitor的子类有 ClassRemapper   StaticInitMerger  和 SerialVersionUIDAdder类
+ MethodVisitor的子类有LocalVariableSorter  GeneratorAdapter   AdviceAdapter  AnalyzerAdapter   和 InstructionAdapter类

asm-commons.jar和asm-util的区别，
asm-util.jar提供的是通用性的功能，没有特别明确的使用场景，而在asm-commons.jar里，它提供的功能，都是为解决某一种特定场景中出现的问题而提出的解决思路
asm-util.jar 和asm-commons.jar两者都对asm.jar  asm-tree.jar asm-analysis.jar有依赖

> asm.jar  和 asm-util.jar的使用
> 通过asm.jar和asm-util.jar输出现有.java文件的 asm 生成.class的代码文件[asmifier的使用](https://blog.csdn.net/yizhizouxiaqu/article/details/7636884)
  
+ 2、CheckClassAdapter介绍
+ 3、TraceClassVisitor介绍
+ 4、Printer/ASMifier/Textifier
+ 5、AdviceAdapter介绍
+ 6、GeneratorAdapter介绍
+ 7、LocalVariablesSorter介绍
+ 8、AnalyzerAdapter介绍
+ 9、InstructionAdapter介绍
+ 10、ClassRemapper介绍
+ 11、StaticInitMerger介绍
+ 12、SerialVersionUIDAdder介绍



参考：
[lsieun github主页](https://lsieun.github.io/)
[视频教程](https://space.bilibili.com/1321054247?spm_id_from=333.788.0.0)


