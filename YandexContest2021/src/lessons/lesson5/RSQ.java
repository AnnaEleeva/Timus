//Range Sum Query - Сумма элементов на отрезке
package lessons.lesson5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class RSQ {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        int[]prefixSum=makePrefixSum(arrayNumbers);
        //(3,7) - не включает границы
        System.out.println(rsq(prefixSum,3,7));
    }
    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
    public static int[] makePrefixSum(int[]array){
        int[]prefixSum=new int[array.length+1];
        for(int i=1;i<array.length+1;i++){
            prefixSum[i]=prefixSum[i-1]+array[i-1];
        }
        return prefixSum;

    }
    public static int rsq(int[]prefixSum, int l, int r){
        return prefixSum[r]-prefixSum[l];
    }
}
