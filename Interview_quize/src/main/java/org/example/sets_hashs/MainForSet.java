package org.example.sets_hashs;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainForSet {
    public static void main(String[] args) {

//        HashSet по сути является обёрткой над HashMap.
//        Элементы HashSet хранятся в качестве ключей в этом HashMap, а значение всегда фиксировано и равно new Object()
        Set<Dog> dogSet = new HashSet<>();
        dogSet.add(new Dog("Pip"));
        dogSet.add(new Dog("dd"));
        System.out.println(dogSet);


//        TreeSet<Dog> dogTreeSet = new TreeSet<>(); //ClassCastException: class org.example.sets.Dog cannot be cast to class java.lang.Comparable
//        dogTreeSet.add(new Dog("Pow"));
//        System.out.println(dogTreeSet);

        TreeSet<DayOfWeek> daysSet = new TreeSet<>(); //можно потому что Enum реализует interface Comparable
        daysSet.add(DayOfWeek.FRIDAY);
        System.out.println(daysSet);
        System.out.println(DayOfWeek.FRIDAY.ordinal()); //4

//        public int compareTo(MyEnum other) {
//            return this.ordinal() - other.ordinal();  - так реализован compareTo у Enum, original - порядковый номер
//        }

        TreeSet<Cat> catsSet = new TreeSet<>();  //можно потому что реализовали interface Comparable
        catsSet.add(new Cat("Manya"));
        System.out.println(catsSet);
    }
}
