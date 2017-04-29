package com.eichinn.string.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * appendReplacement执行渐进式替换，而不是想replaceFirst和replaceAll那样只替换第一个匹配或者全部匹配。
 * appendReplacement允许你调用其他方法来生成或者处理replacement，replaceFirst和replaceAll则只能使用一个固定的字符串
 * appendTail 在执行了一次或者多次appendReplacement之后，调用此方法可以将输入字符串余下的部分复制到StringBuffer中
 * Created by ei_chinn on 2017/4/26.
 */
public class TheReplacements {
    public static void main(String[] args) {
        String str = "/*! Here's a block of text to use as input to\n" +
                " the regular expression matcher, Note that we'll\n" +
                " first extract the block of text by looking for\n" +
                " the special delimiters, then process the extracted block !*/";

        //matcher the specially commented block of text above
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(str);//Pattern.DOTALL: "."匹配所有字符，包括换行符
        if (mInput.find()) {
            str = mInput.group(1);//Captured by parentheses
        }
        //Replace two or more spaces with a single space
        str = str.replaceAll(" {2,}", "");
        //Replace one or more spaces at the beginning of each line with no spaces. Must enable MULTILINE mode
        str = str.replaceAll("(?m)^ +", "");
//        System.out.println(str);

        str = str.replaceFirst("[aeiou]", "(vowel1)");

        StringBuffer sb = new StringBuffer(128);
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(str);
        // Process the find information as you perform the replacement
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
        }
        m.appendTail(sb);
        System.out.println(sb.toString());

        String s = "abcdefghijklmnopqrstuvwxyz";
        Pattern pattern = Pattern.compile("(a)(b)(c)(d)(e)(f)(g)(h)(i)(j)(k)");
        Matcher matcher = pattern.matcher(s);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, "$11bar");//$g，引用匹配到的字符串中的group(g)，此处为1，即此处的"$1bar"等同于"oobar"
//            matcher.appendReplacement(buffer, matcher.group(1) + "bar");//$g，引用匹配到的字符串中的group(g)，此处为1，即此处的"$1bar"等同于"oobar"
        }
        matcher.appendTail(buffer);
        System.out.println(buffer.toString());
    }
}
