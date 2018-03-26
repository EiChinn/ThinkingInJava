package com.eichinn.generics.example;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Compiles; but produce ClassCastException
        //! gia = (Generic<Integer>[]) new Object[SIZE];

        //Running time is the raw(erased) type
        gia = (Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();

        //! gia[1] = new Object();//Compile time error
        //! gia[2] = new Generic<Double>();//Discovers type mismatch at compile time
    }
}

class Generic<T> {

}
