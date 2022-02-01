package p7_heap_hash;

import java.util.*;
import java.util.stream.Collectors;

public class p2t347TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums={5,5,4,4,4,4,4,1,1,1,2,2,3,3,3,3,3,3};
        for(Integer e:topKFrequent(nums,2)){
            System.out.println(e);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int e:nums){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }else{
                map.put(e,1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        //ArrayList<Integer> res=new ArrayList<>();
        int []res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i).getKey();
        }
        return res;
    }
}
