package org.example.enums;

public class MainForEnum {
    public static void main(String[] args) {
        System.out.println(DayOfWeek.FRIDAY == DayOfWeek.MONDAY); //false
        // System.out.println(DayOfWeek.FRIDAY == "FRIDAY");  // - нельзя сравнить через == String и Enum
        System.out.println(DayOfWeek.FRIDAY.equals("FRIDAY")); //false
        System.out.println(DayOfWeek.FRIDAY.toString() == "FRIDAY"); //true
        System.out.println(DayOfWeek.FRIDAY.name() == "FRIDAY"); //true
        System.out.println(DayOfWeek.FRIDAY.name().equals("FRIDAY")); //true
    }
}
