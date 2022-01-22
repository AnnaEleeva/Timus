package p6_sort;

import java.util.ArrayList;
import java.util.LinkedList;

public class p1t56MergeIntervals {
    public static void main(String[] args) {
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] array2 = {{1, 4},{0,0}};
        int[][] res= merge(array2);
        for(int[] e:res){
            System.out.println(e[0]+" "+e[1]);
        }

//        [1 8] [2 5] [6 7] [9 15]
//        0  1   2 3   4 5   6  7
//
//            1 8 2 5  -входит => s 1 t 8
//            1 8 2 9  -продлевает справа => s 1 t 9
//            1 8 0 8 -продлевает слева => s 0 t 8
//            1 8 9 10 -разделены => s 1 t 8 упаковать s 9 t 10


    }

    public static int[][] merge(int[][] intervals) {

        int low = 0;
        int high = intervals.length - 1;
        quickSort(intervals, low, high);

        ArrayList<int[]> result = new ArrayList<>();

        int[] nowPair;

        int startPair = intervals[0][0];
        int tailPair = intervals[0][1];

        if(intervals.length==1){
            result.add(new int[]{startPair, tailPair});
        }
        for (int i = 1; i < intervals.length; i++) {

            nowPair = intervals[i];

            //продлевает справа
            if (nowPair[0] <= tailPair && nowPair[1] > tailPair) {
                tailPair = nowPair[1];
            }
            //разделены справа
            if (nowPair[0] > tailPair) {
                result.add(new int[]{startPair, tailPair});
                startPair = nowPair[0];
                tailPair = nowPair[1];
            }

            if(i+1==intervals.length){
                result.add(new int[]{startPair, tailPair});
            }
        }
       int[][] resArray=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            resArray[i]=result.get(i);
        }

        return resArray;

    }

    public static void quickSort(int[][] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle][0];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i][0] < opora) {
                i++;
            }

            while (array[j][0] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int[] temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}

