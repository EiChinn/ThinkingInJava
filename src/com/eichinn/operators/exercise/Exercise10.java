package com.eichinn.operators.exercise;

/**
 * Created by chenrong on 2016/11/9.
 */
public class Exercise10 {
    public static void main(String[] args) {
        int i1 = 0xffff000a;
        int i2 = 0xffff9b;
        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(i2));

        System.out.println(Integer.toBinaryString(i1 & i2));
        System.out.println(Integer.toBinaryString(i1 | i2));
        System.out.println(Integer.toBinaryString(i1 ^ i2));
        System.out.println(Integer.toBinaryString(~i1));
        System.out.println(Integer.toBinaryString(~i2));
    }
}
