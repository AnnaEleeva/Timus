package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Program3C {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw3\\input3C.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path).useDelimiter("\\s+");
        //Set<Person> persons = Collections.newSetFromMap(new IdentityHashMap<>())
        TreeSet<String> hashSet= new TreeSet<>();
        while (scanner.hasNext()){

            hashSet.add(scanner.next());
        }
        System.out.println(hashSet.size());
        hashSet.clear();
    }
}
