package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program2G {
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
        int preMaxPositive=maxPositive;
        int multiplicationPositive=Integer.MIN_VALUE;;
        if(positiveArray.size()>0){
            for(int e: positiveArray){
                if(e>=maxPositive){
                    preMaxPositive=maxPositive;
                    maxPositive=e;
                }
                else if(e>preMaxPositive){
                    preMaxPositive=e;
                }
            }
            multiplicationPositive=maxPositive*preMaxPositive;
        }

        int minNegative=Integer.MAX_VALUE;
        int preMinNegative=minNegative;
        int multiplicationNegative=Integer.MIN_VALUE;
        if(negativeArray.size()>0){
            for(int e: negativeArray){
                if(e<=minNegative){
                    preMinNegative=minNegative;
                    minNegative=e;
                }
                else if(e<preMinNegative){
                    preMinNegative=e;
                }
            }
            multiplicationNegative=minNegative*preMinNegative;
        }

        if(multiplicationPositive>multiplicationNegative) {
            System.out.println(preMaxPositive+ " "+ maxPositive);
        }
        else{
            System.out.println(minNegative+" "+preMinNegative);
        }
    }
}
