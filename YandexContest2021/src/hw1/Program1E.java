package hw1;

import java.util.Scanner;

public class Program1E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k1=scanner.nextInt();
        int p1 = -2; //подъезд
        int n1=-2; //этаж
        int k1New=-2;


        int m=scanner.nextInt(); //всего этажей в доме
        int k2=scanner.nextInt(); //кв
        int p2=scanner.nextInt(); //подъезд
        int p2Right=-2;
        int n2=scanner.nextInt(); //этаж
        //кв на этаже неизвестно

       /* if(m==1&&n2==1&&k2==p2&&k2!=1){
            System.out.println(k1+" "+1);
            return;
        }*/

       int apartPerLevel= (int) Math.round(k2/(double)n2); //квартир на этаже
       int apartInEntrance=apartPerLevel*m;

     //  if((apartPerLevel+1)*n2)

     /*  if(p2==1&&n2==1){
           System.out.println(1+" "+0);
           return;
       }*/

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
       if(k1>apartInEntrance){ //p1 >=2    корректируем, если подъезд не 1, чтоб определить этаж
           k1New=k1-((p1-1)*apartInEntrance);}
       else{
           k1New=k1;
       }
          n1= (int) Math.ceil(k1New/(double)apartPerLevel); //определяем этаж

        int nX1=(int) Math.ceil(k2/(double)(apartPerLevel-1));
        int nX2=(int) Math.ceil(k2/(double)(apartPerLevel+1));

        boolean manyEntrance=(n1==nX1||n1==nX2);


       if(m==0||k1==0||k2==0||p2==0||n2==0) System.out.println(-1+" "+-1);
       else if(m==1||manyEntrance) System.out.println(0+" "+n1);
        else if(p2==1&&n2==1) System.out.println(1+" "+0);
            else System.out.println(p1+" "+n1);


    }
}
