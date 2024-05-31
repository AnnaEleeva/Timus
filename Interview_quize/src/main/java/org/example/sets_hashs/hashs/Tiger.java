package org.example.sets_hashs.hashs;

import java.util.Objects;

public class Tiger {
    String name;

    public Tiger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tiger tiger)) return false;
        return age == tiger.age;
//        return age == tiger.age && Objects.equals(name, tiger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
