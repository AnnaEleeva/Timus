package org.example.interface_markers;

import java.util.ArrayList;
import java.util.Arrays;

public class MainForClone {
    public static void main(String[] args) {
        ClonableClassBase clonableClass = new ClonableClassBase("Anna", 13);
        ClonableClassBase clon1 = clonableClass.clone();
        System.out.println(clon1);


//        При вызове метода clone(), Java проверяет, был ли у объекта интерфейс Cloneable.
//        Если да — клонирует объект методом clone(), если нет — выкидывает исключение CloneNotSupportedException.
//        NotClonableClass notClonableClass = new NotClonableClass("Jovan", 14);
//        System.out.println(notClonableClass.clone());


        ClonableClassCustom clon2 = new ClonableClassCustom("Bob", 13);
        for (int i = 0; i < 10; i++) {
            System.out.println(clon2 = clon2.clone());
        }

//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=14}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=15}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=16}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=17}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=18}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=19}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=20}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=21}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=22}
//        ClonableClassCustom{name='Bob', description='I can be cloned custom!', time=23}


        ClonableClassCustomDeep clonDeep = new ClonableClassCustomDeep("Cavin", 14, new Book("WorldAndWar", "LeoTolstoy", Arrays.asList(2,4,5)));
        ClonableClassCustomDeep clonDeep2 = clonDeep.clone();
        System.out.println(clonDeep2); // ClonableClassCustom{name='Cavin', description='I can be cloned custom!', time=15, book=Book{name='WorldAndWar', author='LeoTolstoy', prices=[2, 4, 5]}}

        // меняем данные только в первом объекте
        clonDeep.book.setAuthor("Newton");  // это изменится и во втором объекте, тк ссылка общая на поле Book - надо реализовывать через глубокое клонирование!
        clonDeep.name = "Miranda"; // это изменится только у первого объекта

        System.out.println(clonDeep); // ClonableClassCustom{name='Miranda', description='I can be cloned custom!', time=14, book=Book{name='WorldAndWar', author='Newton', prices=[2, 4, 5]}}
        System.out.println(clonDeep2); // ClonableClassCustom{name='Cavin', description='I can be cloned custom!', time=15, book=Book{name='WorldAndWar', author='Newton', prices=[2, 4, 5]}}


    }
}
