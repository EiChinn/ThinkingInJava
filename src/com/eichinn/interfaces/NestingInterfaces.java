package com.eichinn.interfaces;

/**
 * Created by ei_chinn on 2017/1/15.
 */
public class NestingInterfaces {
    public class BImpl implements A.B {

        @Override
        public void f() {

        }
    }

    class CImpl implements A.C {
        @Override
        public void f() {

        }
    }

    //Cannot implement a private interface except within that interface's defining class
//    class DImpl implements A.D {}

    class EImpl implements E {//当实现某个接口时，并不需要实现嵌套在其内的任何接口，而且，private接口不能在定义它的类之外被实现
        @Override
        public void g() {

        }
    }

    class EGImpl implements E.G {
        @Override
        public void f() {

        }
    }

    class EImpl2 implements E {
        @Override
        public void g() {

        }

        class EG implements G {
            @Override
            public void f() {

            }
        }

    }

    public static void main(String[] args) {
        A a = new A();

        //Can't access A.D;
//        A.D ad = a.getD();
        //Doesn't return anything but A.D
//        A.DImpl2 di2 = a.getD();
        //Cannot access a member of the interface
//        a.getD().f();

        //以上尝试使用getD()的返回值都是失败的，使用getD()的返回值只有一中方法可以成功，那就是将返回值交给有权使用它的对象（private接口所在的类的对象）
        //Only anther A can do anything with getD()
        A a2 = new A();
        a2.receiverD(a.getD());
    }




}
class A {
    interface B {
        void f();
    }

    public class BImpl implements B {
        @Override
        public void f() {

        }
    }

    private class BImpl2 implements B {
        @Override
        public void f() {

        }
    }

    public interface C {
        void f();
    }

    class CImpl implements C {
        @Override
        public void f() {

        }
    }

    private class CImpl2 implements C {
        @Override
        public void f() {

        }
    }

    private interface D {//private 嵌套接口，只能被自身使用
        void f();
    }

    private class DImpl implements D {
        @Override
        public void f() {

        }
    }

    public class DImpl2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImpl2();
    }

    private D dRef;

    public void receiverD(D d) {
        dRef = d;
        dRef.f();

    }

}

interface E {
    interface G {
        void f();
    }

    //Redundant "public"
    public interface H {
        void f();
    }

    void g();

    //Cannot be private within an interface
    //! private interface I {}


}