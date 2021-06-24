/*
Задача: Найти самый часто встречающийся символ в строке
Сложность алгоритма O(nk)
* */
package lessons.lesson1;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Task1v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        Set<Character> charsSet = s.chars().mapToObj(e->(char)e).collect(Collectors.toSet()); //создаем из строки set<char>

        Character ans=' ';
        int anscnt=0;
        for(Character now : charsSet ){
            int nowcnt=0;
            for(int j=0;j<s.length();j++){
                if(now==s.charAt(j)) nowcnt++;
            }
            if(nowcnt>anscnt){
                anscnt=nowcnt;
                ans=now;
            }
        }
        System.out.println(ans);
    }
}
