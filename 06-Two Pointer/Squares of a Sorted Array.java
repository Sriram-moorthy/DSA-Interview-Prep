class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr=new int[nums.length];
        int left=0,right=nums.length-1,k=nums.length-1;
        while(left<=right && k>=0){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                arr[k]=nums[left]*nums[left];
                left++;
            }else{
                arr[k]=nums[right]*nums[right];
                right--;
            }
            k--;
        }
        return arr;
    }
}
