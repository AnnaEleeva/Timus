package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Program3H {
    public static void main(String[] args) throws IOException {

        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3H_test";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        //сет верхних птиц, чтобы сохранять координаты (строк) - достаточно одной координаты, чтобы понять, что весь ряд птиц будет уничтожен
        HashSet<Integer> topsSet =new HashSet<>();

        //число птиц
        int countBirds= Integer.parseInt(scanner.nextLine());


        //int countHonestTurtle=0;

        for(int i=0;i<countBirds;i++){
            String[] pairStr=scanner.nextLine().split(" ");
            //берем пару - координаты птицы
            int[] pair = Arrays.stream(pairStr).mapToInt(Integer::parseInt).toArray();

           topsSet.add(pair[0]);

        }

        System.out.println(topsSet.size());


    }
}
