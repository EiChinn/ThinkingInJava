package com.eichinn.operators.example;

/**
 * Created by chenrong on 2016/11/8.
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;//Hexadecimal(lowercase)
        System.out.println("i1 in Binary: " + Integer.toBinaryString(i1));
        System.out.println("i1 in Octal: " + Integer.toOctalString(i1));
        System.out.println("i1 in Decimal: " + i1);
        System.out.println("i1 in Hex: " + Integer.toHexString(i1));

        int i2 = 0x2F;//Hexadecimal(uppercase)
        System.out.println("i2 in Binary: " + Integer.toBinaryString(i2));
        System.out.println("i2 in Octal: " + Integer.toOctalString(i2));
        System.out.println("i2 in Decimal: " + i2);
        System.out.println("i2 in Hex: " + Integer.toHexString(i2));

        int i3 = 0177;//Octal(leading zero)
        System.out.println("i3: " + Integer.toBinaryString(i3));
        System.out.println("i3 in Octal: " + Integer.toOctalString(i3));
        System.out.println("i3 in Decimal: " + i3);
        System.out.println("i3 in Hex: " + Integer.toHexString(i3));

        char c = 0xffff;//max char hex value
        System.out.println("c: " + Integer.toBinaryString(c));
        System.out.println("c in Octal: " + Integer.toOctalString(c));
        System.out.println("c in Decimal: " + Integer.toBinaryString(c));
        System.out.println("c in Hex: " + Integer.toHexString(c));

        byte b = 0x7f;//max byte hex value
        System.out.println("b: " + Integer.toBinaryString(b));
        System.out.println("b in Octal: " + Integer.toOctalString(b));
        System.out.println("b in Decimal: " + b);
        System.out.println("b in Hex: " + Integer.toHexString(b));

        short s = 0x7fff;//max short hex value;
        System.out.println("s: " + Integer.toBinaryString(s));
        System.out.println("s in Octal: " + Integer.toOctalString(s));
        System.out.println("s in Decimal: " + s);
        System.out.println("s in Hex: " + Integer.toHexString(s));

        //Hex and Octal also work with long
        long l = 0xffffff;
        System.out.println("l: " + Long.toBinaryString(l));
        System.out.println("l in Octal: " + Long.toOctalString(l));
        System.out.println("l in Decimal: " + l);
        System.out.println("l in Hex: " + Long.toHexString(l));
    }
}
