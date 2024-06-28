package org.example.asm.sample;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;

/**
 * 预期生成一个类HelloWorld 它对应的代码如下所示
 * package sample;
 *
 * public class HelloWorld{
     * @Override
     * public String toString(){
     *     return "this is a HelloWorld object.";
     * }
 * }
 */

public class HelloWorldDump implements OpCodes {

}
