package hw3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Program3C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String countBricksAB_str=scanner.nextLine();

        //сформируем ArrayList из строки чисел
        String [] countBricksAB_strArr =countBricksAB_str.split(" ");
        int[] countBricksAB_intArr = Arrays.stream(countBricksAB_strArr).mapToInt(Integer::parseInt).toArray();

        //сет Ани
        TreeSet<Integer> a_set =new TreeSet<>();
        //сет для пересечения = сет Ани
        TreeSet<Integer> intersection_set =new TreeSet<>();
        //читаем кубики Ани
        for(int i=0;i<countBricksAB_intArr[0];i++){
            int input_num=scanner.nextInt();
            a_set.add(input_num);
            intersection_set.add(input_num);
        }
        //сет Бори
        TreeSet<Integer> b_set =new TreeSet<>();
        //читаем кубики Бори
        for(int i=0;i<countBricksAB_intArr[1];i++){
            b_set.add(scanner.nextInt());
        }

        intersection_set.retainAll(b_set); //пересечение сетов А и В

        //находим разность
        a_set.removeAll(intersection_set);
        b_set.removeAll(intersection_set);

        System.out.println(intersection_set.size());
        for(int e:intersection_set){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println(a_set.size());
        for(int e:a_set){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println(b_set.size());
        for(int e:b_set){
            System.out.print(e+" ");
        }

    }
}
