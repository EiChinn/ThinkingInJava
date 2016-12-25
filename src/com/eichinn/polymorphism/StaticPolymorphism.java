package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2016/12/25.
 */
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        //静态方法是与类，而并非与单个的对象相关联的，因此它的行为就不具有多态性
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamGet()";
    }
}

class StaticSub extends StaticSuper {
//    @Override 静态方法不能被override
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet";
    }
}
