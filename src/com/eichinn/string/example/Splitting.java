package com.eichinn.string.example;

import java.util.Arrays;

/**
 * the usage of string.split(String regex)
 * Created by ei_chinn on 2017/4/16.
 */
public class Splitting {
    private static String knights = "Then. when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!";
    private static String test = "boo:and:foo";

    private static void split(String regex) {
        //使用split方法时，在原始字符串中与正则表达式匹配的部分，在最终结果中都不存在了
        System.out.println(Arrays.toString(knights.split(regex)));
    }
    private static void split(String regex, int times) {
        //使用split方法时，在原始字符串中与正则表达式匹配的部分，在最终结果中都不存在了
        System.out.println(Arrays.toString(test.split(regex, times)));
    }
    public static void main(String[] args) {
//        split(" ");
//        split("\\W+");
//        split("n\\W+");

//        split(":", 2);
//        split(":", 5);
//        split(":", -2);
//        split("o", -2);
//        split("oo", -2);
//        split("oo", 0);

        //exercise7
        System.out.println(knights.matches("^[A-Z].*\\.$"));

        //exercise8
        split("the|you");

        //exercise9
        System.out.println(knights.replaceAll("[aeiou]", "_"));





    }
}
