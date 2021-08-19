package JavaDeveloper;


import java.io.IOException;
import java.util.TreeSet;

public class Program3 {
    public static void main(String[] args) throws IOException {

        TreeSet<Integer> nums=new TreeSet<>();

        int three=-1;
        int two=-1;
        int one=-1;
        int x;
        while((x = System.in.read()) > ' ') {
            //System.out.println(Character.getNumericValue(one));
            three=two;
            two=one;
            one=x;
        }

        if(one==42){
            System.out.println(1);
            return;
        }
        one=Character.getNumericValue(one);
       // System.out.println("one " +one);

        nums.add(1);
        if(one%2==0) nums.add(2);
        if((one==0)||(one==5)) {
            nums.add(5);
            nums.add(10);
        }

        if(two==42){
            for(int e: nums){
                System.out.print(e+" ");
            }
            return;
        }
        two=Character.getNumericValue(two);
       // System.out.println("two "+two);

        if((two*10+one)%4==0) nums.add(4);

        if(three==42){
            for(int e: nums){
                System.out.print(e+" ");
            }
            return;
        }
        three=Character.getNumericValue(three);
        //System.out.println("three "+three);

        if((three*100+two*10+one)%8==0) nums.add(8);

        for(int e: nums){
            System.out.print(e+" ");
        }

    }
}
