package com.eichinn.generics.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
//    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//        List<Widget> shape = (List<Widget>) in.readObject();
        List<Widget> shape = List.class.cast(in.readObject());
//        List<Widget> shape = List<Widget>.class.cast(in.readObject());
    }
}
