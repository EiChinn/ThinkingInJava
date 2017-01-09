package com.eichinn.polymorphism;

/**
 * 协变返回类型：在导出类(WheatMill)的被覆盖方法(WheatMill.process())中可以返回基类(Mill)方法(Mill.process())的返回类型(Grain)的某个导出类型(Wheat)
 * Created by ei_chinn on 2017/1/9.
 */
public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);

        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}
class Wheat extends Grain{
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}
class WheatMill extends Mill{
    Wheat process() {
        return new Wheat();
    }
}
