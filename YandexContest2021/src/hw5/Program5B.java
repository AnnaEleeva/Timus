//Вася очень любит везде искать своё счастливое число K. Каждый день он ходит в школу по улице, вдоль которой припарковано N машин. Он заинтересовался вопросом, сколько существует наборов машин, стоящих подряд на местах с L до R, что сумма их номеров равна K. Помогите Васе узнать ответ на его вопрос.
//        Например, если число
//        N=5,K=17, а номера машин равны 17, 7, 10, 7, 10, то существует 4 набора машин:
//        17 (L=1,R=1),7, 10 (L=2,R=3),10, 7 (L=3,R=4),7, 10 (L=4,R=5)
//
//        Формат ввода
//        В первой строке входных данных задаются числа N и K (1≤N≤100 000,1≤K≤10 9).
//        Во второй строке содержится N чисел, задающих номера машин. Номера машин могут принимать значения от 1 до 999 включительно.
//
//        Формат вывода
//        Необходимо вывести одно число — количество наборов.
//ВВОД
//5 17
//17 7 10 7 10
//ВЫВОД
// 4
//ВВОД
//5 10
//1 2 3 4 1
//ВЫВОД
// 2

//задача на префиксную сумму.


package hw5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Program5B  {

    public static void main(String[] args) throws IOException {
        String fileName = "YandexContest2021/src/hw5/Program5B_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);


        String [] string2 =scanner.nextLine().split(" ");
        int[]countAndK = Arrays.stream(string2).mapToInt(Integer::parseInt).toArray();

        int k=countAndK[1];

        String [] string =scanner.nextLine().split(" ");
        int[] arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();


        int result=countZeroSumRanges(countPrefixSums(arrayNumbers),countPrefixSums(arrayNumbers),k);
        System.out.println(result);
        //System.out.println(countZeroSumRanges(countPrefixSums(arrayNumbers)));
    }
    //делаем карту с префиксными суммами.
    public static HashSet<Integer> countPrefixSums(int[]array){
        //карта префиксных сумм, в которых без индексов хранятся подсчитываемые суммы и их количество
        HashSet<Integer> prefixSumByValue=new HashSet<>();//Внимание! Количество считать на надо. Можно было сделать сетом
        //сюда суммируем все значения
        int nowSum=0;
        //добавляем 0-е значение префиксных сумм
        prefixSumByValue.add(nowSum);
        for(int now:array){
            nowSum+=now;

            prefixSumByValue.add(nowSum);
        }
        return prefixSumByValue;
    }

    //берем две одинаковые карты получившихся префиксных сумм
    // По одной просто идем, а в другой смотрим есть ли значение e+k, если есть, уменьшаем кол-во
    public static int countZeroSumRanges(HashSet<Integer> prefixSumByValue,HashSet<Integer> prefixSumByValue2,int k){
        int cntRanges=0;

        //по какой-то карте идем, а в какой-то - меняем кол-во встречаемых чисел.
        // Т.е в префиксной сумме  0 17 24 34 41 51 к каждому числу прибавляем 17 и смотрим есть ли такая сумма
        // (0+17)- есть, (17+17)-есть, (24+17)=41 -есть, (34+17)=51-есть, (51+17)-нет ИТОГО: 4
        for (int e : prefixSumByValue2) {
            if (prefixSumByValue.contains(e + k)) {
              //  if (prefixSumByValue.get(e + k) == 1) {
                   prefixSumByValue.remove(e + k);
              //  } else if (prefixSumByValue.get(e + k) > 1) {
              //      prefixSumByValue.put(e + k, prefixSumByValue.get(e + k) - 1);
              //  }
                cntRanges++;
            }
        }
        return cntRanges;
    }


}
