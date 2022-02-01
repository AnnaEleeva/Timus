package p2_binary_search;

public class p5t153FindMinimuminRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7,0,1,2};
        int[] b = {3,1,2};
        System.out.println(findMin(b));
    }
    public static int findMin(int[] nums) {

        int min = nums[0];
        //если нет поворота
        if (nums.length==1 ||nums[0] < nums[nums.length - 1]) return min;

        //ищем точку поворота
        int point = lbinsearch2(nums, nums[nums.length - 1]);
        if (nums[point] > nums[point + 1]) point = point + 1; //начало второй последовательности, а не конец первой

        return nums[point];

    }
    public static int lbinsearch2(int[] arr, int t) {

        int l = 0;
        int r = arr.length-1;
        int m;
        //if(t<l||t>r);
        while ((l < r)) {
            m = (l + r) / 2;
            if (m != arr.length - 1 && arr[m] > arr[m + 1]) return m;
            if (m != 0 && arr[m - 1] > arr[m]) return m;


            if (arr[m] < t) {   //t - крайний правый элемент
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
