package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/24.
 */
public class BigEgg extends Egg{
    /**
     * 这里的Yolk并没有覆盖父类Egg的内部类Yolk，这两个内部类是两个完全独立的个体，各自在自己的命名空间内
     */
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}

class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg");
        y = new Yolk();
    }
}
