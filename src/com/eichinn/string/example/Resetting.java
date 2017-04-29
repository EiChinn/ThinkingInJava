package com.eichinn.string.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ei_chinn on 2017/4/29.
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find()) {
            System.out.print(m.group() + ",");
        }
        System.out.println();

        //不带参数的reset方法，可以将Matcher对象重新设置到当前字符串序列的起始位置，即用相同的正则表达式对当前字符串再次进行匹配
        m.reset();
        while (m.find()) {
            System.out.print(m.group() + ",");
        }
        System.out.println();

        //带参数的reset方法，可以将将现有的Matcher对象应用于一个新的字符串序列，即用相同的正则表达式对另一个字符串进行匹配
        m.reset("fix the rig with rags");
        while (m.find()) {
            System.out.print(m.group() + ",");
        }

    }
}
