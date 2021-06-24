import java.util.Scanner;
public class Program1402 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data=scanner.nextLine().split(" ");
        int g=Integer.parseInt(data[0]);
        int l=Integer.parseInt(data[1]);

        int sum=g+l-1;
        System.out.println((sum-g)+" "+ (sum-l));
    }
}
