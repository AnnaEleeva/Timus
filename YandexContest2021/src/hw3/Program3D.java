//Во входном файле (вы можете читать данные из sys.stdin, подключив библиотеку sys) записан текст. Словом считается последовательность непробельных символов идущих подряд, слова разделены одним или большим числом пробелов или символами конца строки. Определите, сколько различных слов содержится в этом тексте.
//
//        Формат ввода
//        Вводится текст.
//
//        Формат вывода
//        Выведите ответ на задачу.
// смотри Program3D_Example
package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListSet;

public class Program3D {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path).useDelimiter("\\s+");
        ConcurrentSkipListSet<String> hashSet=new ConcurrentSkipListSet<>();
        while (scanner.hasNext()){

            hashSet.add(scanner.next());
        }
        System.out.println(hashSet.size());
    }
}
