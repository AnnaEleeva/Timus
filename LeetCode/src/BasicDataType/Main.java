package BasicDataType;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int x=3;
        Integer X=3;

        Number numberX=3;

        Object objectX=3;

        System.out.println(X.getClass());
        Class<?> classX=X.getClass();
        ArrayList<Integer> [] arr=new ArrayList[3];//массив листов
        arr[0]=new ArrayList<>();

        char ch=3;//1234 1234 1234 1234
        char ch2=65;
        System.out.println(ch2);

        List<Integer> [] arr2=null;


        Object oo=new int[3];
       // Array d=Array.newInstance(Integer.,3);
        int[] i=new int[2];
        i.clone();

        String s=new String("ab34");

        Boolean b;

        Character c;
        HashMap<StringBuilder,Double> map;
        StringBuffer dd;

        Dictionary dictionary;


    }
}
