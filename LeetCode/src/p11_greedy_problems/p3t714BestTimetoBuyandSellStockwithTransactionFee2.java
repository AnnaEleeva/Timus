package p11_greedy_problems;

public class p3t714BestTimetoBuyandSellStockwithTransactionFee2 {

    public static void main(String[] args) {
        int[] prices={1,3,2,8,4,9};
        int[] prices2={1,3,7,5,10,3};
        int[] prices3={1,4,6,2,8,3,10,14};
        System.out.println(maxProfit(prices3,3));
    }
    public static int maxProfit(int[] prices,int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); //продаем
            hold = Math.max(hold, cash - prices[i]);//держим
        }
        return cash;
    }
}
