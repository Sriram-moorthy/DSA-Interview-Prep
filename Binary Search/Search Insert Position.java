class Solution {
    public int searchInsert(int[] nums, int target) {
        int result=binarySearch(nums,target,nums.length);
        return result;
    }
    public int binarySearch(int[] nums,int target,int n){
        int ans=n;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
