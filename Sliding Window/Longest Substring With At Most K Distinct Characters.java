class Solution {
    public int kDistinctChar(String s, int k) {
        int left = 0, right = 0, maxLen = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(right < s.length()){
            char ch = s.charAt(right);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size() == k){
                maxLen = Math.max(maxLen, (right - left)+1);
            }
            
            while(map.size() > k){
                char ch1 = s.charAt(left);
                map.put(ch1,map.getOrDefault(ch1,0)-1);
                if(map.get(ch1) == 0){
                    map.remove(ch1);
                }
                left++;
            }
            
            right++;
        }
        return maxLen;
    }
}
