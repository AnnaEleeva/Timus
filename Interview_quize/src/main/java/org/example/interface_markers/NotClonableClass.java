package org.example.interface_markers;

public class NotClonableClass {
    String name;
    String description = "I can't be cloned :(";
    int time;

    public NotClonableClass(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
