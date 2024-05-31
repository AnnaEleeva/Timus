package org.example.sets_hashs.hashs;

import org.example.sets_hashs.Dog;

import java.util.HashSet;
import java.util.Set;

public class MainForHash {
    public static void main(String[] args) {
        // HashSet по сути является обёрткой над HashMap.
        // Элементы HashSet хранятся в качестве ключей в этом HashMap, а значение всегда фиксировано и равно new Object()
        // hashCode надо переопределять чтобы эффективно работал HashMap, чтобы распределялось равномерно по бакетам
        Set<Dog> dogSet = new HashSet<>();
        dogSet.add(new Dog("Pip"));
        dogSet.add(new Dog("dd"));
        System.out.println(dogSet);


        Tiger t1 = new Tiger("Alfa", 5);
        Tiger t2 = new Tiger("Betta", 5);
        System.out.println(t1.equals(t2)); //true

        Tiger t3 = new Tiger("Gamma", 3);
        System.out.println(t1.equals(t3)); //false

        Tiger t4 = new Tiger("Alfa", 3);
        System.out.println(t1.equals(t4)); //false

        Tiger t5 = new Tiger("Alfa", 5);
        System.out.println(t1.hashCode() + " " + t5.hashCode()); //63348288 63348288
        System.out.println(t1.hashCode() + " " + t2.hashCode()); //63348288 1986370792

    }
}
