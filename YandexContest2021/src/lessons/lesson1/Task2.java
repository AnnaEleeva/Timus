//максимум последовательности
package lessons.lesson1;
import java.util.Arrays;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine=scanner.nextLine();
        String[] numbersStr=inputLine.split(" ");

        int[] seq = Arrays.stream(numbersStr).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMax(seq));
    }
    public static String findMax(int[] seq){
        if(seq.length==0){
           return "Infinity";
        }
        else {
            int seqmax=seq[0];
            for(int i=0;i<seq.length;i++){
                if(seq[i]>seqmax){
                    seqmax=seq[i];
                }
            }
            return String.valueOf(seqmax);
        }
    }
}
