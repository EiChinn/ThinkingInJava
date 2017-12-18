package com.eichinn.typeinfo.example.interfacetypeinfo;

/**
 * Sneaking around an interface
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
//        a.g();//compile error
        System.out.println(a.getClass().getSimpleName());
        if (a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
}

class B implements A {
    @Override
    public void f() {

    }

    public void g(){}
}
