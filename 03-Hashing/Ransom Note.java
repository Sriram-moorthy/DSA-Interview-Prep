class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int[] freq = new int[26];
        for(char ch:magazine.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:ransomNote.toCharArray()){
            freq[ch-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]<0){
                return false;
            }
        }
        return true;
    }
}
