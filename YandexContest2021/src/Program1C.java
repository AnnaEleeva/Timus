import java.util.Scanner;
public class Program1C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        String t1 = scanner.nextLine();
        String t2 = scanner.nextLine();
        String t3 = scanner.nextLine();

        String numberDigits = normalizeNumber(number);
        String t1Digits = normalizeNumber(t1);
        String t2Digits = normalizeNumber(t2);
        String t3Digits = normalizeNumber(t3);



        if ((numberDigits.equals(t1Digits))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if ((numberDigits.equals(t2Digits))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if ((numberDigits.equals(t3Digits))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    public static String normalizeNumber(String number){
        String numberDigits = number.replaceAll("[^0-9]", "");

        if(numberDigits.length()==7) numberDigits="8495"+numberDigits;
        else if(numberDigits.length()==11) numberDigits=changeCharInPosition(0, '8',numberDigits);

        return numberDigits;
    }
    public static String changeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
}
