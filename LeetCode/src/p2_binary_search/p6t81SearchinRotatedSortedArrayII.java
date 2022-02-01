package p2_binary_search;
//не решено (из-за повторов сложность будет O(n))
import java.util.Arrays;

public class p6t81SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] a = {4,5,6,1,2,2,2};
        int[] b = {1,0,1,1,1};
        int[] c= {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(c, 2));
    }

    public static boolean search(int[] nums, int target) {
        int res = -1;
        if(nums.length==1){
            if (nums[0]==target) return true;
            else return false;
        }
        //если нет поворота
        if (nums[0] < nums[nums.length - 1]) {
            res=lbinsearch(nums, target);
        } else { //если поворот есть
            //ищем точку поворота
            int point = lbinsearch2(nums, nums[nums.length - 1]);
            if (nums.length>1 && nums[point] > nums[point + 1]) point = point + 1; //начало второй последовательности, а не конец первой

            //если target во второй половине
            if (target >= nums[point] && target <= nums[nums.length - 1])
                res = point+lbinsearch(Arrays.copyOfRange(nums, point, nums.length), target);
            else res = lbinsearch(Arrays.copyOfRange(nums, 0, point), target);

            //     System.out.println();
        }
        if (res != -1 && nums[res] == target) return true;
        else return false;

    }

    public static int lbinsearch(int[] arr, int t) {

        int l = 0;
        int r = arr.length-1;
        int m;
        //if(t<l||t>r);
        while ((l < r)) {
            m = (l + r) / 2;
            if (arr[m] >= t) {   //t - крайний правый элемент
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
    //ищем точку поворота
    public static int lbinsearch2(int[] arr, int t) {

        int l = 0;
        int r = arr.length-1;
        int m;
        //if(t<l||t>r);
        while ((l < r)) {
            m = (l + r) / 2;
            if (m != arr.length - 1 && arr[m] > arr[m + 1]) return m;
            if (m != 0 && arr[m - 1] > arr[m]) return m;

            if (arr[m] <= t) {   //t - крайний правый элемент
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
