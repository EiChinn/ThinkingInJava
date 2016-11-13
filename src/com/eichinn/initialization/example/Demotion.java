package com.eichinn.initialization.example;

/**
 * Created by ei_chinn on 2016/11/13.
 * 方法接受较小的基本类型作为参数，如果传入的实际参数较大，则编译器会要求作出强制向下转型
 */
public class Demotion {

    public static void main(String[] args) {
        Demotion d = new Demotion();
        d.testDouble();
    }

    private void testDouble() {
        System.out.print("double argument: ");
        double x = 0;
        f1(x);
        f2((float)x);
        f3((long)x);
        f4((int)x);
        f5((short)x);
        f6((byte)x);
        f7((char)x);
        System.out.println();
    }

    private void f1(char x) {
        System.out.print("f1(char)");
    }
    private void f1(byte x) {
        System.out.print("f1(byte)");
    }
    private void f1(short x) {
        System.out.print("f1(short)");
    }
    private void f1(int x) {
        System.out.print("f1(int)");
    }
    private void f1(long x) {
        System.out.print("f1(long)");
    }
    private void f1(float x) {
        System.out.print("f1(float)");
    }
    private void f1(double x) {
        System.out.print("f1(double)");
    }

    private void f2(char x) {
        System.out.print("f2(char)");
    }
    private void f2(byte x) {
        System.out.print("f2(byte)");
    }
    private void f2(short x) {
        System.out.print("f2(short)");
    }
    private void f2(int x) {
        System.out.print("f2(int)");
    }
    private void f2(long x) {
        System.out.print("f2(long)");
    }
    private void f2(float x) {
        System.out.print("f2(float)");
    }

    private void f3(char x) {
        System.out.print("f3(char)");
    }
    private void f3(byte x) {
        System.out.print("f3(byte)");
    }
    private void f3(short x) {
        System.out.print("f3(short)");
    }
    private void f3(int x) {
        System.out.print("f3(int)");
    }
    private void f3(long x) {
        System.out.print("f3(long)");
    }

    private void f4(char x) {
        System.out.print("f4(char)");
    }
    private void f4(byte x) {
        System.out.print("f4(byte)");
    }
    private void f4(short x) {
        System.out.print("f4(short)");
    }
    private void f4(int x) {
        System.out.print("f4(int)");
    }

    private void f5(char x) {
        System.out.print("f5(char)");
    }
    private void f5(byte x) {
        System.out.print("f5(byte)");
    }
    private void f5(short x) {
        System.out.print("f5(short)");
    }

    private void f6(char x) {
        System.out.print("f6(char)");
    }
    private void f6(byte x) {
        System.out.print("f6(byte)");
    }

    private void f7(char x) {
        System.out.print("f7(char)");
    }
}
