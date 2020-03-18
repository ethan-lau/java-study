package com.ethan.javaagent;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("main start");
        try {
            test();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }

    public static void test() {
        System.out.println("hehehe");
    }
}
