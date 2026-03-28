class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(p.length() > s.length()) return list;
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        int left = 0 , right = 0;
        while(right < p.length()){
            pFreq[p.charAt(right) - 'a']++;
            sFreq[s.charAt(right)-'a']++;
            right++;
        }
        right--;

        while(right < s.length()){
            if(containsAll(sFreq, pFreq)){
                list.add(left);
            }
            right++;

            if(right != s.length()){
                sFreq[s.charAt(right) - 'a']++;
            }

            sFreq[s.charAt(left) - 'a']--;
            left++;
        }
        return list;
    }

    public boolean containsAll(int[] sFreq, int[] pFreq){
        for(int i = 0 ;i < 26 ;i++){
            if(sFreq[i] != pFreq[i]){
                return false;
            }
        }
        return true;
    }
}
