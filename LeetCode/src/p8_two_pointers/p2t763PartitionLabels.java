package p8_two_pointers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class p2t763PartitionLabels {
    public static void main(String[] args) {
        //String s= "ababcbacadefegdehijhklij";
        String s= "caedbdedda";
        List<Integer> res=p2t763PartitionLabels.partitionLabels(s);
        for(Integer e:res){
            System.out.println(e);
        }
    }
    public static List<Integer> partitionLabels(String s) {

        HashMap<Character,Integer> lastIndexOfLetter = new HashMap<>();
        HashMap<Character,Boolean> haveClones=new HashMap<>(); //чтобы отследить одинокие буквы, которые не повторяются - из них сразу партия
        List<Integer> result=new LinkedList<>();

        for(int i=s.length()-1;i>=0;i--){
            Integer x=lastIndexOfLetter.get(s.charAt(i));
            if(lastIndexOfLetter.get(s.charAt(i))==null){
                lastIndexOfLetter.put(s.charAt(i),i);
                haveClones.put(s.charAt(i),false);
            }else{
                haveClones.put(s.charAt(i),true);
            }
        }

        int indexLastOfPart=Integer.MIN_VALUE;
        //int indexNowLetter=0;

        int lastIndexNowLetter;//i - указатель на  индекс последнего элемента в партии

        int partStartIndex=0; //нужен чтобы узнать потом длину партии


        for (int i=0;i<s.length();i++){ //i - указатель на текущий индекс элемента

            //из одиночек сразу делаем одноэлементную партию
            if(!haveClones.get(s.charAt(i))&&(partStartIndex==i)){
                result.add(1); //кол-во элементов в партии
                partStartIndex = i + 1;
                continue;

            }

            //смотрим какой у текущего символа последний индекс
            lastIndexNowLetter = lastIndexOfLetter.get(s.charAt(i));
            //если дошли до конца партии то запишем в результат партию и обновим указатель на стартовый индекс
            if (i == indexLastOfPart) {
                result.add(i - partStartIndex + 1);
                partStartIndex = i + 1;
            }

            if (lastIndexNowLetter > indexLastOfPart) { //указатель нужно сдвинуть, если внутренние символы партии имеют более далекий индекс(не внутри предполагаемого отрезка)
                indexLastOfPart = lastIndexNowLetter; //сдвигаем указатель на  индекс последнего элемента в партии
            }

        }

        return result;
    }
}
