class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);
            
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int windowLength = (right - left) + 1;

            int charNeedToBeChanged = windowLength - maxFreq;

            if(charNeedToBeChanged > k){
                char c = s.charAt(left);
                freq[c - 'A']--;
                left++;
            }
            windowLength = (right - left) + 1;
            maxWindow = Math.max(maxWindow, windowLength);
        }
        return maxWindow;
    }
}
