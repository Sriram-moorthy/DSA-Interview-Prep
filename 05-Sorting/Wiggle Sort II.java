class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int res[] = new int[nums.length];
        int mid=(nums.length-1)/2;
        int right=nums.length-1;
        int ctr=0;
        while(mid>=0 || right>(nums.length-1)/2){
            res[ctr]=nums[mid];
            mid--;
            ctr++;
            if(ctr<nums.length){
                res[ctr]=nums[right];
                right--;
                ctr++;
            }
            
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
    }
}
