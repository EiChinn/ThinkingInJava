package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2017/1/8.
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw");
        draw();//当要创建导出类RoundGlyph的对象时调用的是导出类的draw方法
        System.out.println("Glyph() after draw");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        //当要创建RoundGlyph对象时，会在基类Glyph的构造过程中调用其构造方法时被调用，而此时，非static变量radius并没有被初始化，为默认的初始值0
        System.out.println("RoundGlyph.draw(), radius = " + radius);

    }
}
