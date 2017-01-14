package com.eichinn.interfaces;

/**
 * Created by ei_chinn on 2017/1/14.
 */
public class InterfaceCollision {
}

interface I1 {
    void f();
}
interface I2 {
    int f(int i);
}
interface I3 {
    int f();
}

//interface I4 extends I1, I3 {  不能通过返回类型区分重载方法
//}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {
    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return 1;
    }
}

class C4 extends C implements I3 {
    @Override
    public int f() {
        return 1;
    }
}

//class C5 extends C implements I1 { 不能通过返回类型区分重载方法
//}
