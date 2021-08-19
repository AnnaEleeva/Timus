package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Program3G_new {
    public static void main(String[] args) throws IOException {

        HashSet<Integer> hashSet1=new HashSet<>();
        HashSet<Integer> hashSet2=new HashSet<>();
        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3G_test";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int countTurtle= Integer.parseInt(scanner.nextLine());
        //int countTurtle=5;

        int middle1;
        int middle2;
        if(countTurtle%2==0){
             middle1=countTurtle/2;
             middle2=countTurtle/2-1;
        }else {
             middle1=countTurtle/2;
             middle2=middle1;
        }
        int countHonestTurtle=0;

        for(int i=0;i<countTurtle;i++){
            String[] pairStr=scanner.nextLine().split(" ");
            int[] pair = Arrays.stream(pairStr).mapToInt(Integer::parseInt).toArray();
            if(Math.abs(pair[0]-middle1)==Math.abs(pair[1]-middle2)){
                countHonestTurtle++;
            }
        }

        System.out.println(countHonestTurtle);

    }
}
