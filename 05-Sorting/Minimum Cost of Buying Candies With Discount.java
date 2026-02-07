class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int minCost=0;
        int i=cost.length-1,j=cost.length-2;
        while(i>=0 && j>=0){
            minCost+=(cost[i]+cost[j]);
            i=i-3;
            j=j-3;
        }
        while(i>=0){
            minCost+=cost[i];
            i=i-3;
        }
        while(j>=0){
            minCost+=cost[j];
            j=j-3;
        }
        return minCost;
    }
}
