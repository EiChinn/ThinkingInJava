package com.eichinn.typeinfo.example.interfacetypeinfo;


public class TestHiddenC {
    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getSimpleName());
        if (a instanceof C) {
            C c = (C)a;
            c.g();
            c.u();
            c.v();
//            c.w(); //private method, can not access
        }
    }
}
