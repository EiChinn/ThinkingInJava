package com.eichinn.initialization.exercise;

/**
 * Created by ei_chinn on 2016/11/15.
 */
public class Exercise11 {
    private static class WebBank {
        private boolean loggedIn = false;

        public WebBank(boolean loggedIn) {
            this.loggedIn = loggedIn;
        }

        private void loggedOut() {
            loggedIn = false;
        }

        protected void finalize() {
            if (loggedIn) {
                System.err.println("Error: still logged in");
            }
            try {
                super.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WebBank webBank1 = new WebBank(true);
        WebBank webBank2 = new WebBank(true);

        webBank1.loggedOut();

        new WebBank(true);

        // Attempts to finalize any missed banks:
        System.out.println("Try 1: ");
        System.runFinalization();
        System.out.println("Try 2: ");
        Runtime.getRuntime().runFinalization();
        System.out.println("Try 3: ");
        System.gc();
        System.out.println("Try 4: ");
        // using deprecated since 1.1 method:
        System.runFinalizersOnExit(true);
    }
}
