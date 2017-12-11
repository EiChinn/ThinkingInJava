package com.eichinn.typeinfo.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Using reflection to show all the methods of a class
 * even if the methods are defined in the base class
 */
public class ShowMethods {
    private static final String usage = "usage:\n"
            + "ShowMethods qualified.class.name\n"
            + "To show all methods in class or:\n"
            + "ShowMethods qualified.class.name word\n"
            + "To search for method involving 'word'";
    private static final Pattern p = Pattern.compile("\\w+\\.|static|final");

    public static void main(String[] args) {
        String[] vars = {"com.eichinn.typeinfo.example.ShowMethods"};
        if (vars.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(vars[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if (vars.length == 1) {
                for (Method method : methods) {
                    System.out.println(method);
                    System.out.println(p.matcher(method.toString()).replaceAll(" "));
                }
                for (Constructor constructor : constructors) {
                    System.out.println(constructor);
                    System.out.println(p.matcher(constructor.toString()).replaceAll(" "));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().contains(vars[1])) {
                        System.out.println(method);
                        System.out.println(p.matcher(method.toString()).replaceAll(" "));
                        lines++;
                    }
                }
                for (Constructor constructor : constructors) {
                    if (constructor.toString().contains(vars[1])) {
                        System.out.println(constructor);
                        System.out.println(p.matcher(constructor.toString()).replaceAll(" "));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }

    }
}
