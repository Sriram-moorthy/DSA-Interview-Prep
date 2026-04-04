class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums , 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res , List<Integer> list, int[] nums, int index){
        
        if(index >= nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(res,list,nums,index+1);
        list.remove(list.size()-1);
        while(index +1 < nums.length && nums[index] == nums[index+1]){
            index = index+1;
        }
        backtrack(res,list,nums,index+1);

    }
}
