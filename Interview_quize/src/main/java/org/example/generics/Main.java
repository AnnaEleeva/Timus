package org.example.generics;

public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Gav");
        Box<Dog> dogBox = new Box<>(dog1);

        Cat cat1 = new Cat("Mew");
        Box<Cat> catBox = new Box<>(cat1);

        System.out.println(dogBox.getValue());
        System.out.println(catBox.getValue());  //Cat{name='Mew'}


    }
}
