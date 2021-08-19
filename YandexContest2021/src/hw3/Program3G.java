package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program3G {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3G_test";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int countTurtle= Integer.parseInt(scanner.nextLine());
        //int countTurtle=5;


        int[][] matrix=new int[countTurtle][countTurtle];

        for(int i=0;i<countTurtle;i++){
            String[] pairStr=scanner.nextLine().split(" ");
            int[] pair = Arrays.stream(pairStr).mapToInt(Integer::parseInt).toArray();
            matrix[pair[0]][pair[1]]=1;
        }

        int countHonestTurtle=0;

        int j=countTurtle-1;
        for(int i=0;i<countTurtle;i++){

                if(matrix[i][j]==1)countHonestTurtle++;
            j--;
        }

        System.out.println(countHonestTurtle);
    }
}
