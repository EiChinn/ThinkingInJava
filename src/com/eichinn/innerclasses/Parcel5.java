package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/5.
 */
public class Parcel5 {
    /**
     * Nesting a class within a method
     * @param s
     * @return
     */
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        parcel5.destination("Nesting a class within a method");
    }
}
