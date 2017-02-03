package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/2.
 */
public class Ex7 {
    private int i = 7;
    private void f() {
        System.out.println("i is : " + i);
    }

    class Inner {
        void g() {
            i = 11;
            f();
        }
    }

    void h() {
        Inner inner = new Inner();
        inner.g();
    }

    public static void main(String[] args) {
        Ex7 ex7 = new Ex7();
        System.out.println("before h()");
        ex7.f();
        ex7.h();
        System.out.println("after h()");
        ex7.f();
    }

}
