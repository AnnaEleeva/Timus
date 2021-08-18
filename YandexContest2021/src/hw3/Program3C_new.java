package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Program3C_new {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        String countBricksAB_str=scanner.nextLine();

        //сформируем ArrayList из строки чисел
        String [] countBricksAB_strArr =countBricksAB_str.split(" ");
        int[] countBricksAB_intArr = Arrays.stream(countBricksAB_strArr).mapToInt(Integer::parseInt).toArray();

        int countBricksAB=countBricksAB_intArr[0]+countBricksAB_intArr[1];


        HashSet<Integer> hashSet =new HashSet<>();
        TreeSet<Integer> a_treeSet=new TreeSet();
        TreeSet<Integer> b_treeSet=new TreeSet();

        TreeSet<Integer> intersection=new TreeSet<>();
        for(int i=1;i<countBricksAB+1;i++){
            int input= scanner.nextInt();
            if(!hashSet.contains(input)){
                hashSet.add(input);
                if(i<=countBricksAB_intArr[0]){
                    a_treeSet.add(input);
                }
                else{
                    b_treeSet.add(input);
                }
            }else{
                intersection.add(input);
            }
        }

        a_treeSet.removeAll(intersection);

        System.out.println(intersection.size());
        for(int e:intersection){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println(a_treeSet.size());
        for(int e:a_treeSet){
            System.out.print(e+" ");
        }
        System.out.println();
        System.out.println(b_treeSet.size());
        for(int e:b_treeSet){
            System.out.print(e+" ");
        }
    }
}
