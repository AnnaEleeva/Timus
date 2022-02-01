package p3_hash_table;

import java.util.Arrays;
import java.util.LinkedList;

public class p2t1TwoSum {
    public static void main(String[] args) {
        int[] arr={7,2,11,15};
        int[] arr2={3,3};
        for(int e:twoSum(arr2,6)){
            System.out.print(e+" ");
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] s=Arrays.copyOf(nums,nums.length);
        LinkedList<Integer> res=new LinkedList<>();
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;

        while (l<r){
            if(nums[l]+nums[r]>target){
                r--;
            }
            if(nums[l]+nums[r]<target){
                l++;
            }
            if(nums[l]+nums[r]==target) {
                for(int i=0;i<s.length;i++){
                    if(s[i]==nums[l]||s[i]==nums[r]) res.add(i);

                }
                break;
            }
        }

        int [] resArr=new int[2];
        resArr[0]=res.get(0);
        resArr[1]=res.get(1);



        return resArr;
    }


    // более оптимальное решение за O(n)
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];   //надо было догадаться
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        // In case there is no solution, we'll just return null
//        return null;
//    }
}
