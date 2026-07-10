class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, temp, adj, vis);
                components.add(temp);
            }
        }
        return components;
        
    }
    public void dfs(int node, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        temp.add(node);
        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei, temp, adj, vis);
            }
            
        }
    }
}
