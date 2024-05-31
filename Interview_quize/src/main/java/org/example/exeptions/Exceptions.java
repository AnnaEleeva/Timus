package org.example.exeptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions {
    public static void main(String[] args) {
        try {

            foo();

        } catch (IOException e) {

            e.printStackTrace();

        }
//        catch (FileNotFoundException e) {  //не скомпилируется тк FileNotFoundException extends IOException
//
//            e.printStackTrace();
//
//        }


    }
    public static void foo()throws IOException, FileNotFoundException {

    }
}
