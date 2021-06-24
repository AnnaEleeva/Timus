import java.util.Scanner;
public class Program2066 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer input1 = scanner.nextInt();
        Integer input2 = scanner.nextInt();
        Integer input3 = scanner.nextInt();

        int min=101;
        int a=0;
        int b=0;

        if(input1<min) {min=input1; a=input2; b=input3;}
        if(input2<min) {min=input2; a=input1; b=input3;}
        if(input3<min) {min=input3; a=input1; b= input2;}


if(a==1||b==1||a==0||b==0) System.out.println(min-a-b);
else System.out.println(min-(a*b));


    }
}