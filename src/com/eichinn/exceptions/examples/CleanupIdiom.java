package com.eichinn.exceptions.examples;

/**
 * Each disposable object must be followed by a try-finally
 * Created by ei_chinn on 2017/4/9.
 */
public class CleanupIdiom {
    public static void main(String[] args) {
        //Section 1
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // if object construction won't be fail, catch block is no need here
        } finally {
            nc1.dispose();
        }

        //Section 2
        // if construction cannot fail you can group objects
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {

        } finally {
            //Reverse order of construction
            nc3.dispose();
            nc2.dispose();
        }

        //Section 3
        //if construction can fail you must guard each one
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {


                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {

                } finally {
                    nc5.dispose();
                }



            } catch (ConstructionException e) {//nc5 constructor
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {//nc4 constructor
            System.out.println(e);
        }
    }


}

class NeedsCleanup {//Construction can't fail
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " dispose");
    }
}

class ConstructionException extends Exception {

}

class NeedsCleanup2 extends NeedsCleanup {
    //Construction can fail
    public NeedsCleanup2() throws ConstructionException {

    }
}
