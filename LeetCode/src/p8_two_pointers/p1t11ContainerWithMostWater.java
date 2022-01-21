package p8_two_pointers;
/*
не понимаю почему эта даунская задача в разделе Два указателя. Она простая была, но необычная
В классических двух указателях сравниваются значения указателей, а тут просто ползем.

O(n)

* */
public class p1t11ContainerWithMostWater {
    public static void main(String[] args) {
        int[] testArr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int x = maxArea(testArr);
        System.out.println("answer = " + x);
    }

    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int width;

        int max = Integer.MIN_VALUE;
        int nowArea = 0;

        while (leftIndex < rightIndex) {
            width = rightIndex - leftIndex;
            //какая граница ниже - такой и уровень воды
            if (height[leftIndex] > height[rightIndex]) {
                nowArea = height[rightIndex] * width;
                rightIndex--;
            } else {
                nowArea = height[leftIndex] * width;
                leftIndex++;
            }

            if (nowArea > max) max = nowArea;

            System.out.println("m= "+max);


        }

        return max;
    }

}
