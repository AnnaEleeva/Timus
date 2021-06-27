package hw1;

import java.util.Scanner;

public class Program1G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N=scanner.nextInt(); // alloy weight
        int K=scanner.nextInt(); //blank weight
        int M=scanner.nextInt(); // detail weight
        if(N<=0||K<=0||M<=0||N>200||K>200||M>200||M>K||N<K) {
            System.out.println(0);
            return;
        }


        double alloy=N; //сплав кг
       // System.out.println(alloy);
        int blankCount; //заготовка
        int detailCount=0; //деталь

        int detailCountAll=0;


        while(alloy>=K){ //N>=K
            blankCount= (int) Math.floor(alloy/(double)K);
            //blankCount=Math.floorDiv(alloy,(double)K);
            alloy=alloy-K*blankCount;
           // alloy=alloy+(double)(N%K);
            detailCount=blankCount*Math.floorDiv(K,M);
           // detailCount=blankCount*(int)Math.floor(K/(double)M);

            detailCountAll=detailCountAll+detailCount;

            alloy=alloy+((double)K%M)*blankCount;

        }
        System.out.println(detailCountAll);
    }
}
