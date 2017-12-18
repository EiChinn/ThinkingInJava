package com.eichinn.typeinfo.example.interfacetypeinfo;

public class HiddenC {
    public static A makeA() {
        return new C();
    }
    public static C makeC() {
        return new C();
    }

    public static void main(String[] args) {
        A a = makeA();
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

class C implements A {
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
