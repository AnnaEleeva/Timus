import java.util.Scanner;
public class Program1877 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstPassword = scanner.nextLine();
        String secondPassword = scanner.nextLine();

        boolean isFirstOdd = isOdd(firstPassword);
        boolean isSecondOdd = isOdd(secondPassword);


       if(isFirstOdd || (!isSecondOdd && !secondPassword.equals("0000"))){
            System.out.println("yes");
        }
        else if(!isFirstOdd || isSecondOdd) System.out.println("no");

    }
    public static boolean isOdd(String password){
        return Character.getNumericValue(password.charAt(3))%2==0;
    }


}
