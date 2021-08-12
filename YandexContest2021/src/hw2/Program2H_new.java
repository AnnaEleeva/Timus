//В данном списке из n ≤ 105 целых чисел найдите три числа,произведение которых максимально.
//
//        Решение должно иметь сложность O(n), где n - размер списка.
//
//        Выведите три искомых числа в любом порядке.
//ЗАДАЧА РЕШЕНА! (приложен текстовый файл с ходом решения)
package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program2H_new {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String strNumbers=scanner.nextLine();


        //сформируем ArrayList из строки чисел
        String [] strings =strNumbers.split(" ");
        if(strings.length<=3) {  //проверим на исключительную ситуацию
            System.out.println(strNumbers);
            return;
        }
        int[] arrayNumbers = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> arrayNumbersList=new ArrayList<>();
        for(int e:arrayNumbers){
            arrayNumbersList.add(e);
        }

        //разделим на позитивные и негативные числа
        ArrayList<Integer> positiveArray = new ArrayList<>();
        ArrayList<Integer> negativeArray = new ArrayList<>();
        for(int e:arrayNumbersList){
            if(e>0) positiveArray.add(e);
            else  negativeArray.add(e);
        }

        int x=positiveArray.size();
        int y=negativeArray.size();

        //0 отрицательных - все положительные
        if(y==0){
           int[] result = planA1(positiveArray,negativeArray,arrayNumbersList);
           printResult(result);
           return;
        }
        //0 положительных - все отрицательные
        if(x==0){
            int[] result=planB2(positiveArray,negativeArray,arrayNumbersList);
            printResult(result);
            return;
        }
        //одно положительное
        if(x==1){
            int[] result1=planA2(positiveArray,negativeArray,arrayNumbersList);
            int[] result2=planB2(positiveArray,negativeArray,arrayNumbersList);

           int[] result= compareMulti(result1,result2);
           printResult(result);
           return;
        }

        //одно отрицательное
        if(y==1){
            int[] result1=planB1(positiveArray,negativeArray,arrayNumbersList);
            int[] result2=planA1(positiveArray,negativeArray,arrayNumbersList);

            int[] result=compareMulti(result1,result2);
            printResult(result);
            return;
        }


        int[] result1=planA1(positiveArray,negativeArray,arrayNumbersList);
        int[] result2=planA2(positiveArray,negativeArray,arrayNumbersList);
        int[] result3=planB1(positiveArray,negativeArray,arrayNumbersList);
        int[] result4=planB2(positiveArray,negativeArray,arrayNumbersList);

        int[] result_1=compareMulti(result1,result2);
        int[] result_2=compareMulti(result3,result4);

        int[] result=compareMulti(result_1,result_2);
        printResult(result);
    }

    //поиск максимального значения в листе
    public static Integer getMaxNumber (ArrayList<Integer> arrayList){
        int maxNum = Integer.MIN_VALUE;


        for (int e = 0; e < arrayList.size(); e++) {
            if (arrayList.get(e) >= maxNum) {
                maxNum = arrayList.get(e);

            }
        }
        return  maxNum;
    }

    //поиск минимального значения в листе
    public static Integer getMinNumber (ArrayList<Integer> arrayList){
        int minNum = Integer.MAX_VALUE;


        for (int e = 0; e < arrayList.size(); e++) {
            if (arrayList.get(e) <= minNum) {
                minNum = arrayList.get(e);

            }
        }
        return  minNum;
    }

    //получение нового листа без какого-то элемента
    public  static ArrayList<Integer> getNewArrayListWithoutNumber(ArrayList<Integer> arrayList,Integer x){
        //добавим все, кроме x
        boolean wasX=false;

        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        for(int e:arrayList){
            if(e==x&&!wasX){
                wasX=true;
                continue;
            }
            newArrayList.add(e);

        }
        return newArrayList;
    }


    //два максимальных положительных и одно максимальное положительное
    public static int[] planA1(ArrayList<Integer> positiveNumbers, ArrayList<Integer> negativeNumbers, ArrayList<Integer> arrayList){
        int [] result=new int[3];
        int positive1=getMaxNumber(positiveNumbers);
        ArrayList<Integer> positiveNumbers2=getNewArrayListWithoutNumber(positiveNumbers,positive1);
        int positive2=getMaxNumber(positiveNumbers2);
        ArrayList<Integer> positiveNumbers3=getNewArrayListWithoutNumber(positiveNumbers2,positive2);
        int positive3=getMaxNumber(positiveNumbers3);
        result[0]=positive1;
        result[1]=positive2;
        result[2]=positive3;
        return result;
    }

    //два минимальных(максимальных по модулю) отрицательных и одно максимальное положительное
    public  static int[] planA2(ArrayList<Integer> positiveNumbers, ArrayList<Integer> negativeNumbers, ArrayList<Integer> arrayList){
        int [] result=new int[3];
        int negative1=getMinNumber(negativeNumbers);
        ArrayList<Integer> negativeNumbers2=getNewArrayListWithoutNumber(negativeNumbers,negative1);
        int negative2=getMinNumber(negativeNumbers2);
        int positive1=getMaxNumber(positiveNumbers);
        result[0]=negative1;
        result[1]=negative2;
        result[2]=positive1;
        return result;
    }

    //два минимальных(минимальных по модулю) положительных ----одно минимальное отрицательное(-1)
    public static int[] planB1(ArrayList<Integer> positiveNumbers, ArrayList<Integer> negativeNumbers, ArrayList<Integer> arrayList){
        int [] result=new int[3];
        int positive1=getMinNumber(positiveNumbers);
        ArrayList<Integer> positiveNumbers2=getNewArrayListWithoutNumber(positiveNumbers,positive1);
        int positive2=getMinNumber(positiveNumbers2);
        int negative1=getMinNumber(negativeNumbers);
        result[0]=positive1;
        result[1]=positive2;
        result[2]=negative1;
        return result;
    }
//два максимальных(минимальных по модулю) отрицательных  ---одно максимальное(минимальное по модулю) отрицательное(-1)
    public static int[] planB2(ArrayList<Integer> positiveNumbers,ArrayList<Integer> negativeNumbers,ArrayList<Integer> arrayList){
        int [] result=new int[3];
        int negative1=getMaxNumber(negativeNumbers);
        ArrayList<Integer> negativeNumbers2=getNewArrayListWithoutNumber(negativeNumbers,negative1);
        int negative2=getMaxNumber(negativeNumbers2);
        ArrayList<Integer> negativeNumbers3=getNewArrayListWithoutNumber(negativeNumbers2,negative2);
        int negative3=getMaxNumber(negativeNumbers3);
        result[0]=negative1;
        result[1]=negative2;
        result[2]=negative3;
        return result;
    }

    public static int[] compareMulti(int[] result1, int[] result2){
        long multi1=1;
        long multi2=1;

        for(int e : result1){
            multi1=multi1*e;
        }
        for(int e : result2){
            multi2=multi2*e;
        }

        if(multi1>multi2){
           return result1;
        }else{
            return result2;
        }
    }
    public  static void printResult(int[] result){
        for(int e : result){
            System.out.print(e+" ");
        }
    }

}
