class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++){
            minSoFar=Math.min(minSoFar,prices[i]);
            profit=Math.max(profit,prices[i]-minSoFar);
        }
        return profit;
    }
}
