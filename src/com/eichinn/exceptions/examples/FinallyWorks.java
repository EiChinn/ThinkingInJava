package com.eichinn.exceptions.examples;

/**
 * The finally clause is always executed.
 * 把try块放进循环里面，并配合static类型的计数器或者别的类似的装置，使循环在遇到异常放弃以前能做一定次数的尝试。这将增加代码的健壮性
 * Created by ei_chinn on 2017/3/21.
 */
public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                //Post-increment is zero first time
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}

class ThreeException extends Exception {

}
