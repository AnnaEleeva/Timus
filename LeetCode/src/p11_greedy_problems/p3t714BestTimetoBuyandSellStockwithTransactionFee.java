package p11_greedy_problems;

public class p3t714BestTimetoBuyandSellStockwithTransactionFee {

    public static void main(String[] args) {
        int[] prices={1,3,2,8,4,9};
        int[] prices2={1,3,7,5,10,3};
        int[] prices3={1,4,6,2,8,3,10,14};
        System.out.println(maxProfit(prices3,3));
    }
    //суммируем подъемы просто!
    public static int maxProfit(int[] prices,int fee) {
        //int profit=0;
        boolean wasRise=false;

        int rise=0;
        //если последняя вершина - пик => опустим его
        if(prices[prices.length-1]>prices[prices.length-2]){
            prices[prices.length-1]=prices[prices.length-1]-fee;
        }

        for(int i= prices.length-2;i>=1;i--){
            //если нашли пик, то опустим его на fee
            if(prices[i]>prices[i-1]&&prices[i]>prices[i+1]){
              prices[i]=prices[i]-fee;
            }
        }

        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
 //        wasRise=false;
//        for(int i=1;i<prices.length;i++){
//            if(prices[i]>prices[i-1]){
//                profit+=prices[i]-prices[i-1];
//                wasRise=true;
//            }else if(prices[i]<prices[i-1] && wasRise){
//                profit=profit-fee;
//                wasRise=false;
//            }
//        }
//        return profit;
    }
}
