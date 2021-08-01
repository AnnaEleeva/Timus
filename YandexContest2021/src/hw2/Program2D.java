package hw2;

import java.util.Arrays;
import java.util.Scanner;

public class Program2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] strings =scanner.nextLine().split(" "); //числа одной строки в массив
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray(); //массив строк в массив чисел

        int counter=0;
        for(int i=1;i<array.length-1;i++){
             if((array[i]>array[i-1])&&(array[i]>array[i+1])) counter++;
        }

        System.out.println(counter);


    }
}
