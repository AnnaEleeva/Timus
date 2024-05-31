package org.example.exeptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions2 {
    public static void main(String[] args) {
        try {

            foo();

        } catch (MyException e) {

            e.printStackTrace();

        }

    }

    // проверяемые (checked) - проверяются компилятором (FileNotFoundExeption)
    // непроверяемые (unchecked) - ArithmeticException   - не нужно пробрасывать в try-catch хотя это возможно как с Error

    public static void foo()throws MyException {

    }
}
