package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/20.
 */
public class Ex26 {
    class OhterInnerClass extends OuterClass.InnerClass{

        public OhterInnerClass(OuterClass outerClass, String str) {
            outerClass.super(str);
        }
    }
}

class OuterClass {
    class InnerClass {
        public InnerClass(String str) {
        }
    }
}
