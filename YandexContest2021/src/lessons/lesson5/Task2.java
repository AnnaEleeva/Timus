//Дана последовательность из n
// Найти кол-во отрезков с нулевой суммой
//решаем с помощью префиксной суммы
//O(n)
package lessons.lesson5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Task2 {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\lessons\\lesson5\\Task2_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();


        countZeroSumRanges(countPrefixSums(arrayNumbers));
        System.out.println(countZeroSumRanges(countPrefixSums(arrayNumbers)));
    }
    //делаем карту с префиксными суммами.
    public static HashMap<Integer, Integer> countPrefixSums(int[]array){
        //карта префиксных сумм, в которых без индексов хранятся подсчитываемые суммы и их поличество
        HashMap<Integer,Integer> prefixSumByValue=new HashMap<>();
        //сюда суммируем все значения
        int nowSum=0;
        for(int now:array){
            nowSum+=now;
            if(!prefixSumByValue.containsKey(nowSum)){
                prefixSumByValue.put(nowSum,0);
            }
            prefixSumByValue.put(nowSum,prefixSumByValue.get(nowSum)+1);
        }
        return prefixSumByValue;
    }

    public static int countZeroSumRanges(HashMap<Integer,Integer> prefixSumByValue){
        int cntRanges=0;
        //идем по получившимся префиксным суммам
        for(Integer nowSum:prefixSumByValue.keySet()){
            //сколько раз такая префиксная сумма встречалась
            int cntSum=prefixSumByValue.get(nowSum);
            //исходя их кол-ва раз, которое встречалась префиксная сумма, определим сколько это нулевых промежутков
            //(между двумя одинаковыми префиксными суммами будет нулевая сумма элементов)
             cntRanges+=cntSum*(cntSum-1)/2; //комбинаторная формула для рассчета промежутков изходя из кол-ва элементов
        }
        return cntRanges;
    }



    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
