package com.eichinn.innerclasses;

/**
 * 内部类的继承：
 * 1、在内部类里面（Inner3）或者该内部类的外部类里面（Inner2）继承该内部类，使用一般的类继承语法即可；
 * 2、在内部类的外部类之外的地方继承该内部类（InheritInner），子类的构造方法除了父类（即该内部类，此处是Inner）构造方法所显式声明的参数（String）之外，
 * 还必须显式接受一个其外部类（WithInner）的对象（在其外部类里面没有显示声明，其实也默认持有其外部类的引用）。此外，子类的构造方法还必须在第一时间调用该外部类对象的super方法，
 * 即子类的构造方法第一条语句必须是：enclosingClassReference.super();而且该内部类的构造方法需要参数，则super方法需要同样的参数
 * Created by ei_chinn on 2017/2/20.
 */
public class InheritInner extends WithInner.Inner{
    //Won't compile
//    InheritInner() {}
    //要继承内部类，子类的构造方法必须接受一个外部类的对象作为参数，因为内部类持有一个指向其外部类的引用
    // 并且要在构造方法里面调用该对象的super()方法。
    InheritInner(String str, WithInner withInner) {
        withInner.super(str);//此前不能有其他语句
        System.out.println(str);
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner("test");
        InheritInner inheritInner = new InheritInner("test", withInner);
    }

}

class WithInner {
    WithInner(String str) {

    }
    class Inner {
        Inner(String str) {

        }

        class Inner3 extends Inner {
            Inner3(String str) {
                super(str);
            }
        }
    }

    class Inner2 extends Inner {
        Inner2(String str) {
            super(str);
        }
    }

}
