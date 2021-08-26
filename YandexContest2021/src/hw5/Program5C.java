package hw5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program5C {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw5\\Program5C_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);



        //кол-во горных пиков
        int mountainPeaksCount = Integer.parseInt(scanner.nextLine());
        int[] mountainPeaksRise=new int[mountainPeaksCount-1];
        //получим первую вершину (пик) - чтобы высчитать насколько поднялись или опустились от первой до второй вершины
        String [] peakXY =scanner.nextLine().split(" ");
        int oldY=Integer.parseInt(peakXY[1]);
        //подъемы и спуски - их на 1 меньше чем пиков
        for(int i=0;i<mountainPeaksCount-1;i++){
            peakXY =scanner.nextLine().split(" ");
            int y=Integer.parseInt(peakXY[1]);
            mountainPeaksRise[i]=(y-oldY) ;
            oldY=y;
        }
        int[] prefixSumLeftToRight=makePrefixSumLeftToRight(mountainPeaksRise);
        int[] prefixSumRightToLeft= makePrefixSumRightToLeft(mountainPeaksRise);

        //кол-во маршрутов
        int traсkCount = Integer.parseInt(scanner.nextLine());
        //нумерация маршрутов с 0
        for(int j=0;j<traсkCount;j++){
            String [] trackStartEnd =scanner.nextLine().split(" ");
            int trackStartPeakIndex=Integer.parseInt(trackStartEnd[0]);
            int trackEndPeakIndex=Integer.parseInt(trackStartEnd[1]);
            //создаем массив префиксных сумм, а по нему уже высчитываем каждый маршрут
            //если маршрут слева-направо (нормально) - считаем положительные (подъемы)
            if(trackStartPeakIndex<trackEndPeakIndex){

                int result= rsq(prefixSumLeftToRight,trackStartPeakIndex,trackEndPeakIndex);
                System.out.println(result);
            }
            //иначе считаем отрицательные (подъемы)
            else{
                int result= rsq(prefixSumRightToLeft,trackStartPeakIndex,trackEndPeakIndex);
                System.out.println(result);
            }

        }


    }

    private static int[] makePrefixSumRightToLeft(int[] array) {
        int[]prefixSum=new int[array.length+1];
        for(int i=1;i<array.length+1;i++){

            if(array[i-1]<0){
                prefixSum[i]=prefixSum[i-1]+Math.abs(array[i-1]);
            }else{
                prefixSum[i]=prefixSum[i-1];
            }

        }
        return prefixSum;

    }

    public static int[] makePrefixSumLeftToRight(int[]array){
        int[]prefixSum=new int[array.length+1];
        for(int i=1;i<array.length+1;i++){

            if(array[i-1]>0){
                prefixSum[i]=prefixSum[i-1]+array[i-1];
            }else{
                prefixSum[i]=prefixSum[i-1];
            }

        }
        return prefixSum;

    }
    public static int rsq(int[]prefixSum, int l, int r){
        return Math.abs(prefixSum[r-1]-prefixSum[l-1]);
    }



}
