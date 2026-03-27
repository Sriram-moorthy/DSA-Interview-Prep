class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int maxLength = 0, currLength = 0;
        while(end < s.length()){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }else{
                set.add(s.charAt(end));
                currLength = (end - start) + 1;
                if(currLength > maxLength){
                    maxLength = currLength;
                }
                end++;
            }
            
        }
        return maxLength;
    }
}
