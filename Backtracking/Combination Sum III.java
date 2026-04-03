class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 0,1);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list, int k, int n, int sum,int num){
        if(sum == n && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > n) return;
        if(num > 9 ) return;
        list.add(num);
        backtrack(res, list, k, n, sum+num, num+1);
        list.remove(list.size()-1);
        backtrack(res, list, k, n, sum, num+1);
    }
}
