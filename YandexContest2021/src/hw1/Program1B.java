package hw1;/*
https://contest.yandex.ru/contest/27393/problems/B/
*/

import java.util.Scanner;
public class Program1B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a=scanner.nextInt();
        scanner.skip("\n");
        int b=scanner.nextInt();
        scanner.skip("\n");
        int c=scanner.nextInt();


        if (forTriangle(a, b, c) && forTriangle(a, c, b) && forTriangle(c, b, a)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
    public static boolean forTriangle(int x,int y,int z){
        return x + y > z;
    }
}
