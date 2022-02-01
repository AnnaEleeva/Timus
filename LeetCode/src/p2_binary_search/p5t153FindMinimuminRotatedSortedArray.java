package p2_binary_search;
//это решение за O(n) - ищем точку поворота не бинпоиском
import java.util.Arrays;

public class p5t153FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7};
        System.out.println(findMin(a));
    }

    public static int findMin(int[] nums) {

        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            //если нашли точку поворота
            if (nums[i] > nums[i + 1]) {
                if (nums[i + 1] < min) return nums[i + 1];
                else return min;
            }
        }
        return min;
    }
}
