/*
Задача: Найти самый часто встречающийся символ в строке
Сложность алгоритма O(n+k)=O(n)
* */
package lessons.lesson1;
import java.util.*;

public class Task1v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        HashMap<Character, Integer> dct = new HashMap<>();

        Character ans = ' ';
        int anscnt = 0;
        for (int j = 0; j < s.length(); j++) {
            Character now = s.charAt(j);
            if (!dct.containsKey(now)) {
                dct.put(now, 0);
            }
            dct.put(now, dct.get(now) + 1);
        }
        for(Character key:dct.keySet()){
            if(dct.get(key)>anscnt){
                anscnt=dct.get(key);
                ans=key;
            }
        }
        System.out.println(ans);
    }
}
