package hw2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program2A {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        readUsingScanner(fileName);


    }

    public static void readUsingScanner(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        int previous=Integer.MIN_VALUE;
        Scanner scanner = new Scanner(path);
        //читаем построчно
        while(scanner.hasNextInt()){
            int x = scanner.nextInt();
            if(x<=previous){
                System.out.println("NO");
                return;
            }
            previous=x;


        }
        System.out.println("YES");
    }
}
