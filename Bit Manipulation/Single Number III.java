class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;
        for(int i = 0 ; i < nums.length ; i++){
            xor = xor ^ nums[i];
        }
        long num =(xor & (xor-1)) ^ xor;
        int num1 = 0 , num2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if((num & nums[i] )!= 0){
                num1 = num1 ^ nums[i];
            }else{
                num2 = num2 ^ nums[i];
            }
        }
        return new int[]{num1, num2};
    }
}
