package org.example.generics;

public class Cat implements Comparable<Cat> {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Cat otherCat) {
        if (otherCat == null) {
            throw new NullPointerException("The other cat to compare to is null");
        }
        return this.name.compareTo(otherCat.name);
    }

    @Override
    public String toString() {
        return "Cat{name='" + name + "'}";
    }
}
