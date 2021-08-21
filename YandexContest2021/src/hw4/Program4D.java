package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Program4D {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\ Program4D_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int countButton= scanner.nextInt();


        LinkedHashMap<Integer,Integer> hashMap=new LinkedHashMap<>(countButton);

//        String[] buttonsStr=scanner.nextLine().split(" ");
//        int[] buttons = Arrays.stream(buttonsStr).mapToInt(Integer::parseInt).toArray();

        //словарь где у каждой клавиши указано предельное число нажатий
        for(int i=1;i<countButton+1;i++){
            hashMap.put(i,scanner.nextInt());
        }

        int allPushes=scanner.nextInt();
        for(int i=1;i<allPushes+1;i++){
            int nowButton=scanner.nextInt();
            hashMap.put(nowButton,hashMap.get(nowButton)-1);
        }

        for(int e:hashMap.keySet()){
            if(hashMap.get(e)<0)
                System.out.println("YES");
            else System.out.println("NO");
        }


    }
}
