class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                count++;
                dfs(isConnected,i,visited);
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, int i, boolean[] visited){
        for(int j = 0 ; j < isConnected[i].length; j++){
            if(visited[j] == false && isConnected[i][j] == 1){
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }
}
