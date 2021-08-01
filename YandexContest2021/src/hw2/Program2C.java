package hw2;

import java.util.Scanner;

public class Program2C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrL= Integer.parseInt(scanner.nextLine());
        int [] array=new int[arrL];

        for(int i=0;i<arrL;i++){
            array[i]=scanner.nextInt();
        }
        int x=scanner.nextInt();

        int minDif=Integer.MAX_VALUE;

        int nearestToX=1001;

        for(int e:array){
            if(Math.abs(x-e)<minDif){
                minDif=Math.abs(x-e);
                nearestToX=e;
            }
        }
        System.out.println(nearestToX);


    }
}
