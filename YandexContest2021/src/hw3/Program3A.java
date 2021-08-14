package hw3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program3A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set=new TreeSet<>();
        while (scanner.hasNextInt())
            set.add(scanner.nextInt());

        System.out.println(set.size());
    }
}
