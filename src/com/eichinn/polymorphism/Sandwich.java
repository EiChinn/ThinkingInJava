package com.eichinn.polymorphism;

/**
 * Created by ei_chinn on 2017/1/5.
 */
public class Sandwich extends PortableLunch{//2 发现有父类，继续加载父类
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    public Sandwich() {//9 调用构造方法前会进行必要的非static初始化
        System.out.println("Sandwich");//10 非static初始化完成后才调用构造方法主体
    }

    public static void main(String[] args) {//1 入口，加载类
        new Sandwich();
    }
}

class Meal {//5 继续加载父类Object
    Meal() {//6 调用构造方法前会进行必要的非static初始化
        System.out.println("Meal");
    }
}
class Bread {
    Bread() {
        System.out.println("Bread");
    }
}
class Cheese {
    Cheese() {
        System.out.println("Cheese");
    }
}
class Lettuce {
    Lettuce() {
        System.out.println("Lettuce");
    }
}
class Lunch extends Meal{//4 发现有父类，继续加载父类
    Lunch() {//7 调用构造方法前会进行必要的非static初始化
        System.out.println("Lunch");
    }
}
class PortableLunch extends Lunch{//3 发现有父类，继续加载父类
    PortableLunch() {//8 调用构造方法前会进行必要的非static初始化
        System.out.println("PortableLunch");
    }
}
