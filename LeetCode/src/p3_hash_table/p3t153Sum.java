package p3_hash_table;
//не доделана - находит не все
import java.util.*;

public class p3t153Sum {
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> res= threeSum(arr);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<List<Integer>> list2=new ArrayList<>();
        HashSet<Integer> tripletsMulti=new HashSet<>();
int counter=0;
        for (int i=0;i<nums.length;i++){
            int[] res=twoSum(nums,-1*nums[i],i);
            if(res==null) continue;
            list2.add(Arrays.asList(i,res[0],res[1]));

               List<Integer> tempL=Arrays.asList(nums[i],nums[res[0]],nums[res[1]]);

               Collections.sort(tempL);
               boolean wasTriplet=false;
               for(List<Integer> e: list){
                   if(e.equals(tempL)){
                       wasTriplet=true;
                       break;
                   }
               }
              if(!wasTriplet) list.add(tempL);

            } ;

        return list;
    }
    public static int[] twoSum(int[] nums, int target, int xIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(i==xIndex)continue;
            int complement = target - nums[i]; //0 - 3 =-3
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i); //для хранения разницы, среди которой может быть нужноe число target-x=y
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
