class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] charFreq = new int[128];
        int[] windowFreq = new int[128];

        for(int i=0 ;i < t.length() ;i++){
            charFreq[t.charAt(i)]++;
        }

        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        for(int right = 0 ;right < s.length() ;right++){
            windowFreq[s.charAt(right)]++;

            while(containsAll(charFreq, windowFreq)){
                int currStringLength = (right - left) + 1;
                if(currStringLength < minLen){
                    minLen = currStringLength;
                    start = left;
                }
                windowFreq[s.charAt(left)]--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    public boolean containsAll(int[] charFreq, int[] windowFreq){
        for(int i = 0 ;i < 128 ;i++){
            if(charFreq[i] > windowFreq[i]){
                return false;
            }
        }
        return true;
    }
}
