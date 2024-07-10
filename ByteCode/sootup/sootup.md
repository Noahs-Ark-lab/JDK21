# static code analysis

## sootup概述
[csdn](https://blog.csdn.net/qq_59075481/article/details/136383147)     
soot是McGill大学Sable研究小组自1996年开始开发的Java字节码分析工具，提供了多种字节码分析和变换的功能，通过它可以进行过程内和过程间分析优化，以及程序流图的生成，还能通过图形化的方式输出，直观，尤其单元测试时通过生成的控制流图然后进行测试用例覆盖，显著提高效率。     
开发团队已经不再积极维护soot项目，而是改为开发基于maven 的sootup工具，作为soot的现代化扩展，目前sootup在github上开源。   

使用sootup生成控制流程图。       
[sootup-github-io](https://soot-oss.github.io/soot/)     

[sootup高级命令](https://soot-oss.github.io/soot/docs/)     
[sootup McGill University](https://www.brics.dk/SootGuide/)     


## 客户端命令  
### General Options
```
-coffi   使用旧的Coffi前端来解析Java字节码（而不是使用ASM）     
-jasmin-backend   使用Jasmin后端生成Java字节码（而不是使用ASM）     
-h,-help  显示帮助信息并退出     
-pl，-phase-list  打印可用阶段列表      
-ph ARG -phase-help-ARG  打印ARG参数指定的帮助信息     
-version  显示版本信息并退出     
-v,-verbose   使用verbose模式     
-interactive-mode  以交互模式运行     
-unfriendly-mode   允许soot在没有命令行选项的情况下运行     
-app以应用模式运行     
-w  -whole-program  以whole-program (完全程序)模式运行     
-ws -whole-shimple 以whole-shimple(完全shimple)模式运行     
-fly，-on-the-fly。以on-the-fly 模式运行      
-validate  对主体运行内部验证       
-debug。打印各种soot调试信息      
-debug-resolver   从SootResolver打印调试信息       
-ignore-resolving-levels 忽略不匹配的解析级别策略       
-weak-map-structures在场景中使用弱引用，以防止删除许多classes。methods或locals时内存泄漏
```

### Input Options
```
 -cp ARG -soot-class-path ARG -soot-classpath ARG。    
                               使用 ARG 参数作为查找类的类路径。      
 -soot-modulepath ARG          使用 ARG 参数作为查找类的模块路径。      
 -pp, -prepend-classpath       将给定的 Soot 类路径添加到默认的 Soot 类路径中。      
 -ice, -ignore-classpath-errors      
                               忽略 Soot 类路径上的无效条目。      
 -process-multiple-dex         处理 APK 中找到的所有 DEX 文件。      
 -search-dex-in-archives       在提供的类路径下搜索 DEX 文件时，还包括 Jar 和 Zip 文件。      
 -process-path ARG -process-dir ARG      
                               处理 ARG 参数指定的路径下找到的所有类。      
 -oaat                         在给定的 process-dir 文件夹中，强制一次只处理一个类。      
 -android-jars ARG             使用 ARG 参数作为检索 android.jar 文件的路径。      
 -force-android-jar ARG        强制 Soot 使用 ARG 参数作为 android.jar 文件的路径。      
 -ast-metrics                  如果指定由 java 代码转换到 jimple 中间代码，则计算 AST 度量。      
 -src-prec ARG                 设置 ARG 参数指定的源文件类型优先级，支持下面的源文件类型：      
    c class (默认)               优先选择 .class 文件作为 Soot 读取的源文件类型。      
    only-class                   只使用 .class 文件作为 Soot 读取的源文件类型。      
    J jimple                     优先选择 .jimple 文件作为 Soot 读取的源文件类型。      
    java                         优先选择 .java 文件作为 Soot 读取的源文件类型。      
    apk                          优先选择 .apk 文件作为 Soot 读取的源文件类型。      
    apk-class-jimple apk-c-j     优先选择 .apk 文件作为 Soot 读取的源文件类型，并忽略解析 .java 文件。      
 -full-resolver                强制被引用类的传递性解析。      
 -allow-phantom-refs           允许未解析的类;可能导致错误。      
 -allow-phantom-elms           允许非幻影类 (Phantom Classes) 中的幻影方法和字段。      
 -no-bodies-for-excluded       不加载被排除类的主体。      
 -j2me                         使用 J2ME 模式; 更改类型的赋值。      
 -main-class ARG               ARG 参数指定整个待解析程序的主类。      
 -polyglot                     使用 Java 1.4 Polyglot 前端，而不是 JastAdd。      
 -permissive-resolving         当使用常规解析策略无法找到类时，使用替代的源文件      
 -drop-bodies-after-load       在完成加载方法主体 (The method body) 的任务后删除方法源 (The method source)。
``` 

### output options
```
 -d ARG -output-dir ARG        将输出文件保存到 ARG 参数指定的目录       
 -f ARG -output-format ARG     设置 Soot 的输出文件格式，支持下面列出的格式之一。     
    J jimple                     生成 .jimple 文件      
    j jimp                       生成 .jimp (Jimple 的缩写) 文件      
    S shimple                    生成 .shimple 文件      
    s shimp                      生成 .shimp (abbreviated Shimple) 文件      
    B baf                        生成 .baf 文件      
    b                            生成 .b (abbreviated Baf) 文件      
    G grimple                    生成 .grimple 文件      
    g grimp                      生成 .grimp (abbreviated Grimp) 文件       
    X xml                        生成 .xml 文件       
    dex                          生成 Dalvik 虚拟机文件       
    force-dex                    生成 Dalvik DEX 文件      
    n none                       不输出任何文件      
    jasmin                       生成 .jasmin 文件      
    c class (default)            生成 .class 文件      
    d dava                       生成反编译数据的 .java 文件       
    t template                   使用 Jimple 模板生成 .java 文件      
    a asm                        生成 .asm 文件，使用 ASM 后端生成的文本字节码表示形式。      
 -java-version ARG             ARG 参数强制 Soot 生成适应于指定 Java 版本的字节码。       
    default                      （默认）让 Soot 确定生成的字节码的 Java 版本。      
    1.1 1                        强制 Java 1.1 作为输出版本。      
    1.2 2                        强制 Java 1.2 作为输出版本。      
    1.3 3                        强制 Java 1.3 作为输出版本。      
    1.4 4                        强制 Java 1.4 作为输出版本。      
    1.5 5                        强制 Java 1.5 作为输出版本。      
    1.6 6                        强制 Java 1.6 作为输出版本。      
    1.7 7                        强制 Java 1.7 作为输出版本。      
    1.8 8                        强制 Java 1.8 作为输出版本。       
    1.9 9                        强制 Java 1.9 作为输出版本（实验性）。       
 -outjar, -output-jar          使输出目录作为 jar 文件路径而不是一个目录。      
 -hierarchy-dirs               为 Jimple 和 Shimple 生成类层次目录。      
 -xml-attributes               将标签作为 Eclipse 支持的 XML 属性格式保存。      
 -print-tags, -print-tags-in-output       
                               在 stmt 之后的输出文件中打印标签。      
 -no-output-source-file-attribute      
                               在生成类文件时不要输出源文件的属性。      
 -no-output-inner-classes-attribute      
                               不要在类文件中输出内部类的属性。      
 -dump-body ARG                在ARG参数指定的阶段开始之前和完成之后分别转储每个方法的内部表示。      
 -dump-cfg ARG                 转储 ARG 参数指定的阶段执行期间构建的每个 CFG 的内部表示。
 -show-exception-dests         在转储的一个或多个 CFG 中包括异常处理目标边 (Exception Destination Edges) 以及 CFG 边      
 -gzip                         使用 GZip 算法对 IR (中间代码表示)的输出文件进行压缩      
 -force-overwrite              强制覆盖输出文件。      
————————————————
```

### Processing Options
```
 -plugin ARG                   加载 ARG 参数指定路径下的所有插件      
 -wrong-staticness ARG         忽略或修复由静态分析错误引发的错误，ARG 参数指定的错误提示级别可以是下面各项之一。      
    fail                         当检测到静态分析错误时引发错误      
    ignore                       忽略由静态分析错误引发的错误      
    fix                          透明化修复静态错误     
    fixstrict (default)          (默认)透明化修复静态错误，但不忽略剩余的错误      
 -field-type-mismatches ARG    ARG 参数指定在解析类型不匹配的字段引用时如何处理错误。处理方式可以是下面各项之一。     
    fail                         当检测到字段类型不匹配时引发错误。      
    ignore                       忽略字段类型不匹配的异常。      
    null (default)               (默认)类型不匹配时返回 null。      
 -p ARG -phase-option ARG      ARG 参数设置指定 PHASE 的 OPT 选项值。      
 -O, -optimize                 执行程序内部局部代码优化      
 -W, -whole-optimize           执行完整程序的代码优化      
 -via-grimp                    通过 Grimp 格式转换字节码，而不是通过 Baf       
 -via-shimple                  启用简单 SSA 表示      
 -throw-analysis ARG            ARG 参数指定分析抛出的模式。可以是以下模式之一。      
    pedantic                     以十分迂腐保守的方式给出 抛出异常 (throw) 分析结果      
    unit (default)               以单元分析的方式给出 抛出异常 (throw) 的分析结果      
    dalvik                       以兼容 Dalvik 虚拟机的方式给出 抛出异常 (throw) 的分析结果      
 -check-init-ta ARG -check-init-throw-analysis ARG      
                                检查指定的初始化抛出异常分析模式      
    auto (default)               (默认)自动选择一个 抛出异常 (throw) 的分析模式      
    pedantic                     十分迂腐保守的 抛出异常 (throw) 分析      
    unit                         指定单元的 抛出异常 (throw) 分析      
    dalvik                       Dalvik 虚拟机的 抛出异常 (throw) 分析          
 -omit-excepting-unit-edges    从没有副作用的额外单元中省略处理程序的 CFG 边        
 -trim-cfgs                    从 CFGs 中修剪不可实现的异常边(不可达边)         
 -ire, -ignore-resolution-errors       
                               当程序引用未声明的字段或方法时不会抛出异常。       
————————————————
```

### Application Mode Options  
```
 -i ARG -include ARG           将 ARG 参数指定的所有类作为应用程序类       
 -x ARG -exclude ARG           从应用程序类中排除 ARG 参数指定的所有类       
 -include-all                  设置默认排除包为空列表         
 -dynamic-class ARG            注意 ARG 参数指定的类可能是动态加载的         
 -dynamic-dir ARG              将 ARG 参数指定文件夹中的所有类标记为潜在的动态链接文件      
 -dynamic-package ARG          将 ARG 参数指定的包中的类标记为潜在的动态链接文件       

————————————————
```

### Input Attribute Options       
```
 -keep-line-number             保留行号表        
 -keep-bytecode-offset, -keep-offset        附加字节码偏移到 IR (中间代码)
```     

### Output Attribute Options   
```
-write-local-annotations      在本地名称上写出调试注释
```


### Annotation Options
```
 -annot-purity                 输出 纯度 (purity) 属性       
 -annot-nullpointer            输出 空指针 属性      
 -annot-arraybounds            输出 数组边界检查 属性       
 -annot-side-effect            输出 副作用 属性       
 -annot-fieldrw                输出 字段读/写 属性       

————————————————
```  

### Miscellaneous options
```
 -time                         报告转换所需的时间      
 -subtract-gc                  从时间中减去 gc       
 -no-writeout-body-releasing   禁止在写出 (Writeout) 之后释放方法体(Method Bodies)。此标志仅供在内部测试使用       
————————————————
```

## Sootup
[Learning Program Analysis](https://github.com/SugarP1g/Learning-Program-analysis)      

北大-熊英飞-软件分析       
[初识软件分析](https://blog-blockchain.xyz/pl/understanding-program-analysis/)     

































