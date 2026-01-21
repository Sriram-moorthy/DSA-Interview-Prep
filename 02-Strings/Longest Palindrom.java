class Solution {
    public int longestPalindrome(String s) {
        int[] hash = new int[128];
        for(char ch : s.toCharArray()){
            hash[ch-'0']++;
        }
        int ans=0;
        boolean flag = true;
        for(int i=0;i<hash.length;i++){
            if(hash[i]%2==0){
                ans+=hash[i];
            }else{
                if(flag){
                    ans+=hash[i];
                    flag=false;
                }else{
                    ans+=hash[i]-1;
                }
            }
        }
        return ans;
    }
}
