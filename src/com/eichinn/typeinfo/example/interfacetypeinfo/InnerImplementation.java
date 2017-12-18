package com.eichinn.typeinfo.example.interfacetypeinfo;

import com.eichinn.typeinfo.example.interfacetypeinfo.testpackage.TestHiddenC;

import static com.eichinn.typeinfo.example.interfacetypeinfo.testpackage.TestHiddenC.callHiddenMethod;

/*
private inner classes can't hide from inflection
 */
public class InnerImplementation {
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
}

class InnerA {
    private static class C implements A {
        @Override
        public void f() {
            System.out.println("C.f()");
        }

        public void g() {
            System.out.println("C.g()");
        }

        void u() {
            System.out.println("package u()");
        }

        protected void v() {
            System.out.println("protected v()");
        }

        private void w() {
            System.out.println("private w()");
        }
    }

    public static A makeA() {
        return new C();
    }
}
