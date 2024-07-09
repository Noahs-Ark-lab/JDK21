package org.example.asm.asmBase.fieldvisitor.constField;

import java.lang.reflect.Field;

public class HelloWorldRun {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("sample.HelloWorld");
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields.length > 0) {
            System.out.println("fields:");
            for (Field f : declaredFields) {
                Object value = f.get(null);
                System.out.println("    " + f.getName() + ": " + value);
            }
        }
    }
}
