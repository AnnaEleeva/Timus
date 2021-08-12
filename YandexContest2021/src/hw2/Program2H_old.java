package hw2;

/*
Наибольшее произведение трех чисел
Ввод: 3 5 1 7 9 0 9 -3 10
Вывод: 10 9 9
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program2H_old {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strNumbers=scanner.nextLine();


        //сформируем ArrayList из строки чисел
        String [] strings =strNumbers.split(" ");
        int[] arrayNumbers = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> arrayNumbersList=new ArrayList<>();
        for(int e:arrayNumbers){
            arrayNumbersList.add(e);
        }

        //получим пары - кандидаты быть в тройке
        //String[] arrayMaxMultiPair=getPairArray(arrayNumbersList);

        //получим пару, дающую максимальное произведение ( оно же всегда позитивно)
        String strResPair=getPairArray(arrayNumbersList);



        //Распарсим пару в нормальные массивы чисел
        int[] positivePair=Arrays.stream( strResPair.split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> newArrayWithoutPair=getNewArrayNumbers(arrayNumbers,positivePair);


        //ищем максимальное число среди оставшихся чисел
        int maxNum = Integer.MIN_VALUE;


        for (int e = 0; e < newArrayWithoutPair.size(); e++) {
            if (newArrayWithoutPair.get(e) >= maxNum) {
                maxNum = newArrayWithoutPair.get(e);

            }
        }

        System.out.println(strResPair+" "+maxNum);


    }

    //возвращает новый лист с числами, убрав взятую пару чисел
    public static ArrayList<Integer> getNewArrayNumbers(int[] arrayNumbers,  int[] positivePair){
        //добавим все, кроме 2х позитивных
        boolean wasFirstPositive=false;
        boolean wasSecondPositive=false;
        ArrayList<Integer> arrayNumbers_PositivePait = new ArrayList<Integer>();
        for(int e:arrayNumbers){
            if(e==positivePair[0]&&!wasFirstPositive){
                wasFirstPositive=true;
                continue;
            }
            if(e==positivePair[1]&&!wasSecondPositive){
                wasSecondPositive=true;
                continue;
            }
            arrayNumbers_PositivePait.add(e);

        }
        // arrayNumbers_PositivePait.add(positivePair[0]*positivePair[1]);
        return arrayNumbers_PositivePait;


    }


    //возвращает максимальные положительные и минимальные отрицательные числа
    //передаем строку вида "8 9 2 -1 -5 3"
    //возвращает массив arr[0]="8 9" arr[1]="-1 5"
    public static String  getPairArray(ArrayList<Integer> array){
        //String [] strings =strNumbers.split(" ");
        //int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();


        String [] returnArray=new String[2];

        if(array.size()==2){
            if(array.get(0)<array.get(1)){
                //System.out.println(array[0]+" "+array[1]);
                //returnArray[0]=array.get(0)+" "+array.get(1);
                return array.get(0)+" "+array.get(1);
            }
            else{
                //System.out.println(array[1]+" "+array[0]);
                //returnArray[1]=array.get(1)+" "+array.get(0);
                return array.get(1)+" "+array.get(0);
            }
            //return returnArray;
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


        returnArray[0]=preMaxPositive+ " "+ maxPositive;
        returnArray[1]=minNegative+" "+preMinNegative;

        if(multiplicationPositive>multiplicationNegative) {
            //System.out.println(preMaxPositive+ " "+ maxPositive);
            return preMaxPositive+ " "+ maxPositive;
        }
        else{
            //System.out.println(minNegative+" "+preMinNegative);
            return minNegative+" "+preMinNegative;
        }
        //return  returnArray;
    }
}
