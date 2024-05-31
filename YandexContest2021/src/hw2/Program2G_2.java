/*
Дан список, заполненный произвольными целыми числами. Найдите в этом списке два числа, произведение которых максимально. Выведите эти числа в порядке неубывания.
Список содержит не менее двух элементов. Числа подобраны так, что ответ однозначен.
Решение должно иметь сложность O(n), где n - размер списка.
*/

package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//решение тут
//внимание, в тесте большие числа и умножение выходило за int
public class Program2G_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String [] strings =scanner.nextLine().split(" ");
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        if(array.length==2){
            if(array[0]<array[1]){
                System.out.println(array[0]+" "+array[1]);
            }
            else{
                System.out.println(array[1]+" "+array[0]);
            }
            return;
        }

        ArrayList<Integer> positiveArray = new ArrayList<>();
        ArrayList<Integer> negativeArray = new ArrayList<>();

        for(int e:array){
            if(e>0) positiveArray.add(e);
            else  negativeArray.add(e);
        }

        int maxPositive=Integer.MIN_VALUE;
        int preMaxPositive=Integer.MIN_VALUE;
        long multiplicationPositive=Integer.MIN_VALUE;
        int indexP=-1;

        if(positiveArray.size()>1){
            for(int e=0;e<positiveArray.size();e++){
                if(positiveArray.get(e)>=maxPositive){
                    maxPositive=positiveArray.get(e);
                    indexP=e;
                }
            }

            positiveArray.remove(indexP);

            for(int e: positiveArray){
                if(e>=preMaxPositive){
                    preMaxPositive=e;
                }
            }

            multiplicationPositive=(long)maxPositive*preMaxPositive;
//            System.out.println(maxPositive+" "+preMaxPositive);
//            System.out.println(multiplicationPositive);
        }

        int minNegative=Integer.MAX_VALUE;
        int preMinNegative=Integer.MAX_VALUE;
        long multiplicationNegative=Integer.MIN_VALUE;
        int indexN=-1;
        if(negativeArray.size()>1){
            for(int e=0;e<negativeArray.size();e++){
                if(negativeArray.get(e)<=minNegative){
                    minNegative=negativeArray.get(e);
                    indexN=e;
                }
            }

            negativeArray.remove(indexN);

            for(int e: negativeArray){
                if(e<=preMinNegative){
                    preMinNegative=e;
                }
            }

            multiplicationNegative=(long) minNegative*preMinNegative;
        }

        if(multiplicationPositive>multiplicationNegative) {
            System.out.println(preMaxPositive+ " "+ maxPositive);
        }
        else{
            System.out.println(minNegative+" "+preMinNegative);
        }
    }
}
