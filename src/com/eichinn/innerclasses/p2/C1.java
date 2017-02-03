package com.eichinn.innerclasses.p2;

import com.eichinn.innerclasses.p1.I1;

/**
 * Created by ei_chinn on 2017/2/2.
 */
public class C1 {
    protected class I1Impl implements I1 {
        //need public constructor to create one in C1 child
        public I1Impl() {
        }

        @Override
        public void f() {

        }
    }
}
