class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        
        int[] temp1 = new int[nums.length-1];
        int[] temp2 = new int[nums.length-1];

        for(int i = 0 ; i < nums.length-1; i++){
            temp1[i] = nums[i];
        }
        for(int i = 1 ; i < nums.length; i++){
            temp2[i-1] = nums[i];
        }

        return Math.max(solve(temp1), solve(temp2));
     }
     private int solve(int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        int curr = 0;

        for(int i = 1; i < nums.length ;i++){
            int take = nums[i];
            if(i > 1) take += prev2;

            int notTake = prev;

            curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;

        }
        return prev;
     }
}
