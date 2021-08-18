package hw3;

import java.util.*;

public class Program3C_hash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String countBricksAB_str=scanner.nextLine();

        //сформируем ArrayList из строки чисел
        String [] countBricksAB_strArr =countBricksAB_str.split(" ");
        int[] countBricksAB_intArr = Arrays.stream(countBricksAB_strArr).mapToInt(Integer::parseInt).toArray();

        //сет Ани
        HashSet<Integer> a_set =new HashSet<>();
        //сет для пересечения = сет Ани
        HashSet<Integer> intersection_set =new HashSet<>();
        //читаем кубики Ани
        for(int i=0;i<countBricksAB_intArr[0];i++){
            int input_num=scanner.nextInt();
            a_set.add(input_num);
            intersection_set.add(input_num);
        }
        //сет Бори
        HashSet<Integer> b_set =new HashSet<>();
        //читаем кубики Бори
        for(int i=0;i<countBricksAB_intArr[1];i++){
            b_set.add(scanner.nextInt());
        }

        intersection_set.retainAll(b_set); //пересечение сетов А и В

        //находим разность
        a_set.removeAll(intersection_set);
        b_set.removeAll(intersection_set);

        ArrayList<Integer>sorted_a_set = new ArrayList(a_set);
        Collections.sort(sorted_a_set);

        ArrayList<Integer> sorted_b_set = new ArrayList(b_set);
        Collections.sort(sorted_b_set);

        ArrayList<Integer> sorted_intersection_set = new ArrayList(intersection_set);
        Collections.sort(sorted_intersection_set);



        System.out.println(intersection_set.size());
        for(int e:sorted_intersection_set){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println(a_set.size());
        for(int e:sorted_a_set){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println(b_set.size());
        for(int e:sorted_b_set){
            System.out.print(e+" ");
        }

    }
}
