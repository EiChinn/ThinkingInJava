package com.eichinn.initialization.example;

/**
 * Created by ei_chinn on 2016/11/13.
 * 涉及基本类型的方法重载：如果传入的数据类型（实际参数类型）小于方法中声明的形式参数类型，实际数据类型就会被提升，
 * 按照byte -> short -> int -> long -> float -> double的规律；
 * char型略有不同，如果无法找到恰好接受char参数的方法，就会把char直接提升至int类型，即char -> int；
 * 而常数值（比如：5）则会被直接当作int处理
 */
public class PrimitiveOverloading {
    public static void main(String[] args) {
        PrimitiveOverloading p = new PrimitiveOverloading();
        p.testConstVal();
        p.testChar();
        p.testByte();
        p.testShort();
        p.testInt();
        p.testLong();
        p.testFloat();
        p.testDouble();
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
    private void f2(double x) {
        System.out.print("f2(double)");
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
    private void f3(float x) {
        System.out.print("f3(float)");
    }
    private void f3(double x) {
        System.out.print("f3(double)");
    }

    private void f4(int x) {
        System.out.print("f4(int)");
    }
    private void f4(long x) {
        System.out.print("f4(long)");
    }
    private void f4(float x) {
        System.out.print("f4(float)");
    }
    private void f4(double x) {
        System.out.print("f4(double)");
    }

    private void f5(long x) {
        System.out.print("f5(long)");
    }
    private void f5(float x) {
        System.out.print("f5(float)");
    }
    private void f5(double x) {
        System.out.print("f5(double)");
    }

    private void f6(float x) {
        System.out.print("f6(float)");
    }
    private void f6(double x) {
        System.out.print("f6(double)");
    }

    private void f7(double x) {
        System.out.print("f7(double)");
    }

    private void testConstVal() {
        System.out.print("5: ");
        f1(5);
        f2(5);
        f3(5);
        f4(5);
        f5(5);
        f6(5);
        f7(5);
        System.out.println();
    }

    private void testChar() {
        System.out.print("char: ");
        char x = 'x';
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    private void testByte() {
        System.out.print("byte: ");
        byte x = 0;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    private void testShort() {
        System.out.print("short: ");
        short x = 0;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    private void testInt() {
        System.out.print("int: ");
        int x = 0;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    private void testLong() {
        System.out.print("long: ");
        long x = 0;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    private void testFloat() {
        System.out.print("float: ");
        float x = 0;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }

    private void testDouble() {
        System.out.print("double: ");
        double x = 0;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
        System.out.println();
    }
}
