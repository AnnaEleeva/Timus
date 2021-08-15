package hw3;

import java.util.*;

public class Program3B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strNumbers1=scanner.nextLine();

        //сформируем ArrayList из строки чисел
        String [] strings1 =strNumbers1.split(" ");

        int[] arrayNumbers1 = Arrays.stream(strings1).mapToInt(Integer::parseInt).toArray();


        String strNumbers2=scanner.nextLine();

        //сформируем ArrayList из строки чисел
        String [] strings2 =strNumbers2.split(" ");

        int[] arrayNumbers2 = Arrays.stream(strings2).mapToInt(Integer::parseInt).toArray();

        HashSet<Integer> hashSet1=new HashSet<>();
        HashSet<Integer> hashSet2=new HashSet<>();
        for(int e:arrayNumbers1){
            hashSet1.add(e);
        }
        for(int e:arrayNumbers2){
            hashSet2.add(e);
        }
        hashSet1.retainAll(hashSet2);
//        ArrayList<Integer> arrayList = new ArrayList<>(hashSet1);
//        Collections.sort(arrayList);
//        for(int e:arrayList){
//            System.out.print(e+" ");
//        }
        for(int e: hashSet1){
            System.out.print(e+" ");
        }
    }
}
