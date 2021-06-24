
import java.util.Scanner;

public class Program1000 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String inputLine= scanner.nextLine();
        String[] numbers=inputLine.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);

        System.out.println(a+b);

    }
}
