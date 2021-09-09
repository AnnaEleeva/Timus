package hw6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program6B {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw6\\Program6B_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String[] sizesStr= scanner.nextLine().split(" ");

        String [] string1 =scanner.nextLine().split(" ");
        long[] array1 = Arrays.stream(string1).mapToLong(Long::parseLong).toArray();

        String [] string2 =scanner.nextLine().split(" ");
        long[] array2 = Arrays.stream(string2).mapToLong(Long::parseLong).toArray();

        for(long e: array2){
            rbinarySearch(array1,e);
        }


    }

    public static void rbinarySearch(long []array,long x){
        int l=0;
        int r=array.length-1;
        int m;
        while (l<r){
            m = (l + r + 1) / 2;
            if (array[m] <= x) //проверяем все хорошо или все плохо
            {
                l = m;
                // System.out.println("r " + r);
            } else {
                r = m - 1;
                // System.out.println("l " + l);
            }
        }

       long minDif=Math.abs(array[l]-x);
       long answer=array[l];

        //System.out.println("index "+ l);
        if(l-1>=0){
            if((Math.abs(array[l-1]-x))<minDif) {
                minDif=Math.abs(array[l-1]-x);
                answer=array[l-1];
            }
        }
        if(l+1<array.length) {
            long z=Math.abs(array[l+1]-x);
            if((Math.abs(array[l+1]-x))<minDif) {
                minDif=Math.abs(array[l+1]-x);
                answer=array[l+1];

            }
        }


        System.out.println(answer);
        // return l;
    }
}
