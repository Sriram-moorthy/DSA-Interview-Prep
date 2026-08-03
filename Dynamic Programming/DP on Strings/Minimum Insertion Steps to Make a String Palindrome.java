class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String reversed = sb.toString();

        int[][] dp = new int[n+1][n+1];
        for(int i = 0 ; i <= n ;i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i-1) == reversed.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[n][n];
    }
}
