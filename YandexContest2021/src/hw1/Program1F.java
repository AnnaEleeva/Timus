package hw1;

import java.util.Scanner;

public class Program1F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int comp1X=scanner.nextInt();
        int comp1Y=scanner.nextInt();
        int comp2X=scanner.nextInt();
        int comp2Y=scanner.nextInt();

        int min=Integer.MAX_VALUE;
        int minX=-1;
        int minY=-1;

        int s1;
        int table1X;
        int table1Y;

        int s2;
        int table2X;
        int table2Y;

        int s3;
        int table3X;
        int table3Y;

        int s4;
        int table4X;
        int table4Y;


        if((comp2Y-comp1Y)<=0){
            s1=(comp1X+comp2X)*comp1Y;
            table1X=(comp1X+comp2X);
            table1Y=comp1Y;
        }else{
            s1=(comp1X+comp2X)*(comp1Y+(comp2Y-comp1Y));
            table1X=(comp1X+comp2X);
            table1Y=(comp1Y+(comp2Y-comp1Y));
        }
        if(s1<min){
            min=s1;
            minX=table1X;
            minY=table1Y;

        }
       // System.out.println("s1 "+s1);


        if((comp2Y-comp1X)<=0){
            s2=(comp1Y+comp2X)*comp1X;
            table2X=(comp1Y+comp2X);
            table2Y=comp1X;
        }else{
            s2=(comp1Y+comp2X)*(comp1X+(comp2Y-comp1X));
            table2X=(comp1Y+comp2X);
            table2Y=(comp1X+(comp2Y-comp1X));
        }
        if(s2<min){
            min=s2;
            minX=table2X;
            minY=table2Y;
        }
      //  System.out.println("s2 "+s2); //




        if((comp2X-comp1Y)<=0){
            s3=(comp1X+comp2Y)*comp1Y;
            table3X=(comp1X+comp2Y);
            table3Y=comp1Y;
        }else{
            s3=(comp1X+comp2Y)*(comp1Y+(comp2X-comp1Y));
            table3X=(comp1X+comp2Y);
            table3Y=(comp1Y+(comp2X-comp1Y));
        }
        if(s3<min){
            min=s3;
            minX=table3X;
            minY=table3Y;
        }
      //  System.out.println("s3 "+s3);


        if((comp2X-comp1X)<=0){
            s4=(comp1Y+comp2Y)*comp1X;
            table4X=(comp1Y+comp2Y);
            table4Y=comp1X;
        }else{
            s4=(comp1Y+comp2Y)*(comp1X+(comp2X-comp1X));
            table4X=(comp1Y+comp2Y);
            table4Y=(comp1X+(comp2X-comp1X));
        }
        if(s4<min){
            min=s4;
            minX=table4X;
            minY=table4Y;
        }
     //   System.out.println("s4 "+s4);

        System.out.println(minX+ " "+minY);


    }
}
