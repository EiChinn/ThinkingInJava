package com.eichinn.initialization.example;

/**
 * Created by ei_chinn on 2016/11/15.
 */
public class TerminationCondition {
    private static class Book {
        boolean checkedOut = false;

        public Book(boolean checkedOut) {
            this.checkedOut = checkedOut;
        }

        private void checkIn() {
            checkedOut = false;
        }

        protected void finalize() {
            if (checkedOut) {
                System.err.println("Error: checked out");
            }

            try {
                super.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
