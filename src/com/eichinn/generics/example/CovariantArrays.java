package com.eichinn.generics.example;

import java.util.ArrayList;
import java.util.List;

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        //Runtime type is Apple[], not Fruit[] or Orange[]
        try {
            //Compiler allows you to add Fruit
            fruit[0] = new Fruit();//ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            //Compiler allow you tu add orange
            fruit[1] = new Orange();//ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Fruit> x = new ArrayList<>();
        test(x);
    }

    public static void test(List<? super Apple> x) {
        x.add(new Apple());
    }
}



class Fruit {

}

class Apple extends Fruit {

}

class Jonathan extends Apple {

}

class Orange extends Fruit {

}
