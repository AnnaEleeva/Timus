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
