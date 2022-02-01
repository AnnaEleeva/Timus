package p7_heap_hash;

import java.util.*;
import java.util.stream.Collectors;

public class p1t692TopKFrequentWords {
    public static void main(String[] args) {
        String[] words={"i","love","leetcode","i","love","coding"};
        String[] words2={"the","day","is","sunny","the","the","the","sunny","is","is"};

        for(String e:topKFrequent(words2,4)){
            System.out.println(e);
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        TreeMap<String,Integer> map=new TreeMap<>();
        for(String e:words){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }else{
                map.put(e,1);
            }
        }

        List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        ArrayList<String> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
