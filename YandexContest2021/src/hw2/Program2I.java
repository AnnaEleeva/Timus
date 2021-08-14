//
//Вам необходимо построить поле для игры "Сапер" по его конфигурации – размерам и координатам расставленных на нем мин.
//
//        Вкратце напомним правила построения поля для игры "Сапер":
//
//        Поле состоит из клеток с минами и пустых клеток
//        Клетки с миной обозначаются символом *
//        Пустые клетки содержат число ki,j, 0≤ ki, j ≤ 8 – количество мин на соседних клетках. Соседними клетками являются восемь клеток, имеющих смежный угол или сторону.
//        Формат ввода
//        В первой строке содержатся три числа: N, 1 ≤ N ≤ 100 - количество строк на поле, M, 1 ≤ M ≤ 100 - количество столбцов на поле, K, 0 ≤ K ≤ N ⋅ M - количество мин на поле.
//
//        В следующих K строках содержатся по два числа с координатами мин: p, 1 ≤ p ≤ N - номер строки мины, q, 1 ≤ 1 ≤ M - номер столбца мины.
//
//        Формат вывода
//        Выведите построенное поле, разделяя строки поля переводом строки, а столбцы - пробелом.

package hw2;

import java.util.Arrays;
import java.util.Scanner;

public class Program2I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strNumbers=scanner.nextLine();

        //сформируем ArrayList из строки чисел
        String [] strings =strNumbers.split(" ");

        int[] arrayNumbers = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int countRows=arrayNumbers[0];
        int countColumns=arrayNumbers[1];
        int countBombs=arrayNumbers[2];

        //заполняем матрицу нулями
        int[][]matrix=new int[countRows][countColumns];
         for(int i=0;i<countRows;i++){
             for(int j=0;j<countColumns;j++){
                 matrix[i][j]=0;
             }
         }


        while (countBombs>0){
            countBombs--;
            String strCoordinates=scanner.nextLine();
            String [] strArrCoordinates =strCoordinates.split(" ");
            int[] arrayCoordinates = Arrays.stream(strArrCoordinates).mapToInt(Integer::parseInt).toArray();
            int i=arrayCoordinates[0]-1;
            int j=arrayCoordinates[1]-1;


            try{
                matrix[i-1][j-1]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i-1][j]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i-1][j+1]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i][j-1]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i][j]=-9;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i][j+1]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i+1][j-1]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i+1][j]++;
            } catch (IndexOutOfBoundsException ignored){}
            try{
                matrix[i+1][j+1]++;
            } catch (IndexOutOfBoundsException ignored){}


        }
        printMatrix(matrix,countRows,countColumns);



    }
    public static void printMatrix(int[][] matrix,int countRows, int countColumns){
        for(int i=0;i<countRows;i++){
            for(int j=0;j<countColumns;j++){
                if(matrix[i][j]<0){
                    System.out.print("* ");
                }
                else System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
