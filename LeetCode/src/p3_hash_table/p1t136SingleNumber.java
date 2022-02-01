package p3_hash_table;

public class p1t136SingleNumber {
    public static void main(String[] args) {
            int [] nums={4,1,2,1,2,6,4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        for(int num : nums)
            a ^= num;
        return a;
    }
}
