package p11_greedy_problems;

public class p2t122BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4,0};
        int[] prices2={7,6,4,3,1};
        int[] prices3={1,2};
        int[] prices4={3,2,6,5,0,3};
        System.out.println(maxProfit(prices4));
    }
    //суммируем подъемы просто!
    public static int maxProfit(int[] prices) {
        int profit=0;
       for(int i=1;i<prices.length;i++){
           if(prices[i]>prices[i-1]){
               profit+=prices[i]-prices[i-1];
           }
       }
       return profit;
    }
}
