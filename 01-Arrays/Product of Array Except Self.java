class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int[] prefixProd=new int[nums.length];
        int[] suffixProd= new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            prod=prod*nums[i];
            prefixProd[i]=prod;
        }

        prod=1;
        for(int j=nums.length-1;j>=0;j--){
            prod=prod*nums[j];
            suffixProd[j]=prod;
        }

        nums[0]=suffixProd[1];
        nums[nums.length-1]=prefixProd[nums.length-2];

        for(int k=1;k<nums.length-1;k++){
            nums[k]=prefixProd[k-1]*suffixProd[k+1];
        }
        return nums;
    }
}
