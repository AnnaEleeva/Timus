//Геном жителей системы Тау Кита содержит 26 видов оснований, для обозначения которых будем использовать буквы латинского алфавита от A до Z, а сам геном записывается строкой из латинских букв. Важную роль в геноме играют пары соседних оснований, например, в геноме «ABBACAB» можно выделить следующие пары оснований: AB, BB, BA, AC, CA, AB.
//
//        Степенью близости одного генома другому геному называется количество пар соседних оснований первого генома, которые встречаются во втором геноме.
//
//        Вам даны два генома, определите степень близости первого генома второму геному. Программа получает на вход две строки, состоящие из заглавных латинских букв. Каждая строка непустая, и её длина не превосходит 105.
//
//        Программа должна вывести одно целое число – степень близости генома, записанного в первой строке, геному, записанному во второй строке.
//
//        Пример:
//
//        ABBACAB
//        BCABB
//
//        Вывод: 4 // Следующие пары оснований первого генома встречаются во втором геноме: AB, BB, CA, AB. Обратите внимание на то, что пара AB в первом геноме встречается два раза, поэтому и подсчитана в ответе два раза.
//
//        Система оценивания:
//
//        Решение, правильно работающее только для случаев, когда длины данных строк не превосходят 100, будет оцениваться в 60 баллов.

package hw3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Program3F {
   static int[][] matrix1=new int[26][26];
   static int[][] matrix2=new int[26][26];
   static String alphabetStr="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {


//        String alphabetStr="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String[] alphabet=new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
//        char[] alphabetCh=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};



        Scanner scanner = new Scanner(System.in);

        String gen1=scanner.nextLine();
        String gen2=scanner.nextLine();

        getMatrix(gen1,matrix1);
        getMatrix(gen2,matrix2);

        int countCommonGenes=0;

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if((matrix1[i][j]!=0)&&(matrix2[i][j]!=0)){
                    countCommonGenes+=matrix1[i][j];
                }
            }
        }

        System.out.println(countCommonGenes);


    }


    //матрицы для геномов ([0][0]-АA, [0][1]-AB,10-BA....[25][25]-ZZ), если такой геном есть, то в матрице увеличиваем счетчик ячейки
    public static void getMatrix(String gen, int[][]matrix){

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                matrix[i][j]=0;
            }
        }

        //идем по гену 1 и записываем в матрицу 1
        char previousLetter=gen.charAt(0);
        int indexPreviousLetter=alphabetStr.indexOf(previousLetter);
        for(int i=1;i<gen.length();i++){
            char letter=gen.charAt(i);


            int indexLetter= alphabetStr.indexOf(letter);

            matrix[indexPreviousLetter][indexLetter]++;

            indexPreviousLetter=indexLetter;
        }

    }
}
