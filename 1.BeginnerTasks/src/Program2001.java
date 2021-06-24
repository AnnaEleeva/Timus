import java.util.Scanner;
public class Program2001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] veight1 = scanner.nextLine().split(" ");
        String[] veight2 = scanner.nextLine().split(" ");
        String[] veight3 = scanner.nextLine().split(" ");

        int basket2=Integer.parseInt(veight2[1]);
        int basket1=Integer.parseInt(veight3[0]);

        int basketBerry1=Integer.parseInt(veight1[0]);
        int basketBerry2=Integer.parseInt(veight1[1]);

        System.out.println((basketBerry1-basket1)+ " "+ (basketBerry2-basket2));
    }
}
