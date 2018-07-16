package com.eichinn.generics.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}

class Mime {
    public void walkAgainstTheWind() {}
    public void sit() {
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls() {}
    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {}
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            Method speak = spkr.getMethod("speak");
            speak.invoke(speaker);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(speaker + " cannot speak");
        }

        try {
            Method sit = spkr.getMethod("sit");
            sit.invoke(speaker);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(speaker + " cannot speak");
        }
    }
}
