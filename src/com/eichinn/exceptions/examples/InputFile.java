package com.eichinn.exceptions.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Paying attention to exceptions in constructors.
 * Created by ei_chinn on 2017/4/9.
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            // Other code that might throw exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            //Wasn't open, so don't close it
            throw e;
        } catch (Exception e) {
            //All other exceptions must close it
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close() unsuccessful");
            }
            throw e; //Rethrow
        } finally {
            //Don't close it here!!!
            //finally 在每次完成构造器之后都执行一次，不管构造是否成功，所以这里不能用来关闭in
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Clean.java");
            //在创建需要清理都对象之后，立即进入一个try-finally语句块中
            try {
                String s;
                while ((s = in.getLine()) != null) {
                    //Perform line-by-line processing here
                }
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();

            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }

}
