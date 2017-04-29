package com.eichinn.string.example;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Created by ei_chinn on 2017/4/29.
 */
public class ThreatAnalyzer {
    public static void main(String[] args) {
        String threatData = "58.27.82.161@02/10/2005\n"
                + "58.27.82.161@02/10/2005\n"
                + "58.27.82.161@02/10/2005\n"
                + "58.27.82.161@02/10/2005\n"
                + "58.27.82.161@02/10/2005\n"
                + "58.27.82.161@02/10/2005\n"
                ;

        Scanner scanner = new Scanner(threatData);
        //注意：scanner使用pattern时，仅仅针对下一个输入分词进行匹配，所以如果你的正则表达式中含有scanner当定界符，那是永远都不可能匹配成功的
        //scanner当前使用的定界符可以调用delimiter方法，返回一个Pattern对象
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);//当next方法配合指定当正则表达式使用时，将找到洗衣歌匹配该模式当输入部分
            MatchResult matchResult = scanner.match();//调用match方法就可以获得匹配当结果
            String ip = matchResult.group(1);
            String date = matchResult.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
    }
}
