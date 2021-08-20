//внимательно читай условие, в условии сказано, что будут отрицательные числа - их надо пропустить
//решена!
//Широко известна следующая задача для младших школьников. Три черепахи ползут по дороге. Одна черепаха говорит: “Впереди меня две черепахи”. Другая черепаха говорит: “Позади меня две черепахи”. Третья черепаха говорит: “Впереди меня две черепахи и позади меня две черепахи”. Как такое может быть? Ответ: третья черепаха врет! По дороге одна за другой движутся N черепах. Каждая черепаха говорит фразу вида: “Впереди меня ai черепах, а позади меня bi черепах”. Ваша задача определить, сколько самое большее количество черепах могут говорить правду.
//Формат ввода
//        В первой строке вводится целое число N (1 ≤ N ≤ 10000) строк, содержащих целые числа ai и bi, по модулю не превосходящие 10000, описывающие высказывание i-ой черепахи.
//
//        Формат вывода
//        Выведите целое число M – максимальное количество черепах, которые могут говорить правду.
package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Program3G_new {
    public static void main(String[] args) throws IOException {


        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3G_test";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        //сет, чтобы сохранять подходящие значения, так как только одна черепаха может сказать одно и тоже
        HashSet<Integer> honestTurtlePair =new HashSet<>();

        //число черепах
        int countTurtle= Integer.parseInt(scanner.nextLine());


        int countHonestTurtle=0;

        for(int i=0;i<countTurtle;i++){
            String[] pairStr=scanner.nextLine().split(" ");
            //берем пару - сколько черепах впереди и позади
            int[] pair = Arrays.stream(pairStr).mapToInt(Integer::parseInt).toArray();

            //если отрицательные числа - пропускаем их
            if((pair[0]<0)||(pair[1]<0))continue;
            //проверка, что элемент на побочной диагонали
            if(((countTurtle-1)-pair[0])==pair[1]){
                //проверка, что только одна честная черепаха может сказать такие значения, остальных не считает, они врут
                if(!honestTurtlePair.contains(pair[0])){
                    countHonestTurtle++;
                    honestTurtlePair.add(pair[0]);
                }

            }
        }

        System.out.println(countHonestTurtle);

    }
}
