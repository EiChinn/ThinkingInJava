package com.eichinn.typeinfo.example.interfacetypeinfo.testpackage;


import com.eichinn.typeinfo.example.interfacetypeinfo.A;
import com.eichinn.typeinfo.example.interfacetypeinfo.HiddenC;

import java.lang.reflect.Method;

public class TestHiddenC {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        A c = HiddenC.makeC();
//        C a = HiddenC.makeC();
        a.f();
        System.out.println(a.getClass().getSimpleName());
//        if (a instanceof C) {
//            C c = (C)a;
//            c.g();
//            c.u();
//            c.v();
////            c.w(); //private method, can not access
//        }

        //Oops, Reflection still allow us to call g()
        System.out.println("-------------------------");
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");

    }

    public static void callHiddenMethod(Object o, String methodName) throws Exception {
        Class cl = o.getClass();
//        Method method = cl.getMethod(methodName, new Class[]{});
        Method method = cl.getDeclaredMethod(methodName, new Class[]{});
        //or if no args
//        Method method = cl.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o, new Object[]{});
        //or if no args
//        method.invoke(o);
    }
}
