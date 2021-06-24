import java.util.Scanner;
public class Program1264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");


        int first=Integer.parseInt(inputLine[0]);
        int second=Integer.parseInt(inputLine[1]);

        System.out.println(first*(second+1));
    }
}
