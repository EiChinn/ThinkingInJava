package com.eichinn.string.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ei_chinn on 2017/4/18.
 */
public class TestRegex {
    public static void main(String[] args) {
//        String str = "abcabcabcdefabc";
//        String[] regexs = {"abcabcabcdefabc", "abc+", "(abc)+", "(abc){2,}"};

//        //exercise10
//        String str = "Java now has regular expressions";
//        String[] regexs = {"^Java", "\\Breg.", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.", "s{0,3}"};

        //exercise11
        String str = "Arline ate eight apples and one orange while Anita hadn't any";
        String[] regexs = {"(?i)(^[aeiou]|\\s+[aeiou])\\w+?[aeiou]\\b"};

        for (String s : regexs) {
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.println("Match \"" + matcher.group() + "\" at positions " + matcher.start() + "-" + matcher.end());
            }
            System.out.println();
        }
    }
}
