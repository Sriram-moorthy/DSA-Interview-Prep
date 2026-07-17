class Solution {
    public int rob(int[] nums) {
        return solve(nums, nums.length-1);        
    }
    private int solve(int[] nums, int ind){
        if(ind < 0) return 0;
        if(ind == 0) return nums[ind];

        int pick = nums[ind] + solve(nums,ind-2);
        int notPick = solve(nums, ind-1);

        return Math.max(pick, notPick);
    }
}
