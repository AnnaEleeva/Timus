package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class Program3I {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3I_test";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        //добавляем все языки в этот сет, чтобы ответить, какие языки знает хотябы один студент
        HashSet<String> allLangsSet=new HashSet<>();
        //будем искать пересечение всех студентов со всеми, чтоб понять какие языки знают все
        HashSet<String> intersectionEveryStudentSet = new HashSet<>();



        int countStudents= Integer.parseInt(scanner.nextLine());

        for(int i=0;i<countStudents;i++){
            int countLang= Integer.parseInt(scanner.nextLine());
            HashSet<String> tempStudentLangsSet=new HashSet<>();
            for(int l=0;l<countLang;l++){
                String lang=scanner.nextLine();
                allLangsSet.add(lang);

                //заполняем сет текущего студента
                tempStudentLangsSet.add(lang);
            }
            //для первого студента пересечение не считаем
            if(i==0){
                intersectionEveryStudentSet.addAll(tempStudentLangsSet);
            }else{
                intersectionEveryStudentSet.retainAll(tempStudentLangsSet);
            }

        }

        //языки которые знают все школьники
        System.out.println(intersectionEveryStudentSet.size());
        for (String e:intersectionEveryStudentSet){
            System.out.println(e);
        }
        //языки которые знает хотябы один
        System.out.println(allLangsSet.size());
        for (String e:allLangsSet){
            System.out.println(e);
        }



    }
}
