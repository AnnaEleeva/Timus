package lessons.lesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static lessons.lesson1.Task2.findMax;

class Task2Tests {

    int [] arr1;

    @Test
    void test1() {
        arr1= new int[]{1, 3, 2};
        String result="3";
        Assert.assertEquals(result,findMax(arr1));
    }

    @Test
    void test2() {
        arr1= new int[]{1, 2, 3};
        String result="3";
        Assert.assertEquals(result,findMax(arr1));
    }


    @Test
    void test3() {
        arr1= new int[]{3, 2, 1};
        String result="3";
        Assert.assertEquals(result,findMax(arr1));
    }

    @Test
    void test4() {
        arr1= new int[]{1, 1, 1};
        String result="1";
        Assert.assertEquals(result,findMax(arr1));
    }

    @Test
    void test5() {
        arr1= new int[]{1};
        String result="1";
        Assert.assertEquals(result,findMax(arr1));
    }

    @Test
    void test6() {
        arr1= new int[]{};
        String result="Infinity";
        Assert.assertEquals(result,findMax(arr1));
    }

    @Test
    void test7() {
        arr1= new int[]{-2,-1,-3};
        String result="-1";
        Assert.assertEquals(result,findMax(arr1));
    }




}