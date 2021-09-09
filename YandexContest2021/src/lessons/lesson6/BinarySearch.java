package lessons.lesson6;

public class BinarySearch {
    public static void main(String[] args) {
        int[]sortedArray=new int[]{2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37};

       int result= binarySearch(sortedArray,26);
       System.out.println("index element's equals 22: "+result);

       int result2=lbinsearch(0,sortedArray.length-1,sortedArray,10);
        System.out.println("res2: "+result2);


    }
    public static int binarySearch(int []array,int x){
        int l=0;
        int r=array.length-1;
        int m;
        while (l<r){
            m= (l + r) / 2;
            if (array[m] >= x) //проверяем все хорошо или все плохо
            {
                r = m;
               // System.out.println("r " + r);
            } else {
                l = m + 1;
               // System.out.println("l " + l);
            }
        }

        if(array[l]==x) System.out.println("YES");
        else System.out.println("NO");
        return l;

    }
    public static int lbinsearch(int l,int r,int[]array,int x){
        int m;
        while (l<r){
            m= (l + r) / 2;
            if(check(m,array,x))
                r=m;
            else
                l=m+1;
        }
        return l;
    }
    public static boolean check(int m,int[]array,int x){
        return(array[m]>=x);
    }

}
