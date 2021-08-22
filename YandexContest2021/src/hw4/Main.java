package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4H_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int wL =scanner.nextInt();
        int sL=scanner.nextInt();
        char ch=scanner.next().charAt(0);
        System.out.println(ch);
    }
}
