package hw3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Program3A {
    HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    //ArrayList<Integer>list=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw2\\input.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        int i=0;
      //  Set<Integer> set=new HashSet<>(1);
        Program3A myset=new Program3A();
        while (scanner.hasNextInt()){
            int x=scanner.nextInt();

           // if(!set.contains(x))
                //set.add(scanner.nextInt());
            if(!myset.contains(x)){
                myset.add(x);
                i++;
            }

        }
        System.out.println("map "+myset.map.size());

        System.out.println(i);
    }
        public void add(Integer e){
        ArrayList<Integer> list2=new ArrayList<>();

        //если по индексу что-то уже есть
        if(map.get(e%10)!=null){
              list2=map.get(e%10);
        }

        list2.add(e);
        map.put(e%10,list2);
    }

    public boolean contains(Integer e){
        
        ArrayList<Integer>  list=new ArrayList<>();
        if(map.get(e%10)!=null)
            list=map.get(e%10);
        if(list.size()==0) return false;

        for(int x: list){
            if(x==e)
                return true;
        }
        return false;
    }
}
