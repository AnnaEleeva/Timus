package p11_greedy_problems;

public class p1t121BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4,0};
        int[] prices2={7,6,4,3,1};
        int[] prices3={1,2};
        int[] prices4={3,2,6,5,0,3};
        System.out.println(maxProfit(prices4));
    }
    public static int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit=0;

        int tmpProf=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                tmpProf=0;
                continue;
            }
            if(prices[i]-min>tmpProf){
                tmpProf=prices[i]-min;
                if(tmpProf>profit)profit=tmpProf;
            }
        }
        return profit;
    }
}
