package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Program4E {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4E_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);


        int countBricks= scanner.nextInt();
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int i=0;i<countBricks;i++){

            int w=scanner.nextInt();
            int h=scanner.nextInt();
            if(hashMap.containsKey(w)){
                if(hashMap.get(w)<h){
                    hashMap.put(w,h);
                }
            }else{
                hashMap.put(w,h);
            }

        }
        long sum=0;
        for(int e: hashMap.keySet()){
            sum+=hashMap.get(e);
        }
        System.out.println(sum);
    }
}
