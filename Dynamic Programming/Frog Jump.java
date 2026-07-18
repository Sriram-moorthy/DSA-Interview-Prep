class Solution {
    int minCost(int[] heights) {
        // code here
        int prev = 0;
        int prev2 = 0;
        int curr = 0;

        int secondStep = Integer.MAX_VALUE;
        for(int i = 1 ; i < heights.length ;i++){
            int firstStep = prev + Math.abs(heights[i] - heights[i-1]);
            
            if(i > 1){
                secondStep = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
            
            curr = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = curr;
            
        }
        return curr;
    }
}
