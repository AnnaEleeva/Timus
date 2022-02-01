package hw7;
//где-то недосчитывает обозримые парты
//вместо 3 выводит 80
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Program7A {
    public static void main(String[] args) throws IOException {
        String fi = "YandexContest2021/src/hw7/Program7A_test.txt";
        String fi2 = "YandexContest2021/src/hw7/t008.txt";
        String ft="input.txt";
        Path path = Paths.get(fi2);
        Scanner scanner = new Scanner(path);

        //int coutShirts= Integer.parseInt(scanner.nextLine());
        String[] string = scanner.nextLine().split(" ");
        int[] count = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();
        int students = count[0];
        int teachers = count[1];

        TreeMap<Integer, Integer> event = new TreeMap<>();

        for (int i = 0; i < teachers; i++) {
            String[] s = scanner.nextLine().split(" ");
            int[] pair = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

            event.put(pair[0], 1);
            event.put(pair[1], -1);
        }

        int onview = 0;
        int countDesk = 0;
        for (int i = 0; i < students; i++) {

             if (event.containsKey(i)) {
                //System.out.println("desk on view i "+i);
                if (event.get(i) == 1) onview++;
//                if (onview != 0){
//                    System.out.println("desk on view i "+i);
//                    countDesk++;
//                }
                else if (event.get(i) == -1 ) {
                    if(onview>0)onview--;
                    if(onview==0)countDesk++;
                }

            }
            if (onview>0){
                 System.out.println("desk on view i "+i);
                countDesk++;
            }
        }
        System.out.println(students - countDesk);

    }
}
