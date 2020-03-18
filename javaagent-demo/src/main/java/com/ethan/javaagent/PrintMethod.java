package com.ethan.javaagent;

/**
 * @author liuhanlong
 * @date 2020/3/17
 */
public class PrintMethod {
    private static volatile int stack = 0;

    public static void enterMethod(String methodName) {
        for (int i = 0; i < stack; i++) {
            System.out.print("  ");
        }
        System.out.println(methodName);
        stack ++;
    }

    public static void leaveMethod(String methodName) {
        stack --;
    }

}
