/*
Наибольшее произведение трех чисел
Ввод: 3 5 1 7 9 0 9 -3 10
Вывод: 10 9 9

падает на
ввод 9 1 -1 -1
вывод 1 9 -1 = -9 < 9 -1 -1 9
*/
package hw2;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program2H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strNumbers=scanner.nextLine();


        //сформируем ArrayList из строки чисел
        String [] strings =strNumbers.split(" ");
        if(strings.length<=3) {
            System.out.println(strNumbers);
            return;
        }
        int[] arrayNumbers = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> arrayNumbersList=new ArrayList<>();
        for(int e:arrayNumbers){
            arrayNumbersList.add(e);
        }

        //получим пары - кандидаты быть в тройке
        //String[] arrayMaxMultiPair=getPairArray(arrayNumbersList);

        //получим пары, дающие максимальное произведение ( оно же всегда позитивно)
        ArrayList<String> pairsArray=getPairArray(arrayNumbersList);
        String strResPairPositive=pairsArray.get(0);
        String strResPairNegative=pairsArray.get(1);

        boolean isOnePair=false;
        Long maxMuliplication=null;

        if(strResPairNegative.equals("")) isOnePair=true;

        //Распарсим пару в нормальные массивы чисел
        int[] positivePair=Arrays.stream( strResPairPositive.split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> newArrayWithoutPositivePair=getNewArrayNumbers(arrayNumbers,positivePair);


        //ищем максимальное число среди оставшихся чисел
        Integer maxNum = Integer.MIN_VALUE;

        for (int e = 0; e < newArrayWithoutPositivePair.size(); e++) {
            if (newArrayWithoutPositivePair.get(e) >= maxNum) {
                maxNum = newArrayWithoutPositivePair.get(e);

            }
        }
        //выясним произведение позитивной пары с максимальным найденным числом
        maxMuliplication=maxNum*(long)positivePair[0]*positivePair[1];

        if(!isOnePair){
            //Распарсим пару в нормальные массивы чисел
            int[] negativePair=Arrays.stream( strResPairNegative.split(" ")).mapToInt(Integer::parseInt).toArray();

            ArrayList<Integer> newArrayWithoutNegativePair=getNewArrayNumbers(arrayNumbers,negativePair);


            //ищем максимальное число среди оставшихся чисел
            int maxNum2 = Integer.MIN_VALUE;

            for (int e = 0; e < newArrayWithoutNegativePair.size(); e++) {
                if (newArrayWithoutNegativePair.get(e) >= maxNum2) {
                    maxNum2 = newArrayWithoutNegativePair.get(e);

                }
            }
            long temp=maxNum2*(long)negativePair[0]*negativePair[1];
            if(temp>maxMuliplication){
                maxMuliplication=temp;
                System.out.println(strResPairNegative+" "+maxNum2);
                return;
            }

        }

        System.out.println(strResPairPositive+" "+maxNum);
        return;


    }

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


    //передаем строку вида "8 9 2 -1 -5 3"
    //возвращает массив arr[0]="8 9" arr[1]="-1 5"
    public static ArrayList<String>  getPairArray(ArrayList<Integer> array){
        //String [] strings =strNumbers.split(" ");
        //int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        ArrayList<String> result=new ArrayList<>();
        result.add("");// index 0
        result.add("");// index 1


        String [] returnArray=new String[2];

        if(array.size()==2){
            if(array.get(0)<array.get(1)){
                //System.out.println(array[0]+" "+array[1]);
                //returnArray[0]=array.get(0)+" "+array.get(1);
               // return array.get(0)+" "+array.get(1);
                result.set(0,array.get(0)+" "+array.get(1));
            }
            else{
                //System.out.println(array[1]+" "+array[0]);
                //returnArray[1]=array.get(1)+" "+array.get(0);
               // return array.get(1)+" "+array.get(0);
                result.set(0,array.get(1)+" "+array.get(0));
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

//        if(multiplicationPositive>multiplicationNegative) {
//            //System.out.println(preMaxPositive+ " "+ maxPositive);
//            return preMaxPositive+ " "+ maxPositive;
//        }
//        else{
//            //System.out.println(minNegative+" "+preMinNegative);
//            return minNegative+" "+preMinNegative;
//        }
        result.set(0,preMaxPositive+ " "+ maxPositive);
        result.set(1,minNegative+" "+preMinNegative);
        //return  returnArray;
        return  result;
    }
}