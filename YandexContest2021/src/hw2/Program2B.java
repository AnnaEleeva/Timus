package hw2;

import java.util.ArrayList;
import java.util.Scanner;

public class Program2B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         ArrayList<Integer> list=new ArrayList<>();
         int max=Integer.MIN_VALUE;
         int min=Integer.MAX_VALUE;

        while(scanner.hasNextInt()){
            int x=scanner.nextInt();
            if(x==-2000000000){break;}
            list.add(x);

        }

        for(int e:list){
            if(e>max){
                max=e;
            }
            if(e<min){
                min=e;
            }
        }
       // System.out.println(min);
        //System.out.println(max);

        if(min==max){
            System.out.println("CONSTANT");
            return;
        }

        if(list.get(0)!=min&&list.get(0)!=max){
            System.out.println("RANDOM");
            return;
        }


        if(list.get(0)==min){
            int previous=list.get(0);
            boolean weakly=false;
            for(int i=1;i<list.size();i++){
                if(list.get(i)<previous){
                    System.out.println("RANDOM");
                    return;
                }
                if(list.get(i)==previous){
                    weakly=true;
                }
                previous=list.get(i);
            }
            if(weakly){
                System.out.println("WEAKLY ASCENDING");
                return;
            }
            else{
                System.out.println("ASCENDING");
                return;
            }
        }
        else if(list.get(0)==max){
            int previous=list.get(0);
            boolean weakly=false;
            for(int i=1;i<list.size();i++){
                if(list.get(i)>previous){
                    System.out.println("RANDOM");
                    return;
                }
                if(list.get(i)==previous){
                    weakly=true;
                }
                previous=list.get(i);
            }
            if(weakly){
                System.out.println("WEAKLY DESCENDING");
                return;
            }
            else{
                System.out.println("DESCENDING");
                return;
            }

        }else System.out.println("RANDOM");
    }
}
