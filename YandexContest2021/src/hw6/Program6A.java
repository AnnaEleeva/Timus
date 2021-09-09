/*
В первой строке входных данных содержатся натуральные числа N и K (). Во второй строке задаются N элементов первого массива, а в третьей строке – K элементов второго массива. Элементы обоих массивов - целые числа, каждое из которых по модулю не превосходит 109

Формат вывода
Требуется для каждого из K чисел вывести в отдельную строку "YES", если это число встречается в первом массиве, и "NO" в противном случае.
 */
package hw6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program6A {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw6\\Program6A_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String[] sizesStr= scanner.nextLine().split(" ");

        String [] string1 =scanner.nextLine().split(" ");
        int[] array1 = Arrays.stream(string1).mapToInt(Integer::parseInt).toArray();

        String [] string2 =scanner.nextLine().split(" ");
        int[] array2 = Arrays.stream(string2).mapToInt(Integer::parseInt).toArray();

        for(int e: array2){
            binarySearch(array1,e);
        }


    }
    public static void binarySearch(int []array,int x){
        int l=0;
        int r=array.length-1;
        int m;
        while (l<r){
            m= (l + r) / 2;
            if (array[m] >= x) //проверяем все хорошо или все плохо
            {
                r = m;
                // System.out.println("r " + r);
            } else {
                l = m + 1;
                // System.out.println("l " + l);
            }
        }

        if(array[l]==x) System.out.println("YES");
        else System.out.println("NO");
       // return l;

    }
}
