package org.example.interface_markers;

public class ClonableClassCustom implements Cloneable{

    String name;
    String description = "I can be cloned custom!";
    int time;

    public ClonableClassCustom(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public ClonableClassCustom clone() {
        try {
            ClonableClassCustom tempClon = (ClonableClassCustom) super.clone();   // return super.clone(); - вызывает базовую реализацию
            tempClon.time++;
            return tempClon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "ClonableClassCustom{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}
