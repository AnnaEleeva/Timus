import java.util.HashMap;
import java.util.Scanner;
public class Program1197 {
    public static void main(String[] args) {

        HashMap<Character,Integer> alphabet = new HashMap<Character, Integer>();
        alphabet.put('a',1);
        alphabet.put('b',2);
        alphabet.put('c',3);
        alphabet.put('d',4);
        alphabet.put('e',5);
        alphabet.put('f',6);
        alphabet.put('g',7);
        alphabet.put('h',8);


        Scanner scanner = new Scanner(System.in);
        int countTests= Integer.parseInt(scanner.nextLine());
        for(int i=0;i<countTests;i++){
            //scanner.skip("\n");
            String test=scanner.nextLine();
            Character letter=test.charAt(0);
            int x=alphabet.get(letter);
            int y=Integer.parseInt(String.valueOf(test.charAt(1)));

            int countSteps=0;

            if(x+1<=8&&y+2<=8) countSteps++;
            if(x-1>=1&&y+2<=8) countSteps++;
            if(x+1<=8&&y-2>=1) countSteps++;
            if(x-1>=1&&y-2>=1) countSteps++;

            if(y+1<=8&&x+2<=8) countSteps++;
            if(y-1>=1&&x+2<=8) countSteps++;
            if(y+1<=8&&x-2>=1) countSteps++;
            if(y-1>=1&&x-2>=1) countSteps++;


            System.out.println(countSteps);


        }
    }
}
