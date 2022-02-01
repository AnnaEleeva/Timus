package p2_binary_search;

public class p1t704BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,4,6,7};
        int target=6;
        int indexTarget=search(arr,target);
        System.out.println(indexTarget);

    }
    public static int search(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        int m;
        if(target<nums[l]||target>nums[r-1])return -1;

        while (l<r){
            m=(l+r)/2;
            if(nums[m]>target){
                r=m;
            }else{
                l=m+1;
            }
        }
        if(nums[l-1]==target){return l-1;}
        else return -1;

    }
}
