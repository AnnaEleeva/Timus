package hw1;

import java.util.Scanner;

public class Program1I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();
        int d=scanner.nextInt();
        int e=scanner.nextInt();

        if((d>=a||d>=b||d>=c)&&(e>=a||e>=b||e>=c)) System.out.println("YES");
        else System.out.println("NO");
    }
}
