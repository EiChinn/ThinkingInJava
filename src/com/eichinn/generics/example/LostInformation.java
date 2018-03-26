package com.eichinn.generics.example;

import java.util.*;

class Frob {

}

class Fnorkle {

}

class Quark<Q> {

}

class Particle<POSITION, MOMENTUM> {

}
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        System.out.println(Arrays.asList(list.getClass().getTypeParameters()));
        Map<Frob, Fnorkle> map = new HashMap<>();
        System.out.println(Arrays.asList(map.getClass().getTypeParameters()));
        Quark<Fnorkle> quark = new Quark<>();
        System.out.println(Arrays.asList(quark.getClass().getTypeParameters()));
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.asList(p.getClass().getTypeParameters()));

    }
}
