import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Program1001 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("start");
        ArrayList<Double> allDigitals = new ArrayList<>();

        while(true){
            String s=scanner.nextLine();
            if(s.isEmpty()) return;
            String[] inputStr=s.split("\\s+");
           for(int i=0;i<inputStr.length;i++){
               allDigitals.add(Double.parseDouble(inputStr[i]));
           }
        }

    }
}
