package com.eichinn.operators.exercise;

/**
 * Created by chenrong on 2016/11/10.
 */
public class Exercise12 {
    public static void main(String[] args) {
        int i1 = 0xffff;
        System.out.println(Integer.toBinaryString(i1));

        i1 <<= 1;
        System.out.println(Integer.toBinaryString(i1));
        for (int i = 0; i < 17; i++) {
            i1 >>= 1;
            System.out.println(Integer.toBinaryString(i1));

        }
    }
}
