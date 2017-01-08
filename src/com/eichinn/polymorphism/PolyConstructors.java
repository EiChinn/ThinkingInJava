package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2017/1/8.
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5, "test");
    }
}

abstract class Glyph {
    abstract void draw();

    Glyph() {
        System.out.println("Glyph() before draw");
        //当要创建导出类RoundGlyph的对象时调用的是导出类的draw方法，
        // 而此时导出类RoundGlyph还没初始化完毕（非static变量没有初始化，构造方法还没被调用），
        // 这种情况下若调用RoundGlyph的方法可能会得到期望以外的结果或运行时异常
        //所以编写构造方法时应该"用尽可能简单的方法使对象进入正常状态，如果可以的话避免调用其它方法
        //在构造方法内唯一能够安全的调用的方法是final（private自动是final的）这些不能被覆盖的方法
        draw();
        System.out.println("Glyph() after draw");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    private String test;
    RoundGlyph(int r, String test) {
        radius = r;
        this.test = test;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        //当要创建RoundGlyph对象时，会在基类Glyph的构造过程中调用其构造方法时被调用，
        // 而此时，非static变量radius并没有被初始化，为默认的初始值0，如果此时在方法调用了引用变量的方法，就会报NullPointerException的运行时错误
        //
        System.out.println("RoundGlyph.draw(), radius = " + radius + "; test.length() = " + test.length());

    }
}
