package org.example.interface_markers;

public class ClonableClassCustomDeep implements Cloneable{

    String name;
    String description = "I can be cloned custom!";
    int time;
    Book book;

    public ClonableClassCustomDeep(String name, int time, Book book) {
        this.name = name;
        this.time = time;
        this.book = book;
    }

    @Override
    public ClonableClassCustomDeep clone() {
        try {
            ClonableClassCustomDeep tempClon = (ClonableClassCustomDeep) super.clone();   // return super.clone(); - вызывает базовую реализацию
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
                ", book=" + book.toString() +
                '}';
    }
}
