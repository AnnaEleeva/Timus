package hw3;

import java.util.HashSet;
import java.util.Scanner;

public class Program3A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set=new HashSet<>();
        while (scanner.hasNextInt())
            set.add(scanner.nextInt());

        System.out.println(set.size());
    }
}