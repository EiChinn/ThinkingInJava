package com.eichinn.typeinfo.example;

import java.util.Random;

public class ClasssInitialization {
    public static final Random random = new Random(47);

    public static void main(String[] args) {
        //使用.class来创建对Class对象的引用时，不会自动地初始化该Class对象
        Class initable = Initable.class;
        System.out.println();

        System.out.println("After creating Initable ref");
        //Does not trigger initialization
        //一个static final值是“编译期常量”，那么这个值不需要对类进行初始化就可以被读取
        System.out.println(Initable.staticFinal);
        System.out.println();

        //Does trigger initialization
        //但一个static final值不是一个编译期常量，那么对他的访问依然会导致类的初始化
        System.out.println(Initable.staticFinal2);
        System.out.println();

         //Does trigger initialization
        //一个static域不是final的，那么对他的访问时，总要求在他被读取之前，要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间），导致类被初始化
        System.out.println(Initable2.staticNonFinal);
        System.out.println();

        //利用Class.forName获得Class对象的引用会导致该类立刻被初始化
        try {
            Class initable3 = Class.forName("com.eichinn.typeinfo.example.Initable3");
            System.out.println("After creating Initable3 ref");
            System.out.println(Initable3.staticNonFinal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClasssInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}
class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}


