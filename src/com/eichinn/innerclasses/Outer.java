package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/1/16.
 */
public class Outer {
    class Inner {

    }

    private Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
//        Outer.Inner inner = new Inner();//非静态内部类必须持有其外部类的一个引用，所以要创建非静态内部类时，必须先创建其外部类的对象
        Inner inner = outer.new Inner();
        inner = outer.getInner();
    }
}
