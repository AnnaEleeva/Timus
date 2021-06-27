package hw1;

import java.util.Scanner;

public class Program1E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k1=scanner.nextInt();
        int p1 = -2; //подъезд
        int n1=-2; //этаж
        int k1New;


        int m=scanner.nextInt(); //всего этажей в доме
        int k2=scanner.nextInt(); //кв
        int p2=scanner.nextInt(); //подъезд
        int p2Right=-2;
        int n2=scanner.nextInt(); //этаж
        //кв на этаже неизвестно

       int apartPerLevel= (int) Math.round(k2/(double)n2); //квартир на этаже
       int apartInEntrance=apartPerLevel*m;

        for(int i=1;i<=1000000;i++){ //определяем верный подъезд
            if(k2<=apartInEntrance*i){
                p2Right=i;
                break;
            }
        }
        if(p2!=p2Right) {
            System.out.println(-1+" "+-1);
            return;
        }


       for(int i=1;i<=1000000;i++){ //определяем подъезд
           if(k1<=apartInEntrance*i){
               p1=i;
               break;
           }
       }
       if(k1>apartInEntrance){ //p1 >=2    определяем этаж
           k1New=k1-((p1-1)*apartInEntrance);
          n1= (int) Math.ceil(k1New/(double)apartPerLevel);
       }

       if(m==0||k1==0||k2==0||p2==0||n2==0) System.out.println(-1+" "+-1);
       else if(m==1) System.out.println(0+" "+n1);
        else System.out.println(p1+" "+n1);


    }
}
