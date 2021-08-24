//Расшифровка письменностей Майя

//можно оптимизировать, isMapsEquals - в худшем случае О(26(строчных)+26(прописных))
//можно возвращать сколько букв совпадает, и при удалении (первой букы)oldChar сверять сколько теперь совпадает
//и при добавлении новой буквы chNow сверять сколько теперь совпадает букв
//если кол-во совпавших = кол-ву букв в слове, то result++
//O(2) будет
package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Program4H {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Task2_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int result=0;
        //c 1
        //a 1
        //t 1
        HashMap<Character,Integer> normalWord=new HashMap<>();
        HashMap<Character,Integer> wordFromS=new HashMap<>();


       int countCharInWord= scanner.nextInt();
       int countCharInS= scanner.nextInt();


        //делаем карту символов слова O(word.len)
        String s=scanner.next();
        for(int i=0;i<countCharInWord;i++){
            char ch=s.charAt(i);
            if(normalWord.containsKey(ch)){
                normalWord.put(ch,normalWord.get(ch)+1);
            }else{ //если клиента в базе нет
                normalWord.put(ch,1);
            }
        }

        String s2=scanner.next();
        //заполняем карту для первых N символов последовательности. N = длине слова
        Character oldChar=null;
        if(wordFromS.isEmpty()){

            for(int j=0;j<countCharInWord;j++){
                char chNow=s2.charAt(j);

                if(wordFromS.containsKey(chNow)){
                    wordFromS.put(chNow,wordFromS.get(chNow)+1);
                }
                else{
                    wordFromS.put(chNow,1);
                }

                if(j==0) oldChar=chNow;
            }
            //если карты и их значения совпадают
            if(isMapsEquals(normalWord,wordFromS)){
                result++;
            }
        }

        //идем по последовательности
       for(int i=countCharInWord;i<countCharInS;i++){
           char chNow=s2.charAt(i);
           //удаляем крайний левый символ(идем посимвольно, берем по длине слова кол-во символов)
             if( wordFromS.get(oldChar)>1){
                 wordFromS.put(oldChar,wordFromS.get(oldChar)-1);
             }else{
                 wordFromS.remove(oldChar);

             }
            //добавляем следующий
           if(wordFromS.containsKey(chNow)){
               wordFromS.put(chNow,wordFromS.get(chNow)+1);
           }
           else{
               wordFromS.put(chNow,1);
           }
         //  wordFromS.put(scanner.next().charAt(i),1);
            oldChar=s2.charAt(i-countCharInWord+1);

           //если карты и их значения совпадают
           if(isMapsEquals(normalWord,wordFromS)){
               result++;
           }
       }
        System.out.println(result);


    }
    public static boolean isMapsEquals(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
       if(!map1.keySet().equals(map2.keySet())){
          return false;
       }
        for(Character e: map1.keySet()){
            if(map1.get(e)!=map2.get(e)){
              return false;
            }
        }
        return true;
    }
}
