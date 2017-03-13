package com.eichinn.exceptions.examples;

/**
 * Creating your own exceptions
 * Created by ei_chinn on 2017/3/11.
 */
public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public void g() throws SimpleException {
        System.out.println("Throw SimpleException from g()");
        throw new SimpleException("Originated in g()");
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
//            System.out.println("Caught it!");
            e.printStackTrace(System.out);//指定由System.out打印错误信息
        }

        try {
            sed.g();
        } catch (SimpleException e) {
//            System.out.println("Caught it!");
            e.printStackTrace();//默认由System.err打印错误信息
        }


    }
}

class SimpleException extends Exception {
    public SimpleException() {
    }

    public SimpleException(String message) {
        super(message);
    }
}
