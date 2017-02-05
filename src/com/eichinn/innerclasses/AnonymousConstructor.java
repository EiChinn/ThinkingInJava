package com.eichinn.innerclasses;

/**
 *
 * Created by ei_chinn on 2017/2/5.
 */
public class AnonymousConstructor {
    public Base getBase(int i) {//这里的参数i不要求是final的，因为i被传递给匿名内部类的基类构造器，并不会在匿名内部类里直接使用，如果要在匿名内部类里面使用则i必须是final的
        return new Base(i) {
            //匿名内部类中不可能由命名构造器，因为它根本没有名字，但使用实例初始化，能达到构造器的效果。当然它受到了限制：你不能重载实例初始化方法，所以你仅有一个这样的"构造器"
            {
                System.out.println("Inside instance initializer");
            }
            @Override
            void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        AnonymousConstructor anonymousConstructor = new AnonymousConstructor();
        anonymousConstructor.getBase(47);
    }

}

abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }
    abstract void f();
}
