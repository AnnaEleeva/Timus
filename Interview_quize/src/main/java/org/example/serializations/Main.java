package org.example.serializations;

import java.io.IOException;
import java.time.LocalDate;

import static org.example.serializations.User.deserialize;
import static org.example.serializations.User.serialize;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String path = "Interview_quize/src/main/java/org/example/serializations/serializedUser.ser";

        //создаем наш объект
        User user = new User();
        user.setFirstName("Stefan");
        user.setLastName("Smith");
        user.setEmail("ssmith@email.com");
        user.setBirthDate(LocalDate.of(1991, 7, 16));
        user.setLogin("ssmith");
        user.setPassword("gemma_arterton_4ever_in_my_heart91");

        System.out.println("Initial user: " + user + "\r\n");
        serialize(user, path);

        User loadedUser = deserialize(path);
        System.out.println("Loaded user from file: " + loadedUser + "\r\n");
    }
}
