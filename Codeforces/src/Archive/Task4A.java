//Арбуз
package Archive;
import java.util.Scanner;
public class Task4A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer w=scanner.nextInt();

        if((w>2)&&(w%2==0))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
