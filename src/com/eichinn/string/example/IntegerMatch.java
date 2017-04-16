package com.eichinn.string.example;

/**
 * the usage of string.matches(String regex);
 * string.matches(String regex)是应用正则表达式最简单的途径
 * Created by ei_chinn on 2017/4/16.
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
