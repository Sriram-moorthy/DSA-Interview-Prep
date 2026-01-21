class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max=0;
        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        for(int num:set){
            int count=0;
            if(set.contains(num-1)){
                continue;
            }else{
                while(set.contains(num)){
                    count++;
                    num++;
                }
            }
            longest=Math.max(longest,count);

        }
        return longest;
    }
}
