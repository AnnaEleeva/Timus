package p2_binary_search;

public class p2t374GuessNumberHigherorLower {
    public static void main(String[] args) {

    }
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while(l<=r){
            //int mid = low + (high - low) / 2;
            int  m=(l+r)/2;
           // int  res =guess(m);
            int  res=0;
            if(res==0){
                return m;
            }
            if(res<0){
                r=m;
            }
            else{
                l=m+1;
            }
        }
        return  -1;


    }
}
