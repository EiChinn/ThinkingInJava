package com.eichinn.generics.example;

public class MultipleInterfaceVariants {
}

interface Payable<T> {}

class Employee1 implements Payable<Employee1> {

}

/**
 * A class cannot inherited with different type arguments
 * 一个类不能实现同一个泛型接口的两种不同变体，由于擦除原因，这两个变体会成为相同的接口
 */
//class Hourly extends Employee1 implements Payable<Hourly> {}
