package org.example.wrappers;

public class Wrappers {
    public static void main(String[] args) {
        Integer x = 5;
        Integer y = x;
        x++;
        System.out.println(y); //5  потому что хоть это и ссылка, класс Integer - Immutable, каждый раз создается новый объект
        System.out.println(x); //6


        int x2 =5;
        int y2 =x2;
        x2++;
        System.out.println(y2); //5
        System.out.println(x2); //6



        Dog dog1 = new Dog("Delya");
        Dog dog2 = dog1;
        dog1.setName("Moisey");

        System.out.println(dog2.getName()); // Moisey потому что ссылочный тип
        System.out.println(dog1.getName()); // Moisey


        // инкремент

        int a=4;
        int b=4;
        System.out.println(a++); //4
        System.out.println(++b); //5

        int c=4;
        int d=4;
        c++;
        ++d;
        System.out.println(c); //5
        System.out.println(d); //5



    }
}


