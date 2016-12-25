package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2016/12/25.
 */
public class PrivateOverride {
    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();//执行的是PrivateOverride的f(),private方法的调用不是多态的。
    }
}

class Derived extends PrivateOverride {
//    @Override 父类的private方法被自动认为是final的，对子类屏蔽，不可被override，所以这里的f()被视为是子类的新增方法
    public void f() {
        System.out.println("public f()");
    }
}
