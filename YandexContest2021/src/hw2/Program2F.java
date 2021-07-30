package hw2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Program2F {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\user\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw2\\input.txt";
        int tailLength=makeSimmetric(fileName);
        System.out.println(tailLength);


    }
    //делает лист симметричным, возвращая необходимое число элементов для симметричности
    public static int makeSimmetric(String fileName) throws IOException {
        int tailLength=0;

        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        ArrayList <Integer> inputList =new ArrayList<>();
        ArrayList <Integer> listToSimmetric =new ArrayList<>();

        //запишем последовательность в массив
        while(scanner.hasNextInt()){
            int x = scanner.nextInt();
            inputList.add(x);
            listToSimmetric.add(x);
        }
        for(tailLength=0;tailLength<inputList.size();tailLength++){
            if(isSimmetric(listToSimmetric)){
                break;
            }
            listToSimmetric.add(inputList.get(tailLength));
        }
        return tailLength;
    }
    //проверяет симметричны ли элементы листе
    public static boolean isSimmetric(ArrayList <Integer>  listToSimmetric){
        if(listToSimmetric.size()%2==0){//четн

        }
        for(int i=0;i<listToSimmetric.size()/2;i++){ //идем до середины
            if(listToSimmetric.get(i)!=listToSimmetric.get(listToSimmetric.size()-i-1)){
                return false;
            }
        }
        return true;
    }

}

