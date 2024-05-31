package org.example.interface_markers;

public class ClonableClassBase implements Cloneable{

    String name;
    String description = "I can be cloned!";
    int time;

    public ClonableClassBase(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public ClonableClassBase clone() {
        try {
            return (ClonableClassBase) super.clone();   // return super.clone(); - вызывает базовую реализацию
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "ClonableClassBase{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}
