package com.eichinn.typeinfo.example.interfacetypeinfo;

import java.lang.reflect.Field;

public class ModifyingPrivateFileds {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Class cl = pf.getClass();
        Field i = cl.getDeclaredField("i");
        i.setAccessible(true);
        System.out.println("i = " + i.getInt(pf));
        i.setInt(pf, 47);
        System.out.println(pf);

        Field s = cl.getDeclaredField("s");
        s.setAccessible(true);
        System.out.println("s = " + s.get(pf));
//        s.set(pf, "No, you are not!");
//        System.out.println(pf);

        Field s1 = cl.getDeclaredField("s1");
        s1.setAccessible(true);
        System.out.println("s1 = " + s1.get(pf));
        s1.set(pf, "No, you are not!");
        System.out.println(pf);
    }
}

class WithPrivateFinalField {
    private int i = 1;
    private static final String s = "I'm totally safe";
    private String s1 = "Am I safe?";

    @Override
    public String toString() {
        return "i = " + i + ", " + s + ", " + s1;
    }
}
