
# PMD static code analysis
[PMD static code analysis](https://github.com/amitdev/PMD-Intellij)
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



