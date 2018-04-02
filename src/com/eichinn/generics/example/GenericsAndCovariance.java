package com.eichinn.generics.example;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        //Wildcards allow covariance
        List<? extends Fruit> flist = new ArrayList<Apple>();
        //Compile error, can't add any type of object
        //!flist.add(new Apple());
        //!flist.add(new Fruit());
        //!flist.add(new Object());
        flist.add(null);//legal but uninteresting
        //We know that it returns at least fruit
        Fruit fruit = flist.get(0);
    }
}
