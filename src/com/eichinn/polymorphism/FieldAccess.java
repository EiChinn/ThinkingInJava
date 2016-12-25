package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2016/12/25.
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();

        System.out.print("sup.field = " + sup.field);
        //普通方法的调用是多态的，由实际类型决定
        System.out.println(", sup.getField() = " + sup.getField());

        Sub sub = new Sub();
        //direct field access is determined at compile time
        //任何域访问操作都将由编译器解析，因此不是多态的，由声明类型决定
        System.out.print("sub.field = " + sub.field);
        //普通方法的调用是多态的，由实际类型决定
        System.out.print(", sub.getField() = " + sub.getField());
        System.out.println(", sub.getSuperField() = " + sub.getSuperField());
    }
}
class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    //当子类声明了一个父类中已经具有的同名同类型的域时，子类实际上包含了两个同名同类型的域（一个是自己的，一个从父类继承过来的），
    // 这时要调用父类的那个域，就要使用super关键字
    public int getSuperField() {
        return super.field;
    }
}
