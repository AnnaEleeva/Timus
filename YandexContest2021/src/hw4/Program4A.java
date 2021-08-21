package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Program4A {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4A_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        HashMap<String,String> sinonimsDict=new HashMap<>();

        int countStrings= Integer.parseInt(scanner.nextLine());

        for(int i=0;i<countStrings;i++){
            String[] pairStr=scanner.nextLine().split(" ");
            sinonimsDict.put(pairStr[0],pairStr[1]);
            sinonimsDict.put(pairStr[1],pairStr[0]);
        }

        String word = scanner.nextLine();
        System.out.println(sinonimsDict.get(word));
    }
}
