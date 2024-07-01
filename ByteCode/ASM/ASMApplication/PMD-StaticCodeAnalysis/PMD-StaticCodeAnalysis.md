
# PMD static code analysis
[PMD static code analysis](https://github.com/amitdev/PMD-Intellij)。  
[website](https://pmd.github.io/)    
[use plugin](https://plugins.jetbrains.com/plugin/1137-pmd)    

[PMD tool](https://www.cnblogs.com/andy-songwei/p/11830812.html)     
[PMD集成](https://juejin.cn/post/7234893047283597370)

### PMD简介
PMD是一款程序代码检查工具（可支持多种语言），已Java为例，通过静态分析Java源文件来获知代码错误，也就是在不运行不编译Java程序的情况下直接扫描Java源文件，报告错误，该软件功能强大，扫描效率高，是debug的好帮手，它附带了很多可以直接使用的规则，利用这些规则可以找出Java源程序的许多问题    
+ 可能的bug，检查潜在的代码错误，如空try-catch-finally-switch语句
+ 未使用的代码（Dead code）：检查未使用的变量，参数，方法
+ 复杂的表达式：检查不必要的if语句，可被while替代的for循环
+ 重复的代码，检查重复的代码
+ 循环体创建新对象，检查在循环体内实例化新对象
+ 资源关闭：检查connect Result Statement等资源使用之后是否被关闭掉
用户还可以自定义规则，检查Java代码是否符合某些特定的编码规范，例如可以自定义规则，要求PMD找出所有创建Thread对象的操作
PMD 安装 File-->Settings-->Plugins-->Browse repositories 搜索PMD 找到PMDPlugin这一项，安装重启即可。

PMD的核心是JavaCC解析器生成器，PMD结合运用JavaCC和EBNF(扩展巴斯科-诺尔范式。Extended Backus-Naur Formal)语法，再加上JJTree,把Java源代码解析成抽象语法树（AST,Abstract Syntax Tree）,在语法树上查找对应的代码问题。   

[pmd github](https://pmd.github.io/)    
[pmd自定义规则集](https://testerhome.com/topics/4918)    
[pmd自定义规则集-02](https://testerhome.com/topics/5003)    


### 扫描规约：
+ Sonar规约： sonar静态分析工具 支持扫描Java,C等多种语言，还支持单元测试，单元测试底层逻辑依赖的是开源工具JaCoCo    Sonar-Java规约
+ infer规约： 引入facebook的inter静态分析工具 能够扫描代码潜在bug。Java代码中的空指针和资源泄漏。内存泄漏等

### PMD 抽象语法树可视化 工具
1.AST的可视化工具有很多，大家可以自行Google一下。由于我们的自定义规则开发主要是在PMD工具的基础上进行，对其他工具就不再过多介绍，仅以PMD工具举例说明。     
2.PMD工具在使用时建议使用6.45.0以下的软件包，本地需配置Java环境变量。过高版本启动需要Java版本不一样。目前EOS对外开放规则检测能力主要是针对Java8项目。PMD工具包下载链接：https://github.com/pmd/pmd/releases/download/pmd_releases%2F6.45.0/pmd-bin-6.45.0.zip（其他版本可自行查找）     
3.工具使用bin工具包，解压后通过终端进入到bin目录，然后执行./run.sh designer命令启动界面。（如果是pmd7+版本命令需切换成pmd designer）      
可能需要安装配置JavaFX-sdk: https://developer.aliyun.com/article/612799     
[download](https://gluonhq.com/products/javafx/)     
macbook安装需要匹配版本。   
[rule designer docs](https://docs.pmd-code.org/latest/pmd_userdocs_extending_designer_reference.html)

**AST在线阅读器：**
[AST在线阅读器](https://astexplorer.net/)。  

### AST 抽象语法树。（Java Parser）
抽象语法树 运用广泛 比如： 
+ 编辑器的错误提示 代码格式化。代码高亮。代码自动补全
+ elint。pertiier  对代码错误或风格的检查
+ webpack 通过babel转译javascript语法  （前端）

[AST更改代码](https://cloud.tencent.com/developer/article/1068846)。  
[源代码级别AST/字节码级别ASM](https://houbb.github.io/2020/05/29/java-ast-00-overview)    
[AST](https://sumsec.me/2022/CodeQL%E4%B8%8EAST%E4%B9%8B%E9%97%B4%E8%81%94%E7%B3%BB.html)


### 圈复杂度

