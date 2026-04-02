class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list ,int[] candidates, int target, int sum, int index){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;

        if(index >= candidates.length) return;

        list.add(candidates[index]);
        backtrack(res, list, candidates, target,sum + candidates[index], index+1);
        list.remove(list.size() - 1);
        while(index +1 < candidates.length && candidates[index] == candidates[index+1]){
            index = index +1;
        }
        backtrack(res, list, candidates, target, sum , index +1);
    }
}
