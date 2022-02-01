//В центре города Че есть пешеходная улица - одно из самых популярных мест для прогулок жителей города. По этой улице очень приятно гулять, ведь вдоль улицы расположено n забавных памятников.
//
//        Девочке Маше из города Че нравятся два мальчика из ее школы, и она никак не может сделать выбор между ними. Чтобы принять окончательное решение, она решила назначить обоим мальчикам свидание в одно и то же время. Маша хочет выбрать два памятника на пешеходной улице, около которых мальчики будут ее ждать. При этом она хочет выбрать такие памятники, чтобы мальчики не увидели друг друга. Маша знает, что из-за тумана мальчики увидят друг друга только в том случае, если они будут на расстоянии не более r метров.
//
//        Маше заинтересовалась, а сколько способов есть выбрать два различных памятника для организации свиданий.

//задача на два указателя классическая, как в лекции полностью

package hw5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program5D {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw5\\Program5D_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);


        String [] string =scanner.nextLine().split(" ");
        int countMonuments= Integer.parseInt(string[0]);
        int d= Integer.parseInt(string[1]);

        String [] monumentsStr =scanner.nextLine().split(" ");
        int[] monuments = Arrays.stream(monumentsStr).mapToInt(Integer::parseInt).toArray();

        System.out.println(countPairMonuments(monuments,d));
    }
    //4 4
    //1 3 5 8   //1 и 8,  3 и 8
    public static long countPairMonuments(int[] monuments,int d){
        long countGoodPair=0;
        int last=0;
        for(int first=0;first<monuments.length;first++){
            while ((last<monuments.length)&&((monuments[last]-monuments[first])<=d)){
                last++;
            }
            countGoodPair+=monuments.length-last;
        }

        return countGoodPair;
    }

}
