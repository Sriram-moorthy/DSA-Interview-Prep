class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int n:nums1){
            set.add(n);
        }
        for(int i:nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        int index=0;
        for(int num:res){
            ans[index]=num;
            index++;
        }
        return ans;
    }
}
