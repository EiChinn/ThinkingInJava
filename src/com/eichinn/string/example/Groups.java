package com.eichinn.string.example;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ei_chinn on 2017/4/20.
 */
public class Groups {
    private static final String POEM = "Twas brilling. and the slithy toves\n"
            + "Did gyre and gimble in the wabe.\n"
            + "All mimsy were the borogoves,\n"
            + "And the mome raths outgrade.\n\n"
            + "Beware the Jabberwock, my son,\n"
            + "The jaws that bite. the claws that catch.\n"
            + "Beware the Jubjub bird, and shun\n"
            + "The frumious Bandersnatch.\n"
            ;

    public static void main(String[] args) {
        /*Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);//(?m)开启多行模式，匹配每一行最后三个词
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                //组0是匹配到的整个字符串，而不是POEM
                System.out.println("[" + m.group(i) + "]");
            }
            System.out.println();
        }*/

        //exercise12
        Pattern pattern = Pattern.compile("\\s+([^\n+A-Z]\\w+)");
        Matcher matcher = pattern.matcher(POEM);
        Set<String> words = new HashSet<>();
        while (matcher.find()) {
            words.add(matcher.group(1));
        }
        System.out.println(words.size() + "");
    }
}
