import java.util.Scanner;

public class Program1068 {

    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();


        if (number == 1) {
            System.out.println(1);
            return;
        }

        if (number > 1) {

            for (int i = 1; i <= number; i++) {
                sum = sum + i;
            }
        } else {
            for (int i = number; i <= 1; i++) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
