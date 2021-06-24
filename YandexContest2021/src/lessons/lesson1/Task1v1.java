/*
Задача: Найти самый часто встречающийся символ в строке
Сложность алгоритма O(n^2)
* */
package lessons.lesson1;
import java.util.Scanner;

public class Task1v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        Character ans=' ';
        int anscnt=0;
        for(int i=0; i<s.length();i++){
            int nowcnt=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)) nowcnt++;
            }
            if(nowcnt>anscnt){
                anscnt=nowcnt;
                ans=s.charAt(i);
            }
        }
        System.out.println(ans);
    }
}
