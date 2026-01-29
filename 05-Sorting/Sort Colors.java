//Solved using dutch national flag algorithm

class Solution {
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==2){
                swap(nums,mid,high--);
            }
            else if(nums[mid]==0){
                swap(nums,low++,mid++);
            }else{
                mid++;
            }
        }
    }
    public void swap(int[] nums,int first,int second){
            int temp=nums[first];
            nums[first]=nums[second];
            nums[second]=temp;
    }
}
