package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeMap;

public class Program4F {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4F_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        TreeMap<String, TreeMap<String,Long>> treeMap=new TreeMap<>();

        while (scanner.hasNext()){
            String[] noteStr=scanner.nextLine().split(" ");
           long count= Integer.parseInt(noteStr[2]);
           String surname=noteStr[0];
           String product=noteStr[1];

           //если человек с такой фамилией есть
           if(treeMap.containsKey(surname)){
               //если продукт у человека есть такой
               if(treeMap.get(surname).containsKey(product)){

                   long oldCount=treeMap.get(surname).get(product);
                   //внутренняя карта   продукт - кол-во
                   TreeMap<String, Long> oldData=treeMap.get(surname);
                   //меняем старую внутреннюю карту -  увеличив кол-во
                   oldData.put(product,oldCount+count);
                   //добавляем в основную карту
                   treeMap.put(surname,oldData);
               }
               else{
                   //получаем другие продукты (внутреннюю карту)
                   TreeMap<String, Long> data=treeMap.get(surname);
                   //заполняем
                   data.put(product,count);
                   //добавляем к другим продуктам
                   treeMap.put(surname,data);
               }


           }
            //если человека с такой фамилией нет
            else {
               //создаем внутреннюю карту продукт - кол-во
               TreeMap<String, Long> data=new TreeMap<>();
               //заполняем
               data.put(product,count);
               //добавляем
               treeMap.put(surname,data);
           }


        }

        //идем по фамилиям
        for(String e:treeMap.keySet()){
            System.out.print(e);
            System.out.println(":");
            //идем по продуктам
            for(String prod:treeMap.get(e).keySet()){
                System.out.print(prod);
                System.out.print(" ");
                System.out.println(treeMap.get(e).get(prod));
            }
        }
    }
}
