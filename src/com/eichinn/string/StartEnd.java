package com.eichinn.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * find() 可以在string但任意位置定位regex
 * lookingAt() 只有在string与regex的最开始处就开始匹配才会返回true
 * matches() 只有在整个string都匹配regex才会返回true
 * Created by ei_chinn on 2017/4/23.
 */
public class StartEnd {
    private static final String INPUT = "As long as there is injustice. whenever a\n"
            + "Targathian baby cries out. wherever a distress\n"
            + "sianal sounds among the stars ... We'll be there.\n"
            + "This fine ship. and this fine crew ...\n"
            + "Never give up! Never surrender!"
            ;

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        public Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }

    }

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        while (m.find()) {
            d.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
        }

        if (m.lookingAt()) {
            d.display("lookingAt() start = " + m.start() + " end = " + m.end());
        }

        if (m.matches()) {
            d.display("matches() start = " + m.start() + " end = " + m.end());
        }
    }

    public static void main(String[] args) {
        for (String in : INPUT.split("\n")) {
            System.out.println("input : " + in);
            for (String regex : new String[]{"\\w*ere\\w*", "\\w*ever", "T\\w*", "Never.*?!"}) {// *? 懒惰限定符：重复任意次，但尽可能少重复
                examine(in, regex);
            }
        }
    }

}
