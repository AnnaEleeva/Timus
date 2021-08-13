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
