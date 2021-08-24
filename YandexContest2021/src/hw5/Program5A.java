//
//Глеб обожает шоппинг. Как-то раз он загорелся идеей подобрать себе майку и штаны так, чтобы выглядеть в них максимально стильно. В понимании Глеба стильность одежды тем больше, чем меньше разница в цвете элементов его одежды.
//
//        В наличии имеется N (1 ≤ N ≤ 100 000) маек и M (1 ≤ M ≤ 100 000) штанов, про каждый элемент известен его цвет (целое число от 1 до 10 000 000). Помогите Глебу выбрать одну майку и одни штаны так, чтобы разница в их цвете была как можно меньше.
//
//        Формат ввода
//        Сначала вводится информация о майках: в первой строке целое число N (1 ≤ N ≤ 100 000) и во второй N целых чисел от 1 до 10 000 000 — цвета имеющихся в наличии маек. Гарантируется, что номера цветов идут в возрастающем порядке (в частности, цвета никаких двух маек не совпадают).
//
//        Далее в том же формате идёт описание штанов: их количество M (1 ≤ M ≤ 100 000) и в следующей строке M целых чисел от 1 до 10 000 000 в возрастающем порядке — цвета штанов.
//
//        Формат вывода
//        Выведите пару неотрицательных чисел — цвет майки и цвет штанов, которые следует выбрать Глебу. Если вариантов выбора несколько, выведите любой из них.

//задача на два указателя

package hw5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program5A {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw5\\Program5A_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int coutShirts= Integer.parseInt(scanner.nextLine());
        String [] string =scanner.nextLine().split(" ");
        int[] shirts = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        int coutPants= Integer.parseInt(scanner.nextLine());
        String [] string2 =scanner.nextLine().split(" ");
        int[] pants = Arrays.stream(string2).mapToInt(Integer::parseInt).toArray();



        // меняем, чтобы быстрее  и правильнее работал. хотя хз
        if(shirts.length<=pants.length)
            bestPairOfClothes(shirts,pants,false);
        else bestPairOfClothes(pants,shirts,true); //меняем shirts - всегда меньше


    }
    //метод - переделанный классический два указателя. Только тут Правый указатель смещается только когда следующий элемент более выгоден. Поэтому обязательно смотрим на следующий элемент.
    //в классической задаче не смотрели на следующий элемент. Там мы находили первый подходящий и все за ним были больше и тоже подходили
    public static void bestPairOfClothes(int[] shirts,int[] pants,boolean wasSwap){
        int minDiff=Integer.MAX_VALUE;

        int innerMin;
        int last=0; //=first in pants
        int a=-1;
        int b=-1;
        //идем по футболкам
        for(int first=0;first<shirts.length;first++){

            //если среди каких-то из пар возникнет разница =0 то сразу выходим - это лучший результат
            if((pants[last]-shirts[first])==0){
                System.out.println((pants[last]+" "+shirts[first]));
                return;
            }
            //внутренняя разница. У кажой футболки она начнетется с нее и тех шорт на которых остановились. Внутренняя разница нужна для прохода по шортам
             innerMin=Math.abs(pants[last]-shirts[first]);
            //если впереди стоящие шорты дают более подходящую разницу, то сдвигаем правую границу(last). А если нет, то переходим к следующей футболке
            //левый указатель смещается на следующую футболку, а правый указатель остается на тех шортах, которые давали минимальную разницу(innerMin) с предыдущей футболкой.
            while ((last<pants.length-1)&&Math.abs(pants[last+1]-shirts[first])<innerMin){
                innerMin=Math.abs(pants[last+1]-shirts[first]);
                last++;
            }

            //сравниваем innerMin и minDiff. Вдруг именно  этот innerMin - будет минимальной разницей. Тогда запишем в минимальную разницу
            if(Math.abs(pants[last]-shirts[first])<minDiff){
                minDiff=Math.abs(pants[last]-shirts[first]);
                a=shirts[first];
                b=pants[last];
            }

        }


        //если меняли массивы шорт и футболок местами, то и вывод меняем
        if(wasSwap)
            System.out.println(b+" "+a);
        else System.out.println(a+" "+b);


    }

}
