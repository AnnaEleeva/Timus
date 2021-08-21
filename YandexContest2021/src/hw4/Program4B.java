package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Program4B {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4B_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path).useDelimiter("\\s+");

        HashMap<String,Integer> hashMap = new HashMap<>();
        while (scanner.hasNext()){
            String word=scanner.next();
            if(hashMap.containsKey(word)){
                int count=hashMap.get(word);
                hashMap.put(word,count+1);
                System.out.print(count+1+" ");
            }
            else{
                hashMap.put(word,0);
                System.out.print(0+" ");

            }


        }
//        Scanner scanner2 = new Scanner(path).useDelimiter("\\s+");
//        while (scanner2.hasNext()){
//            String word=scanner2.next();
//            System.out.print(hashMap.get(word)+" ");
//        }
    }
}
