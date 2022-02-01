package p2_binary_search;
//это решение за O(n) - ищем точку поворота не бинпоиском
import java.util.ArrayList;
import java.util.Arrays;

public class p4t33SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int[] b = {1,3};
        System.out.println(search(a, 3));
    }

    public static int search(int[] nums, int target) {

        int targetIndex=-1;
        boolean wasTurn=false;
        for (int i = 0; i < nums.length - 1; i++) {

            //если нашли точку поворота
            if (nums[i] > nums[i + 1]) {
                wasTurn=true;
                //если входит
                if (nums[0] <= target && target <= nums[i]) {
                    targetIndex = lbinsearch(Arrays.copyOfRange(nums, 0, i), target);
                } else targetIndex = i+1+lbinsearch(Arrays.copyOfRange(nums, i + 1, nums.length), target);
            }
        }
        if(!wasTurn&&nums.length!=1) {
            if (nums[0] <= target && target <= nums[nums.length-1]) {
                targetIndex = lbinsearch(Arrays.copyOfRange(nums, 0, nums.length), target);
            }else return -1;
        }else if(nums.length==1){
            targetIndex=0;
        }
        if(targetIndex==-1)return targetIndex;

        if(targetIndex<nums.length&&nums[targetIndex]==target) return targetIndex;
        else return -1;
    }

    public static int lbinsearch(int[] arr, int t) {

        int l = 0;
        int r = arr.length;
        int m;
        //if(t<l||t>r);
        while ((l < r)) {
            m = (l + r) / 2;
            if (arr[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
