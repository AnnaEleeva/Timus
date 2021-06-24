import java.util.Scanner;
public class Program1293 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data=scanner.nextLine().split(" ");
        int n=Integer.parseInt(data[0]);
        int a=Integer.parseInt(data[1]);
        int b=Integer.parseInt(data[2]);

        System.out.println(a*b*n*2);
    }
}
