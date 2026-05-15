class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] hash = new int[3];
        Arrays.fill(hash,-1);
        for(int i = 0 ;i < s.length() ;i++){
            hash[s.charAt(i) - 'a'] = i;
             if(hash[0] != -1 && hash[1] != -1 & hash[2] != -1){
                count = count + (1+ min(hash[0],hash[1],hash[2]));
             }
        }
        return count;
    }
    public int min(int a, int b, int c){
        if(a < b && a < c){
            return a;
        }
        else if(b < c){
            return b;
        }
        return c;
    }
}
