package com.eichinn.innerclasses.p3;

import com.eichinn.innerclasses.p1.I1;
import com.eichinn.innerclasses.p2.C1;

/**
 * Created by ei_chinn on 2017/2/2.
 */
public class C2 extends C1 {
    public I1 g() {
        return new I1Impl();//内部类必须显式声明一个public的构造方法？
    }

    public static void main(String[] args) {
        C2 c2 = new C2();
        c2.g().f();
    }

//    protected class I1Impl implements I1 {
//        //need public constructor to create one in C1 child
//        public I1Impl() {
//        }
//
//        @Override
//        public void f() {
//
//        }
//    }
}
